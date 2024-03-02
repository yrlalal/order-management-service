package com.yrlalal.ordermanagementservice.impl.controlleradvice;

import com.yrlalal.ordermanagementservice.api.v1.model.ErrorResponse;
import com.yrlalal.ordermanagementservice.impl.exception.BadRequestException;
import com.yrlalal.ordermanagementservice.impl.exception.OrderNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionControllerAdvice {
    Logger logger = LoggerFactory.getLogger(GlobalExceptionControllerAdvice.class);

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse<String>> handleException(BadRequestException ex) {
        return getErrorResponseEntity(ex, HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse<String>> handleException(MethodArgumentNotValidException ex) {
        return getErrorResponseEntity(ex, HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<ErrorResponse<String>> handleException(OrderNotFoundException ex) {
        return getErrorResponseEntity(ex, HttpStatus.NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse<String>> handleException(Exception ex) {
        return getErrorResponseEntity(ex, HttpStatus.INTERNAL_SERVER_ERROR, "An internal error occurred.");
    }

    private ResponseEntity<ErrorResponse<String>> getErrorResponseEntity(Exception ex, HttpStatus status, String message) {
        logger.error(ex.getMessage(), ex);
        return new ResponseEntity<>(new ErrorResponse<>(message, status.value()), status);
    }
}
