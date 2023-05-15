package com.example.test.services;

import com.example.test.configs.jwts.JwtProvider;
import com.example.test.dtos.reponse.JwtResponse;
import com.example.test.dtos.reponse.ResponseMessage;
//import com.example.test.dtos.request.SignInForm;
import com.example.test.dtos.request.ForgotPasswordRequest;
import com.example.test.dtos.request.SignInForm;
import com.example.test.dtos.request.SignUpForm;
import com.example.test.dtos.request.UpdatePasswordRequest;
import com.example.test.entities.RefreshToken;
import com.example.test.entities.RoleEntity;
import com.example.test.entities.UserEntity;
import com.example.test.entities.UserPrinciple;
import com.example.test.enums.RoleName;
import com.example.test.repositories.UserRepository;
import com.example.test.services.impl.RoleServiceImpl;
import com.example.test.services.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserCustomDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Lazy
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtProvider jwtProvider;
    @Autowired
    private RefreshTokenService refreshTokenService;
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("Không tìm thấy user "+username+" trong database"));
        return UserPrinciple.build(userEntity);
    }
    public void saveUser(SignUpForm signUpForm){
        UserEntity userEntity = new UserEntity(signUpForm.getEmail(),
                signUpForm.getName(),
                signUpForm.getUsername(),
                signUpForm.getPhone(),
                signUpForm.getCountryId(),
                passwordEncoder.encode(signUpForm.getPassword()));
        Set<String> strRoles = signUpForm.getRoles();
        Set<RoleEntity> roleEntities = new HashSet<>();
        strRoles.forEach(role ->{
            switch (role){
                case "admin":
                    RoleEntity adminRole = roleService.findByRoleName(RoleName.ADMIN.name()).orElseThrow(
                            () -> new RuntimeException("Role not found")
                    );
                    roleEntities.add(adminRole);
                    break;
                case "pm":
                    RoleEntity pmRole = roleService.findByRoleName(RoleName.PM.name()).orElseThrow(
                            () -> new RuntimeException("Role not found")
                    );
                    roleEntities.add(pmRole);
                    break;
                default:
                    RoleEntity userRole = roleService.findByRoleName(RoleName.USER.name()).orElseThrow(
                            () -> new RuntimeException("Role not found")
                    );
                    roleEntities.add(userRole);
            }
        });
        userEntity.setRoleEntities(roleEntities);
        userService.save(userEntity);
    }
    public JwtResponse login(SignInForm signInForm){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInForm.getUsername(), signInForm.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        String token = jwtProvider.generateJwtToken(userPrinciple);
        RefreshToken refreshToken = refreshTokenService.createRefreshToken(userPrinciple.getUserId());
        JwtResponse jwtResponse = new JwtResponse(userPrinciple.getUserId() ,token, refreshToken.getToken(), userPrinciple.getName(), userPrinciple.getAuthorities());
        return jwtResponse;
    }

    public void updatePassword(UpdatePasswordRequest updatePasswordRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(updatePasswordRequest.getUsername(), updatePasswordRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        UserEntity userEntity = userRepository.findByUsername(userPrinciple.getUsername()).get();
        userEntity.setPassword(passwordEncoder.encode(updatePasswordRequest.getNewPassword()));
        userRepository.save(userEntity);
    }

    public void forgotPassword(ForgotPasswordRequest forgotPasswordRequest){
        Optional<UserEntity> userEntity = userRepository.findByEmail(forgotPasswordRequest.getEmail());
        if(userEntity.isPresent()){
            userEntity.get().setPassword(passwordEncoder.encode(forgotPasswordRequest.getNewPassword()));
            userRepository.save(userEntity.get());
        } else {
            throw new EntityNotFoundException("User is not existed!");
        }
    }
}
