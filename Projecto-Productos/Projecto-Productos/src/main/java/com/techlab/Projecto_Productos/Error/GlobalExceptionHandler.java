package com.techlab.Projecto_Productos.Error;

import jakarta.persistence.EntityNotFoundException;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    //404
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentRequest(IllegalArgumentException ex) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .statusCode(400)
                .error("Bad Request")
                .message(ex.getMessage())
                .build();
        return ResponseEntity.badRequest().body(errorResponse);
    }

    @ExceptionHandler(HttpClientErrorException.BadRequest.class)
    public ResponseEntity<ErrorResponse> handleBadRequest(HttpClientErrorException.BadRequest ex) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .statusCode(400)
                .error("Bad Request")
                .message(ex.getMessage())
                .build();
        return ResponseEntity.badRequest().body(errorResponse);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEntityNotFound (EntityNotFoundException ex){
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(ex.getMessage())
                .error("Not Found")
                .statusCode(404)
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleInternalServerError (Exception e){
        ErrorResponse errorResponse = ErrorResponse.builder()
                .error("500")
                .statusCode(500)
                .message(e.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }




}
