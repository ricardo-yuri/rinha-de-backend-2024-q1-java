package com.ryuri.rinha.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.ryuri.rinha.domain.Transacoes;

import java.util.List;

@JsonPropertyOrder({"saldo, ultimas_transacoes"})
public class ExtratoDto {

    @JsonProperty("saldo")
    private SaldoDto saldoDto;

    @JsonProperty("ultimas_transacoes")
    private List<Transacoes> ultimasTransacoes;

    public SaldoDto getSaldoDto() {
        return saldoDto;
    }

    public void setSaldoDto(SaldoDto saldoDto) {
        this.saldoDto = saldoDto;
    }

    public List<Transacoes> getUltimasTransacoes() {
        return ultimasTransacoes;
    }

    public void setUltimasTransacoes(List<Transacoes> ultimasTransacoes) {
        this.ultimasTransacoes = ultimasTransacoes;
    }
}
