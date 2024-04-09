package com.movimientosmsaw.movimientosmsaw.service;

import java.util.List;
import java.util.Optional;

import com.movimientosmsaw.movimientosmsaw.entity.Movimiento;



public interface MovimientoService {
	
	public List<Movimiento> findAll();
	
	public Optional<Movimiento> findById(Long id);
	
	public Movimiento save(Movimiento movimiento);
	
	public void deleteById(Long id);

}
