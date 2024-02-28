package com.yrlalal.ordermanagementservice.v1.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse<T> {
    private T message;
    private Integer status;
}
