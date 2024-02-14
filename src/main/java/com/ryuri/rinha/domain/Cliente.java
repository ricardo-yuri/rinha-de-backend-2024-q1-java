package com.ryuri.rinha.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Cliente {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String nome;

}
