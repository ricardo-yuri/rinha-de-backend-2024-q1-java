package com.ryuri.rinha.service;

import com.ryuri.rinha.config.exception.ClienteNotFoundException;
import com.ryuri.rinha.domain.Cliente;
import com.ryuri.rinha.domain.ClienteSaldo;
import com.ryuri.rinha.domain.Transacoes;
import com.ryuri.rinha.dto.request.ClienteRequest;
import com.ryuri.rinha.dto.request.TransacoesRequest;
import com.ryuri.rinha.dto.response.TransacoesResponse;
import com.ryuri.rinha.mapper.ClienteMapper;
import com.ryuri.rinha.mapper.TransacoesMapper;
import com.ryuri.rinha.repository.ClienteRepository;
import com.ryuri.rinha.repository.ClienteSaldoRepository;
import com.ryuri.rinha.repository.TransacoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private ClienteSaldoRepository saldoRepository;

    @Autowired
    private TransacoesRepository transacoesRepository;

    public Cliente findById(Long id) {
        Optional<Cliente> optional = repository.findById(id);

        if(optional.isEmpty()) {
            throw new ClienteNotFoundException(id);
        }

        return optional.get();
    }

    public TransacoesResponse debitarCreditar(Long id, TransacoesRequest request) {
        Cliente cliente = findById(id);
        Transacoes transacao = TransacoesMapper.TransacoesRequestToEntity(id , request);
        ClienteSaldo clienteSaldo = saldoRepository.findByIdCliente(cliente.getId());

        Integer saldo = clienteSaldo.getSaldo();

        if(transacao.getTipo() == 'd' || transacao.getTipo() == 'D') {
            if(clienteSaldo.getLimite() < saldo - transacao.getValor() || clienteSaldo.getLimite() + (saldo - transacao.getValor()) < 0) {
                throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
            }
            saldo -= transacao.getValor();
        } else {
            saldo += transacao.getValor();
        }

        clienteSaldo.setSaldo(saldo);
        ClienteSaldo saldoFinal = saldoRepository.save(clienteSaldo);
        transacoesRepository.save(transacao);

        return TransacoesResponse.valueOf(saldoFinal.getLimite(), saldoFinal.getSaldo());

    }

    public ClienteSaldo cadastrarCliente(ClienteRequest request) {
        Cliente cliente = repository.save(ClienteMapper.toEntityCliente(request));
        return saldoRepository.save(ClienteMapper.toEntityClienteSaldo(request, cliente));
    }

}
