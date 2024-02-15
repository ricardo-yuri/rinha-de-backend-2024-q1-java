package com.ryuri.rinha.service;

import com.ryuri.rinha.domain.Transacoes;
import com.ryuri.rinha.dto.request.TransacoesRequest;
import com.ryuri.rinha.mapper.TransacoesMapper;
import com.ryuri.rinha.repository.TransacoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransacoesService {

    @Autowired
    private TransacoesRepository repository;

    @Autowired
    private ClienteService clienteService;

    public Transacoes createTransacoes(Long id, TransacoesRequest request) {
        clienteService.findById(id);
        Transacoes transacoes = TransacoesMapper.TransacoesRequestToEntity(id, request);
        return repository.save(transacoes);
    }
}
