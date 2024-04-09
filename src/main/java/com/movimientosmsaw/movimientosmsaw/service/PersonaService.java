package com.movimientosmsaw.movimientosmsaw.service;

import java.util.List;
import java.util.Optional;
import com.movimientosmsaw.movimientosmsaw.entity.Persona;

public interface PersonaService {

	public List<Persona> findAll();
	
	public Optional<Persona> findById(Long id);
	
	public Persona save(Persona persona);
	
	public void deleteById(Long id);
}
