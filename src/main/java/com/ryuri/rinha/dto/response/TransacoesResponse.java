package com.ryuri.rinha.dto.response;

import java.math.BigInteger;

public class TransacoesResponse {

    private Integer limite;

    private Integer saldo;

    public static TransacoesResponse valueOf(Integer limite, Integer saldo) {
        TransacoesResponse response = new TransacoesResponse();
        response.saldo = saldo;
        response.limite = limite;
        return response;
    }

    public Integer getLimite() {
        return limite;
    }

    public void setLimite(Integer limite) {
        this.limite = limite;
    }

    public Integer getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }
}
