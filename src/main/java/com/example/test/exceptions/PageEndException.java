package com.example.test.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.EntityNotFoundException;

@Getter
@AllArgsConstructor

public class PageEndException extends EntityNotFoundException {
    private String message;
}
