package com.movimientosmsaw.movimientosmsaw.service;

import java.util.List;
import java.util.Optional;

import com.movimientosmsaw.movimientosmsaw.entity.TipoDocumento;

public interface TipoDocumentoService {

	public List<TipoDocumento> findAll();
	
	public Optional<TipoDocumento> findById(Long id);
	
	public TipoDocumento save(TipoDocumento tipoDocumento);
	
	public void deleteById(Long id);
}
