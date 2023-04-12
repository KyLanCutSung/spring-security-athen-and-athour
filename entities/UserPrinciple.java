package com.example.test.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
@Data
@Getter

public class UserPrinciple implements UserDetails {
    private Long userId;
    private String username;
    private String name;
    @JsonIgnore
    private String password;
    private String email;
    private String phone;
    private Collection<? extends GrantedAuthority> roles;

    public UserPrinciple(Long userId, String username, String name, String password, String email, String phone, Collection<? extends GrantedAuthority> roles) {
        this.userId = userId;
        this.username = username;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.roles = roles;
    }
    public static UserPrinciple build(UserEntity userEntity){
        List<GrantedAuthority> authorities = userEntity.getRoleEntities().stream().map(role ->
                new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
        return new UserPrinciple(
                userEntity.getUserId(),
                userEntity.getUsername(),
                userEntity.getName(),
                userEntity.getPassword(),
                userEntity.getEmail(),
                userEntity.getPhone(),
                authorities

        );
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
