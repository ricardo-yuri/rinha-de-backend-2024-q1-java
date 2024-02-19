package com.ryuri.rinha.mapper;

import com.ryuri.rinha.config.exception.TipoTransacoesException;
import com.ryuri.rinha.domain.Transacoes;
import com.ryuri.rinha.dto.request.TransacoesRequest;
import com.ryuri.rinha.dto.response.TransacoesResponse;

public abstract class TransacoesMapper {

    public static Transacoes TransacoesRequestToEntity(Long idCliente, TransacoesRequest request) {
        validaSeTipoECreditoOuDebito(request.getTipo());
        Transacoes transacoes = new Transacoes();
        transacoes.setDescricao(request.getDescricao());
        transacoes.setTipo(request.getTipo());
        transacoes.setIdCliente(idCliente);
        transacoes.setValor(request.getValor());
        return transacoes;

    }

    private static void validaSeTipoECreditoOuDebito(Character character) {
        if(!Transacoes.isValid(character)) {
            throw new TipoTransacoesException();
        }
    }
}
