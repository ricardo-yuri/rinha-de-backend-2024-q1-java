package com.ryuri.rinha.repository;

import com.ryuri.rinha.domain.Cliente;
import com.ryuri.rinha.domain.Transacoes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacoesRepository extends JpaRepository<Transacoes, Long> {
}
