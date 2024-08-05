package com.ultimatron.erp.controllers;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GestionException {

    @ExceptionHandler({ExpiredJwtException.class})
    public ResponseEntity getExpiredJwtException(ExpiredJwtException e) {
        return ResponseEntity.status(401).body("Error ExpiredJwtException:" + e.getMessage());
    }

    @ExceptionHandler({JwtException.class})
    public ResponseEntity getJwtException(JwtException e) {
        return ResponseEntity.status(401).body("Error JwtException:" + e.getMessage());
    }

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity getRuntimeException(RuntimeException e) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("401", "Please login!");
        String error = errorMap.get(e.getMessage());
        if (error == null) {
            return ResponseEntity.status(500).body("Internal Server Error");
        } else return ResponseEntity.status(Integer.valueOf(e.getMessage())).body(error);
    }
}
