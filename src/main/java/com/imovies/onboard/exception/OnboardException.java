package com.imovies.onboard.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class OnboardException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public OnboardException(String message) {
        super(message);
    }
}
