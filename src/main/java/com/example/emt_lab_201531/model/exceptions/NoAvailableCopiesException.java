package com.example.emt_lab_201531.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NoAvailableCopiesException extends RuntimeException {
    public NoAvailableCopiesException() {
        super("Copies 404");
    }
}
