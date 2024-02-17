package com.ryuri.rinha.resource;

import com.ryuri.rinha.domain.Cliente;
import com.ryuri.rinha.domain.ClienteSaldo;
import com.ryuri.rinha.dto.request.ClienteRequest;
import com.ryuri.rinha.dto.request.TransacoesRequest;
import com.ryuri.rinha.dto.response.TransacoesResponse;
import com.ryuri.rinha.service.ClienteService;
import com.ryuri.rinha.service.TransacoesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService service;

    @Autowired
    private TransacoesService transacoesService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ClienteSaldo createCliente(@RequestBody ClienteRequest request) {
        return service.cadastrarCliente(request);
    }

//    @RequestMapping("create")
//    @PostMapping("/createall")
//    @ResponseStatus(HttpStatus.OK)
//    public List<Cliente> initialClientes() {
//        return service.inicializaClientes();
//    }

    @GetMapping("/{id}")
    public Cliente findById(@PathVariable Long id) {
        return service.findById(id);
    }

//    @GetMapping("/{id}/extrato")
//    @ResponseStatus(HttpStatus.OK)
//    public void extratoByIdCliente(@PathVariable Long id) {
//
//    }

    @PostMapping("{id}/transacoes")
    public TransacoesResponse createTransacoes(@PathVariable Long id, @Valid @RequestBody TransacoesRequest request) {
        return service.debitarCreditar(id, request);

    }
}
