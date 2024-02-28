package com.yrlalal.ordermanagementservice.controlleradvice;

import com.yrlalal.ordermanagementservice.exception.BadRequestException;
import com.yrlalal.ordermanagementservice.exception.OrderNotFoundException;
import com.yrlalal.ordermanagementservice.v1.entity.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse<String>> handleException(BadRequestException ex) {
        return getErrorResponseEntity(ex, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<ErrorResponse<String>> handleException(OrderNotFoundException ex) {
        return getErrorResponseEntity(ex, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse<String>> handleException(Exception ex) {
        return getErrorResponseEntity(ex, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<ErrorResponse<String>> getErrorResponseEntity(Exception ex, HttpStatus status) {
        logger.error(ex.getMessage());
        return new ResponseEntity<>(new ErrorResponse<>(ex.getMessage(), status.value()), status);
    }
}
