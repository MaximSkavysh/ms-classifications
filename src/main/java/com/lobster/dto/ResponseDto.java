package com.lobster.dto;

import com.lobster.handler.CustomErrorResponse;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ResponseDto<T> {
    private T data;
    private HttpStatus status;
    private CustomErrorResponse errorResponse;

    public ResponseDto(CustomErrorResponse errorResponse, HttpStatus status) {
        this.errorResponse = errorResponse;
        this.status = status;
    }
}
