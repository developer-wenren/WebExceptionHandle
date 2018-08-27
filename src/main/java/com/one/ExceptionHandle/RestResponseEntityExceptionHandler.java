package com.one.ExceptionHandle;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * @author One
 */ /*
- 
- Coding By One ON 08/27
*/
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {IllegalArgumentException.class, IllegalStateException.class})
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "This should be application specific";
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.OK, request);
    }

    @ExceptionHandler(value = {ArrayIndexOutOfBoundsException.class})
    protected ResponseEntity  handlerException(RuntimeException ex,WebRequest request) {
        // 报警日志记录

        // 拼装异常返回信息
        Map<String, Object> bodyOfResponse = new HashMap<>(16);
        bodyOfResponse.put("code", 500);
        bodyOfResponse.put("message", ex.getMessage());
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
}
