package com.projetoestagio.projeto_estagio.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(BadRequestAlertException.class)
    public ResponseEntity<Object> handleBadRequest(BadRequestAlertException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.BAD_REQUEST.value());
        body.put("error", "Bad Request");
        body.put("message", ex.getMessage());
        body.put("entidade", ex.getEntityName());
        body.put("codigo", ex.getErrorKey());

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
}
