package com.hoang2001giang.Libra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class ApiExceptionHandler {
    /**
     * Other Exceptions
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage handleAllException(Exception ex, WebRequest request) {
        // quá trình kiểm soat lỗi diễn ra ở đây
        return new ErrorMessage(10000, ex.getLocalizedMessage());
    }

    /**
     * IndexOutOfBoundsException
     */
    @ExceptionHandler(IndexOutOfBoundsException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage handleIndexOutOfBoundsException(Exception ex, WebRequest request) {
        return new ErrorMessage(10100, ex.getLocalizedMessage());
    }

    /**
     * IndexOutOfBoundsException
     */
    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage handleNoSuchElementException(Exception ex, WebRequest request) {
        return new ErrorMessage(10100, ex.getLocalizedMessage());
    }
}
