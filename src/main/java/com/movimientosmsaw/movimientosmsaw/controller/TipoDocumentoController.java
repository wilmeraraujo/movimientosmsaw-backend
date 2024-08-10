package com.movimientosmsaw.movimientosmsaw.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@CrossOrigin(origins = "http://localhost:4200")//, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE,RequestMethod.OPTIONS})
@RequestMapping(value="/api/v1/tipo-documento")
public class TipoDocumentoController {

	@Autowired
	private TipoDocumentoService tipoDocumentoService;
	
	@GetMapping
	//@CrossOrigin(origins = "http://localhost:4200")
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
	
	@GetMapping("/search/{term}")
	public ResponseEntity<?> filter(@PathVariable String term){
		return ResponseEntity.ok(tipoDocumentoService.findByTipoDesc(term));
	}
	
	@DeleteMapping("/{id}")
	//@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
	    if (tipoDocumentoService.findById(id).isPresent()) {
	        try {
	            tipoDocumentoService.deleteById(id);
	            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No se pudo eliminar el tipo de documento con id " + id);
	        }
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el tipo de documento con id " + id);
	    }
	}
}
