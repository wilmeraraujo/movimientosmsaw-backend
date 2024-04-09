package com.movimientosmsaw.movimientosmsaw.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movimientosmsaw.movimientosmsaw.entity.Persona;
import com.movimientosmsaw.movimientosmsaw.service.PersonaService;

@RestController
@RequestMapping(value="/api/v1/persona")
public class PersonaController {
	
	@Autowired
	private PersonaService personaService;
	
	@GetMapping
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok().body(personaService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable(name = "id") Long id) {
		Optional<Persona> persona = personaService.findById(id);

		if (persona.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok().body(persona.get());
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Persona persona){
		return  ResponseEntity.status(HttpStatus.CREATED).body(personaService.save(persona));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> edit(@RequestBody Persona persona, @PathVariable(name = "id") Long id){
		
		Optional<Persona> objeto = personaService.findById(id);
		
		if(objeto.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Persona personaDb = objeto.get();
		personaDb.setNumeroIdentificacion(persona.getNumeroIdentificacion());
		personaDb.setPrimerNombre(persona.getPrimerNombre());
		personaDb.setSegundoNombre(persona.getSegundoNombre());
		personaDb.setPrimerApellido(persona.getPrimerApellido());
		personaDb.setSegundoApellido(persona.getSegundoApellido());
		personaDb.setTelefono(persona.getTelefono());
		personaDb.setDireccion(persona.getDireccion());
		personaDb.setPrimerNombre(persona.getPrimerNombre());
		personaDb.setTipoDocumento(persona.getTipoDocumento());
		
		return  ResponseEntity.status(HttpStatus.CREATED).body(personaService.save(personaDb));
	}
	

}
