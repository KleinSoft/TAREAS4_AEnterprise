package com.servicios;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Area;
import com.entities.Material;
import com.exceptions.ServiciosException;

@Stateless
@LocalBean
public class MaterialBean implements MaterialBeanRemote {

	@PersistenceContext
	private EntityManager em;
	
    public MaterialBean() {
    }
    
    
    @Override
    public void crear(Material material) throws ServiciosException {
     try{
    em.persist(material);
    em.flush();
     }catch(PersistenceException e){
    throw new ServiciosException("No se pudo crear el material");
     }
    } 
    
	@Override
    public void actualizar(Material material) throws ServiciosException {
     try{
    em.merge(material); 
    em.flush();
     }catch(PersistenceException e){
    throw new ServiciosException("No se pudo actualizar el material");
     }
    } 
	
	@Override
    public void borrar(Long id) throws ServiciosException {
	 try{
		Material material = em.find(Material.class, id);
		em.remove(material);
		em.flush();
	 }catch(PersistenceException e){
		 throw new ServiciosException("No se pudo borrar el material");
	 }
	};
	
	@Override
	public List<Material> obtenerTodos() {
	 TypedQuery<Material> query = em.createQuery("SELECT m FROM MATERIALES m",Material.class);
	 return query.getResultList();
	} 
}
