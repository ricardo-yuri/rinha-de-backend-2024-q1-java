package com.ryuri.rinha.resource;

import com.ryuri.rinha.domain.Cliente;
import com.ryuri.rinha.domain.ClienteSaldo;
import com.ryuri.rinha.dto.ExtratoDto;
import com.ryuri.rinha.dto.request.ClienteRequest;
import com.ryuri.rinha.dto.request.TransacoesRequest;
import com.ryuri.rinha.dto.response.TransacoesResponse;
import com.ryuri.rinha.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService service;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ClienteSaldo createCliente(@RequestBody ClienteRequest request) {
        return service.cadastrarCliente(request);
    }

    @GetMapping("/{id}")
    public Cliente findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("{id}/transacoes")
    public TransacoesResponse createTransacoes(@PathVariable Long id, @Valid @RequestBody TransacoesRequest request) {
        return service.debitarCreditar(id, request);
    }

    @GetMapping("{id}/extrato")
    @ResponseStatus(HttpStatus.OK)
    public ExtratoDto getExtrato(@PathVariable Long id) {
        return service.getExtrato(id);
    }
}
