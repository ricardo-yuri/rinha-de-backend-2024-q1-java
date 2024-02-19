package com.ryuri.rinha.repository;

import com.ryuri.rinha.domain.Transacoes;
import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransacoesRepository extends JpaRepository<Transacoes, Long> {

    List<Transacoes> findByIdClienteOrderByDataTransacaoDesc(Long idCliente, Limit limit);

}
