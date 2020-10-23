package com.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: area
 *
 */
@Entity
@Table(name="AREAS")
public class Area implements Serializable {

	
	private static final long serialVersionUID = 1L;	
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String nombre;
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	
	private List<Salon> salones = new ArrayList<>();
	
	
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


	public List<Salon> getSalones() {
		return salones;
	}


	public void setSalones(List<Salon> salones) {
		this.salones = salones;
	}


	public Area() {
		super();
	} 
	
   
}
