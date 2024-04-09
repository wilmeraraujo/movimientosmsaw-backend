package com.movimientosmsaw.movimientosmsaw.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movimientosmsaw.movimientosmsaw.entity.TipoMovimiento;
import com.movimientosmsaw.movimientosmsaw.repository.TipoMovimientoRepository;

@Service
public class TipoMovimientoServiceImpl implements TipoMovimientoService{

	@Autowired
	private TipoMovimientoRepository tipoMovimientoRepository;

	@Override
	public List<TipoMovimiento> findAll() {
		return tipoMovimientoRepository.findAll();
	}

	@Override
	public Optional<TipoMovimiento> findById(Long id) {
		return tipoMovimientoRepository.findById(id);
	}

	@Override
	public TipoMovimiento save(TipoMovimiento tipoMovimiento) {
		return tipoMovimientoRepository.save(tipoMovimiento);
	}

	@Override
	public void deleteById(Long id) {
		tipoMovimientoRepository.deleteById(id);
	}

	


}
