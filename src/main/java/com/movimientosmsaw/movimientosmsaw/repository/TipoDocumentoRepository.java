package com.movimientosmsaw.movimientosmsaw.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.movimientosmsaw.movimientosmsaw.entity.TipoDocumento;

public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento, Long>{
	@Query("select ps from TipoDocumento ps where lower(ps.codigo) like lower(concat('%', ?1, '%')) or lower(descripcion) like lower(concat('%', ?1, '%'))")
	public List<TipoDocumento> findByTipoDesc(String term);
}
