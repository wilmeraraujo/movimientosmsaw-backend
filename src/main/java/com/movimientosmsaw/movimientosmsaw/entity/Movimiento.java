package com.movimientosmsaw.movimientosmsaw.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//import javax.persistence.*;
//import javax.validation.constraints.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="movimiento",schema="mov")
public class Movimiento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer valor;
	private String descripcion;
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tipo_movimiento_id")
	@NotNull
	private TipoMovimiento tipoMovimiento;
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "persona_id")
	@NotNull
	private Persona persona;
	
	@Column(name = "fecha_movimiento")
    private LocalDate fecha;

	@Column(name = "hora_movimiento")
	private LocalTime hora;

	@Column(name = "created_at")
    private LocalDateTime createdAt;
	
    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
        fecha = LocalDate.now();
        hora = LocalTime.now();
    }
	
	

}
