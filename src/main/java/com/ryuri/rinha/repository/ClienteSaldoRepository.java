package com.ryuri.rinha.repository;

import com.ryuri.rinha.domain.ClienteSaldo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteSaldoRepository extends JpaRepository<ClienteSaldo, Long> {

    ClienteSaldo findByIdCliente(Long idCliente);
}
