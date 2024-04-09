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

import com.movimientosmsaw.movimientosmsaw.entity.Movimiento;
import com.movimientosmsaw.movimientosmsaw.entity.TipoMovimiento;
import com.movimientosmsaw.movimientosmsaw.service.TipoMovimientoService;

@RestController
@RequestMapping(value="/tipo-movimiento")
public class TipoMovimientoController {
	
	@Autowired
	private TipoMovimientoService tipoMovimientoService;
	
	@GetMapping
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok().body(tipoMovimientoService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable(name = "id") Long id) {
		Optional<TipoMovimiento> tipoMovimiento = tipoMovimientoService.findById(id);

		if (tipoMovimiento.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok().body(tipoMovimiento.get());
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody TipoMovimiento tipoMovimiento){
		return  ResponseEntity.status(HttpStatus.CREATED).body(tipoMovimientoService.save(tipoMovimiento));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> edit(@RequestBody TipoMovimiento tipoMovimiento, @PathVariable(name = "id") Long id){
		
		Optional<TipoMovimiento> objeto = tipoMovimientoService.findById(id);
		
		if(objeto.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		TipoMovimiento tipoMovimientoDb = objeto.get();
		tipoMovimientoDb.setDescripcion(tipoMovimiento.getDescripcion());
		
		return  ResponseEntity.status(HttpStatus.CREATED).body(tipoMovimientoService.save(tipoMovimientoDb));
	}
	
	
}
	
