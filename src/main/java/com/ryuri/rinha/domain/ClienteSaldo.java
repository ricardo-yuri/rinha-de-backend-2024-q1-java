package com.ryuri.rinha.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ClienteSaldo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idCliente;

    private Integer saldo = 0;

    private Integer limite = 0;

    public static ClienteSaldo valueOf(Long idCliente, Integer saldo, Integer limite) {
        ClienteSaldo clienteSaldo = new ClienteSaldo();
        clienteSaldo.setIdCliente(idCliente);
        clienteSaldo.setSaldo(saldo);
        clienteSaldo.setLimite(limite);
        return clienteSaldo;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }

    public Integer getLimite() {
        return limite;
    }

    public void setLimite(Integer limite) {
        this.limite = limite;
    }
}
