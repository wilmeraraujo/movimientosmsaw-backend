package com.movimientosmsaw.movimientosmsaw.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movimientosmsaw.movimientosmsaw.entity.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {

}
