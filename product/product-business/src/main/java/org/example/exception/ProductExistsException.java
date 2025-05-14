package org.example.exception;
import org.springframework.http.HttpStatus;
import vn.test.hub.core.exception.BaseException;

public class ProductExistsException extends BaseException {
    public ProductExistsException(String message, int code) {
        super(message, code, HttpStatus.CONFLICT);
    }

    public ProductExistsException(String message) {
        super(message, 40901, HttpStatus.CONFLICT);
    }
}
