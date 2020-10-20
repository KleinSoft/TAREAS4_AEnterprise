package com.cliente;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import com.servicios.AreaBeanRemote;
import com.servicios.MaterialBeanRemote;
import com.servicios.SalonBeanRemote;

public class ClienteUniversidad {

	public static void main(String[] args) throws NamingException{
		
			AreaBeanRemote areaBean = (AreaBeanRemote) InitialContext.doLookup("UniversidadEJB/AreaBean!com.servicios.AreaBeanRemote");

			SalonBeanRemote salonBean = (SalonBeanRemote) InitialContext.doLookup("UniversidadEJB/SalonBean!com.servicios.SalonBeanRemote");
			
			
			MaterialBeanRemote materialBean = (MaterialBeanRemote) InitialContext.doLookup("UniversidadEJB/MaterialBean!com.servicios.MaterialBeanRemote");
			
	}
	

}
