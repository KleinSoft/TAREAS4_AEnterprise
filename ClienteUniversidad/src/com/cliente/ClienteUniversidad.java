package com.cliente;

import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.entities.Area;
import com.entities.Salon;
import com.exceptions.ServiciosException;
import com.servicios.AreaBeanRemote;
import com.servicios.MaterialBeanRemote;
import com.servicios.SalonBeanRemote;
import com.sun.tools.javac.util.List;

public class ClienteUniversidad {

	public static void main(String[] args) throws NamingException{
		
			
			
			SalonBeanRemote salonBean = (SalonBeanRemote) InitialContext.doLookup("UniversidadEJB/SalonBean!com.servicios.SalonBeanRemote");
			
			MaterialBeanRemote materialBean = (MaterialBeanRemote) InitialContext.doLookup("UniversidadEJB/MaterialBean!com.servicios.MaterialBeanRemote");
			
			AreaBeanRemote areaBean = (AreaBeanRemote) InitialContext.doLookup("UniversidadEJB/AreaBean!com.servicios.AreaBeanRemote");
			
			
			/*AB Area*/
			/*Primer Area*/
			Area areaLTI = new Area();
			areaLTI.setId(1L);
			areaLTI.setNombre("Área LTI");
			
			
			/*ACA VAN SALONES CREADOS Arriba*/
			ArrayList<Salon> salonesLTI = new ArrayList<>();
			
			//salonesLTI.add(salonRobotica)
			//salonesLTI.add(aula3)
			//salonesLTI.add(salaServidores)
			
			//areaLTI.setSalones(salonesLTI);
			
			/*Segunda Area*/
			Area areaBiomedicas = new Area();
			areaLTI.setId(2L);
			areaLTI.setNombre("Área Biomédicas");
			
			
			/*ACA VAN SALONES CREADOS Arriba*/
			ArrayList<Salon> salonesBiomedica = new ArrayList<>();
			
			//salonesBiomedica.add(lab1)
			//salonesBiomedica.add(aula2)
			//salonesBiomedica.add(galponMateriales1)
			
			//areaBiomedicas.setSalones(salonesBiomedica);
			
			/*Tercer Area*/
			Area areaIAgro = new Area();
			areaLTI.setId(3L);
			areaLTI.setNombre("Área IAgro");
			
			
			/*ACA VAN SALONES CREADOS Arriba*/
			ArrayList<Salon> salonesIAgro = new ArrayList<>();
			
			//salonesIAgro.add(lab2)
			//salonesIAgro.add(aula1)
			//salonesIAgro.add(galponMateriales2)

			//areaIAgro.setSalones(salonesIAgro);
			
			ArrayList<Area> areasABM = new ArrayList<>();
			areasABM.add(areaLTI);
			areasABM.add(areaBiomedicas);
			areasABM.add(areaIAgro);
			
			
			try {
				for (Area area : areasABM) {
					areaBean.crear(area);
					System.out.println("Se ha creado exitosamente el área: " + area.getNombre());
				}
			} catch(ServiciosException e) {
				System.out.println(e.getMessage()); 
			}

	}
	

}
