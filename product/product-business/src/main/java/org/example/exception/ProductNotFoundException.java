package org.example.exception;

import org.springframework.http.HttpStatus;
import vn.test.hub.core.exception.BaseException;

public class ProductNotFoundException extends BaseException {
    public ProductNotFoundException(String message, int code) {
        super(message, code, HttpStatus.NOT_FOUND);
    }

    public ProductNotFoundException(String message) {
        super(message, 40004, HttpStatus.NOT_FOUND);
    }
}
