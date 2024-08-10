package com.movimientosmsaw.movimientosmsaw.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.movimientosmsaw.movimientosmsaw.entity.Usuario;
import com.movimientosmsaw.movimientosmsaw.repository.UsuarioRepository;

public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
    private UsuarioRepository usuarioRepository;
	@Override
	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

}
