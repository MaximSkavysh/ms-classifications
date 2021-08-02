package com.lobster.handler;

import com.lobster.dto.ResponseDto;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.function.Supplier;

public class ResponseHandler {

    private ResponseHandler() {
    }

    public static <T> ResponseDto<T> execute(Supplier<T> supplier, HttpStatus status) {
        ResponseDto<T> response = new ResponseDto<>();
        try {
            response.setData(supplier.get());
            response.setStatus(status);
        } catch (Exception e) {
            Throwable cause = getCause(e);
            response.setErrorResponse(new CustomErrorResponse(List.of(cause.getMessage())));
            response.setStatus(HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    private static Throwable getCause(Throwable e) {
        Throwable cause;
        Throwable result = e;

        while (null != (cause = result.getCause()) && (result != cause)) {
            result = cause;
        }
        return result;
    }


}
