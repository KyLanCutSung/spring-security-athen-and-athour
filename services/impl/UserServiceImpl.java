package com.example.test.services.impl;

import com.example.test.dtos.RoleDto;
import com.example.test.dtos.UserDto;
import com.example.test.entities.UserEntity;
import com.example.test.models.countries.dtos.CountryDto;
import com.example.test.repositories.UserRepository;
import com.example.test.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    private ModelMapper modelMapper = new ModelMapper();
    private UserDto entityToDto(UserEntity userEntity) {
        UserDto userDto = new UserDto();
        userDto = modelMapper.map(userEntity, UserDto.class);
        List<RoleDto> roleDtos = userEntity.getRoleEntities().stream().map(en->modelMapper.map(en, RoleDto.class)).collect(Collectors.toList());
        CountryDto countryDto = modelMapper.map(userEntity.getCountryEntity(), CountryDto.class);
        userDto.setCountryDto(countryDto);
        userDto.setRoleDtoList(roleDtos);
        return userDto;
    }
    private List<UserDto> entitiesToDtos(List<UserEntity> userEntities){
        List<UserDto> userDtos = userEntities.stream().map(en -> entityToDto(en)).collect(Collectors.toList());
        return userDtos;
    }
    @Override
    public Optional<UserEntity> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public UserEntity save(UserEntity userEntity){
        return userRepository.save(userEntity);
    }
    @Override
    public List<UserDto> getAll(){
        List<UserEntity> userEntities = userRepository.findAll();
        List<UserDto> userDtos = entitiesToDtos(userEntities);
        return userDtos;
    }
    @Override
    public UserDto findByUserId(Long userId){
        UserDto userDto = new UserDto();
        Optional<UserEntity> userEntity = userRepository.findById(userId);
        if(userEntity.isPresent()){
            userDto = entityToDto(userEntity.get());
        }
        else{
            throw new EntityNotFoundException("Không tìm thấy user!");
        }
        return userDto;
    }
}
