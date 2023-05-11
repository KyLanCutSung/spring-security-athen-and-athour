package com.example.test.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class SignInForm {
    @NotNull
    private String username;

    private String password;
}
