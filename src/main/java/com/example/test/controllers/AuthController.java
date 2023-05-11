package com.example.test.controllers;

import com.example.test.configs.jwts.JwtProvider;
import com.example.test.dtos.reponse.ResponseMessage;
import com.example.test.dtos.reponse.TokenRefreshResponse;
import com.example.test.dtos.request.SignInForm;
import com.example.test.dtos.request.SignUpForm;
import com.example.test.dtos.request.TokenRefreshRequest;
import com.example.test.entities.RefreshToken;
import com.example.test.exceptions.TokenRefreshException;
import com.example.test.services.RefreshTokenService;
import com.example.test.services.UserCustomDetailService;
import com.example.test.services.impl.UserServiceImpl;
import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/auth")
@RestController
@CrossOrigin("http://localhost:3000/login")
public class AuthController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private UserCustomDetailService userCustomDetailService;
    @Autowired
    private RefreshTokenService refreshTokenService;
    @Autowired
    JwtProvider jwtProvider;
    @PostMapping("/signup")
    public ResponseEntity<?> register(@RequestBody SignUpForm signUpForm){
        if(userService.existsByUsername(signUpForm.getUsername())){
            return new ResponseEntity<>(new ResponseMessage("The username existed: Please try again!"), HttpStatus.OK);
        }
        if(userService.existsByEmail(signUpForm.getEmail())){
            return new ResponseEntity<>(new ResponseMessage("The email existed! Please try again!"), HttpStatus.OK);
        }
        userCustomDetailService.saveUser(signUpForm);
        return new ResponseEntity<>(new ResponseMessage("Create user success!"), HttpStatus.OK);
    }
    @PostMapping("/signin")
    @RateLimiter(name = "rateLimiterAPI")
    public ResponseEntity<?> login(@RequestBody SignInForm signInForm){
            return ResponseEntity.ok(userCustomDetailService.login(signInForm));
    }
    @PostMapping("/refreshtoken")
    public ResponseEntity<?> refreshToken(@RequestBody TokenRefreshRequest request){
        String requestRefreshToken = request.getRefreshToken();
        return refreshTokenService.findByToken(requestRefreshToken)
                .map(refreshTokenService::verifyExpiration)
                .map(RefreshToken::getUserEntity)
                .map(userEntity -> {
                    String token = jwtProvider.generateTokenFromUsername(userEntity.getUsername());
                    return ResponseEntity.ok(new TokenRefreshResponse(token, requestRefreshToken));
                })
                .orElseThrow(()-> new TokenRefreshException(requestRefreshToken,"Refresh token is not in database"));
    }
}
