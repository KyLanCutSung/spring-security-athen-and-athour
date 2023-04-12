package com.example.test.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SignInForm {
    private String username;
    private String password;
}
