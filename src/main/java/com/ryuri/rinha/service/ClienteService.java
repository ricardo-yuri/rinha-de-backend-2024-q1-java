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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private ClienteSaldoRepository saldoRepository;

//    public List<Cliente> inicializaClientes() {
//        List<Cliente> list = new java.util.ArrayList<>(List.of());
//        Cliente um = new Cliente("CLIENTE 01", 100000);
//        Cliente dois = new Cliente("CLIENTE 02", 80000);
//        Cliente tres = new Cliente("CLIENTE 03", 1000000);
//        Cliente quatro = new Cliente("CLIENTE 04", 10000000);
//        Cliente cinco = new Cliente("CLIENTE 05", 500000);
//
//        list.add(um);
//        list.add(dois);
//        list.add(tres);
//        list.add(quatro);
//        list.add(cinco);
//
//
//        return repository.saveAllAndFlush(list);
//    }

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

        if(transacao.getTipo() == 'c') {
//           clienteSaldo.getSaldo() += transacao.getValor();
        }
        return new TransacoesResponse();

    }

    public ClienteSaldo cadastrarCliente(ClienteRequest request) {
        Cliente cliente = repository.save(ClienteMapper.toEntityCliente(request));
        return saldoRepository.save(ClienteMapper.toEntityClienteSaldo(request, cliente));
    }

}
