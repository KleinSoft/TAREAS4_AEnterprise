package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: Material
 *
 */
@Entity
public class Material implements Serializable {

	
	private static final long serialVersionUID = 1L;	
	
	@Id
	@GeneratedValue
	private Long id;
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	@Column
	private String nombre;
	
	@Column
	private String descripcion;
	
	
	public Material() {
		super();
	} 
	
   
}
