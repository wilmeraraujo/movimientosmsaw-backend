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

import com.movimientosmsaw.movimientosmsaw.entity.TipoDocumento;
import com.movimientosmsaw.movimientosmsaw.service.TipoDocumentoService;

@RestController
@RequestMapping(value="/api/v1/tipo-documento")
public class TipoDocumentoController {

	@Autowired
	private TipoDocumentoService tipoDocumentoService;
	
	@GetMapping
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok().body(tipoDocumentoService.findAll());
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody TipoDocumento tipoDocumento){
		return  ResponseEntity.status(HttpStatus.CREATED).body(tipoDocumentoService.save(tipoDocumento));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> edit(@RequestBody TipoDocumento tipoDocumento, @PathVariable(name = "id") Long id){
		
		Optional<TipoDocumento> objeto = tipoDocumentoService.findById(id);
		
		if(objeto.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		TipoDocumento tipoDocumentoDb = objeto.get();
		tipoDocumentoDb.setCodigo(tipoDocumento.getCodigo());
		tipoDocumentoDb.setDescripcion(tipoDocumento.getDescripcion());
		
		return  ResponseEntity.status(HttpStatus.CREATED).body(tipoDocumentoService.save(tipoDocumentoDb));
	}
}
