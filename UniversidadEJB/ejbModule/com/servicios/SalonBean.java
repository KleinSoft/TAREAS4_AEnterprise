package com.servicios;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Area;
import com.entities.Salon;
import com.exceptions.ServiciosException;

@Stateless
@LocalBean
public class SalonBean implements SalonBeanRemote {

	@PersistenceContext
	private EntityManager em;
	
    public SalonBean() {
    }
    
    
    @Override
    public void crear(Salon salon) throws ServiciosException {
     try{
    em.persist(salon);
    em.flush();
     }catch(PersistenceException e){
    throw new ServiciosException("No se pudo crear el salon");
     }
    } 
    
	@Override
    public void actualizar(Salon salon) throws ServiciosException {
     try{
    em.merge(salon); 
    em.flush();
     }catch(PersistenceException e){
    throw new ServiciosException("No se pudo actualizar el salon");
     }
    } 
	
	@Override
    public void borrar(Long id) throws ServiciosException {
	 try{
		Salon salon = em.find(Salon.class, id);
		em.remove(salon);
		em.flush();
	 }catch(PersistenceException e){
		 throw new ServiciosException("No se pudo borrar el salon");
	 }
	};
	
	@Override
	public List<Salon> obtenerTodos() {
	 TypedQuery<Salon> query = em.createQuery("SELECT s FROM Salon s",Salon.class);
	 return query.getResultList();
	} 
}
