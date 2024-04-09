package com.movimientosmsaw.movimientosmsaw.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movimientosmsaw.movimientosmsaw.entity.Movimiento;
import com.movimientosmsaw.movimientosmsaw.repository.MovimientoRepository;

import jakarta.transaction.Transactional;

@Service
public class MovimientoServiceImpl implements MovimientoService{

	@Autowired
	private MovimientoRepository movimientoRepository;
	
	@Override
	public List<Movimiento> findAll() {
		return movimientoRepository.findAll();
	}

	@Override
	public Optional<Movimiento> findById(Long id) {
		return movimientoRepository.findById(id);
	}

	@Override
	@Transactional
	public Movimiento save(Movimiento movimiento) {
		return movimientoRepository.save(movimiento);
	}

	@Override
	public void deleteById(Long id) {
		movimientoRepository.deleteById(id);
		
	}
	
}
