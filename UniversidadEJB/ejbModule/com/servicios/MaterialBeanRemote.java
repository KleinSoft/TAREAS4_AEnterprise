package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Area;
import com.entities.Material;
import com.exceptions.ServiciosException;

@Remote
public interface MaterialBeanRemote {
	
	void crear(Material material) throws ServiciosException;
	void actualizar(Material material) throws ServiciosException;
	void borrar(Long id) throws ServiciosException;
	List<Material> obtenerTodos();
}
