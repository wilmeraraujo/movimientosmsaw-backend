package com.movimientosmsaw.movimientosmsaw.service;

import java.util.List;
import java.util.Optional;

import com.movimientosmsaw.movimientosmsaw.entity.TipoMovimiento;

public interface TipoMovimientoService {
	
	public List<TipoMovimiento> findAll();
	
	public Optional<TipoMovimiento> findById(Long id);
	
	public TipoMovimiento save(TipoMovimiento tipoMovimiento);
	
	public void deleteById(Long id);
}
