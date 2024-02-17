package com.ryuri.rinha.config.exception;

public class ClienteNotFoundException extends RuntimeException {

    public ClienteNotFoundException(Long id) {
        super(String.format("Cliente com id %d não encontrado.", id));
    }
}
