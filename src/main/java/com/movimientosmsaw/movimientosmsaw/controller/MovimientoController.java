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
import com.movimientosmsaw.movimientosmsaw.service.MovimientoService;

@RestController
@RequestMapping(value="/movimientos")
public class MovimientoController {
	
	@Autowired
	private MovimientoService movimientoService;
	
	@GetMapping
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok().body(movimientoService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable(name = "id") Long id) {
		Optional<Movimiento> movimiento = movimientoService.findById(id);

		if (movimiento.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok().body(movimiento.get());
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Movimiento movimiento){
		return  ResponseEntity.status(HttpStatus.CREATED).body(movimientoService.save(movimiento));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> edit(@RequestBody Movimiento movimiento, @PathVariable(name = "id") Long id){
		
		Optional<Movimiento> objeto = movimientoService.findById(id);
		
		if(objeto.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Movimiento movimientoDb = objeto.get();
		movimientoDb.setValor(movimiento.getValor());
		movimientoDb.setDescripcion(movimiento.getDescripcion());
		movimientoDb.setTipoMovimiento(movimiento.getTipoMovimiento());
		
		return  ResponseEntity.status(HttpStatus.CREATED).body(movimientoService.save(movimientoDb));
	}
	

}
