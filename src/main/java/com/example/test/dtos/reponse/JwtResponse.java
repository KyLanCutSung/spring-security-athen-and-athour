package com.example.test.dtos.reponse;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
@Data
@Getter
@Setter
public class JwtResponse {
    private Long id;
    private String token;
    private String type = "Bearer";
    private String refreshToken;
    private String name;
    private Collection<? extends GrantedAuthority> roles;

//    public JwtResponse(){
//
//    }
//    public JwtResponse(Long id, String accessToken, String refreshToken, String type, String name, Collection<? extends GrantedAuthority> roles) {
//        this.id = id;
//        this.token = accessToken;
//        this.refreshToken = refreshToken;
//        this.type = type;
//        this.name = name;
//        this.roles = roles;
//    }

    public JwtResponse(Long id, String accessToken, String refreshToken, String name, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.token = accessToken;
        this.refreshToken = refreshToken;
        this.name = name;
        this.roles = authorities;
    }
}
