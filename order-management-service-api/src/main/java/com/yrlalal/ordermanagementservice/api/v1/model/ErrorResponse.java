package com.yrlalal.ordermanagementservice.api.v1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse<T> {
    private T message;
    private Integer status;
}
