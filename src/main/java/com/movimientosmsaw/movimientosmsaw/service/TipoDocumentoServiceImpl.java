package com.movimientosmsaw.movimientosmsaw.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movimientosmsaw.movimientosmsaw.entity.TipoDocumento;
import com.movimientosmsaw.movimientosmsaw.repository.TipoDocumentoRepository;

import jakarta.transaction.Transactional;

@Service
public class TipoDocumentoServiceImpl implements TipoDocumentoService {

	@Autowired
	private TipoDocumentoRepository tipoDocumentoRepository;
	
	@Override
	public List<TipoDocumento> findAll() {
		return tipoDocumentoRepository.findAll();
	}

	@Override
	public Optional<TipoDocumento> findById(Long id) {
		return tipoDocumentoRepository.findById(id);
	}

	@Override
	@Transactional
	public TipoDocumento save(TipoDocumento tipoDocumento) {
		return tipoDocumentoRepository.save(tipoDocumento);
	}

	@Override
	public void deleteById(Long id) {
		tipoDocumentoRepository.deleteById(id);
	}

}
