package com.senai.destino.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.destino.api.entities.Destino;

public interface DestinoRepository extends JpaRepository<Destino, Long> {
}