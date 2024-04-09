package com.movimientosmsaw.movimientosmsaw.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movimientosmsaw.movimientosmsaw.entity.Persona;
import com.movimientosmsaw.movimientosmsaw.repository.PersonaRepository;

import jakarta.transaction.Transactional;

@Service
public class PersonaServiceImple implements PersonaService{

	@Autowired
	private PersonaRepository personaRepository;
	
	@Override
	public List<Persona> findAll() {
		return personaRepository.findAll();
	}

	@Override
	public Optional<Persona> findById(Long id) {
		return personaRepository.findById(id);
	}

	@Override
	@Transactional
	public Persona save(Persona persona) {
		return personaRepository.save(persona);
	}

	@Override
	public void deleteById(Long id) {
		personaRepository.deleteById(id);
	}

}
