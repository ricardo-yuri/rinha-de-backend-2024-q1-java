package com.ryuri.rinha.mapper;

import com.ryuri.rinha.domain.ClienteSaldo;
import com.ryuri.rinha.dto.SaldoDto;

import java.time.Instant;

public abstract class ExtratoMapper {

    public static SaldoDto saldoToDto(ClienteSaldo clienteSaldo) {
        SaldoDto saldoDto = new SaldoDto();
        saldoDto.setInstant(Instant.now());
        saldoDto.setTotal(clienteSaldo.getSaldo());
        saldoDto.setLimite(clienteSaldo.getLimite());
        return saldoDto;
    }
}
