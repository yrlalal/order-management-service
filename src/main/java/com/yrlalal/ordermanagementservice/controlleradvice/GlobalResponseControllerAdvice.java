package com.yrlalal.ordermanagementservice.controlleradvice;

import com.yrlalal.ordermanagementservice.v1.entity.ErrorResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class GlobalResponseControllerAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body == null) {
            return null;
        }

        if (body instanceof ErrorResponse<?>) {
            return body;
        }

        if (body instanceof ResponseEntity<?> responseEntity) {
            return new ResponseWrapper<>(body, responseEntity.getStatusCode().value());
        }

        return new ResponseWrapper<>(body, HttpStatus.OK.value());
    }


    @Getter
    @Setter
    @AllArgsConstructor
    private static class ResponseWrapper<T> {
        private T body;
        private Integer status;
    }
}
