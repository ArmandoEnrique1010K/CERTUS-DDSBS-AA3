package com.edu.certus.profesor.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Entity
@Table(name = "profesor")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfesorEntity {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_profesor")
	private Long id;
	@Column(name = "nombre")
	private String nombres;
	@Column(name = "apellidos")
	private String apellidos;
	@Column(name = "sexo")
	private String sexo;
	@Column(name = "estado")
	private Boolean estado;
        
}