package com.ryuri.rinha.config.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request) {

        ApiErrorMessage apiErrorMessage = new ApiErrorMessage(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage());

        return new ResponseEntity<>(null, headers, apiErrorMessage.getStatus());
    }

    @ExceptionHandler(ClienteNotFoundException.class)
    public ResponseEntity<Object> handleClienteNotFoundException(
            ClienteNotFoundException exception, WebRequest request) {

        ApiErrorMessage apiErrorMessage = new ApiErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());

        return new ResponseEntity<>(null, new HttpHeaders(), apiErrorMessage.getStatus());
    }

    @ExceptionHandler(TipoTransacoesException.class)
    public ResponseEntity<Object> handleTipoTransacoesException(
            TipoTransacoesException exception, WebRequest request) {

        ApiErrorMessage apiErrorMessage = new ApiErrorMessage(HttpStatus.UNPROCESSABLE_ENTITY, exception.getMessage());

        return new ResponseEntity<>(null, new HttpHeaders(), apiErrorMessage.getStatus());
    }
}
