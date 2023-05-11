package com.example.test.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
public class SignUpForm {

    private String name;

    private String username;

    private String email;

    private String password;

    private String phone;

    private Long countryId;
    private Set<String> roles;
}
