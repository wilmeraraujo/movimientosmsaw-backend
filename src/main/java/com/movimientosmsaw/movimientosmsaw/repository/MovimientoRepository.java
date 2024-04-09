package com.movimientosmsaw.movimientosmsaw.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movimientosmsaw.movimientosmsaw.entity.Movimiento;

public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {

}
