package com.ryuri.rinha.mapper;

import com.ryuri.rinha.domain.Cliente;
import com.ryuri.rinha.domain.ClienteSaldo;
import com.ryuri.rinha.dto.request.ClienteRequest;

public class ClienteMapper {

    public static Cliente toEntityCliente(ClienteRequest request) {
        return new Cliente(request.getNome());
    }

    public static ClienteSaldo toEntityClienteSaldo(ClienteRequest request, Cliente cliente) {
        return ClienteSaldo.valueOf(cliente.getId(), request.getSaldo(), request.getLimite());
    }
}
