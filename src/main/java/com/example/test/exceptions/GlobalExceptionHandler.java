package com.example.test.exceptions;

import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> handleUnwantedException(NotFoundException e){
        return  ResponseEntity.status(400).body("đối tượng không tồn tại") ;
    }

    @ExceptionHandler(TokenRefreshException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> expirationTokenException(Exception e){
        return ResponseEntity.status(400).body(e.getMessage());
    }

    @ExceptionHandler(RequestNotPermitted.class)
    public ResponseEntity<?> tooManyRequest(RequestNotPermitted e){
        return ResponseEntity.status(429).body("Too many request");
    }
    @ExceptionHandler(PageEndException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseEntity<?> pageEnd(PageEndException e){
        return ResponseEntity.status(404).body(e.getMessage());
    }
}
