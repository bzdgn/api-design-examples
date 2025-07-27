package io.github.bzdgn.apidesign.openapi.exceptionhandling;

import io.github.bzdgn.apidesign.openapi.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(GenericResponseException.class)
    public ResponseEntity<ErrorDTO> handleBookNotFound(GenericResponseException ex) {
        ErrorDTO error = new ErrorDTO();
        error.setCode(404);
        error.setStatus("NOT_FOUND");
        error.setMessage(ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

}

