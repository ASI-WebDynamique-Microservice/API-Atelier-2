package com.sp.config;

import com.sp.DTO.ErreurDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Gestion des erreurs HTTP et transformation des exceptions en JSON
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResponseEntity<ErreurDTO> handle(RuntimeException runtimeException) {
        return ResponseEntity.badRequest()
                .body(new ErreurDTO().setMessage(runtimeException.getMessage()));
    }

}
