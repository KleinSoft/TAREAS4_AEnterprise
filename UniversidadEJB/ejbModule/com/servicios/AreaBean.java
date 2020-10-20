package com.servicios;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Area;
import com.exceptions.ServiciosException;

@Stateless
@LocalBean
public class AreaBean implements AreaBeanRemote {

	@PersistenceContext
	private EntityManager em;
	
    public AreaBean() {
    }
    
    
    @Override
    public void crear(Area area) throws ServiciosException {
     try{
    em.persist(area);
    em.flush();
     }catch(PersistenceException e){
    throw new ServiciosException("No se pudo crear el area");
     }
    } 
    
	@Override
    public void actualizar(Area area) throws ServiciosException {
     try{
    em.merge(area); 
    em.flush();
     }catch(PersistenceException e){
    throw new ServiciosException("No se pudo actualizar el area");
     }
    } 
	
	@Override
    public void borrar(Long id) throws ServiciosException {
	 try{
		Area area = em.find(Area.class, id);
		em.remove(area);
		em.flush();
	 }catch(PersistenceException e){
		 throw new ServiciosException("No se pudo borrar el area");
	 }
	};
	
	@Override
	public List<Area> obtenerTodos() {
	 TypedQuery<Area> query = em.createQuery("SELECT a FROM AREAS a",Area.class);
	 return query.getResultList();
	} 
}
