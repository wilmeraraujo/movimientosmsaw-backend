package com.movimientosmsaw.movimientosmsaw.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movimientosmsaw.movimientosmsaw.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
