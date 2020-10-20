package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Area;
import com.entities.Salon;
import com.exceptions.ServiciosException;

@Remote
public interface SalonBeanRemote {
	
	void crear(Salon salon) throws ServiciosException;
	void actualizar(Salon salon) throws ServiciosException;
	void borrar(Long id) throws ServiciosException;
	List<Salon> obtenerTodos();
}
