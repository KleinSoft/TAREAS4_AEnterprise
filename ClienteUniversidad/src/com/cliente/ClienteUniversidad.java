package com.cliente;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.entities.Area;
import com.entities.Material;
import com.entities.Salon;
import com.entities.Tipo;
import com.exceptions.ServiciosException;
import com.servicios.AreaBeanRemote;
import com.servicios.MaterialBeanRemote;
import com.servicios.SalonBeanRemote;

public class ClienteUniversidad {

	public static void main(String[] args) throws NamingException{
		
		//Creamos el Bean de Material	
		MaterialBeanRemote materialBean = (MaterialBeanRemote) InitialContext.doLookup("UniversidadEJB/MaterialBean!com.servicios.MaterialBeanRemote");
		
		//desde la linea 29 hasta la linea 125 creamos los materiales
		//de la siguiente manera

		//Ejemplo:
		//Creamos un material
		Material placaArduino = new Material();
		//Seteamos los valores
		placaArduino.setId(1L);
		placaArduino.setNombre("placa Arduino");
		placaArduino.setDescripcion("placa de Arduino");

		//Repetimos todos los pasos para los siguientes materiales

		Material imp3D = new Material();
		imp3D.setId(2L);
		imp3D.setNombre("impresora 3D");
		imp3D.setDescripcion("impresora 3D");

		Material tv4 = new Material();
		tv4.setId(3L);
		tv4.setNombre("televisor 4");
		tv4.setDescripcion("televisor 4");

		Material pizzarraElectronica = new Material();
		pizzarraElectronica.setId(4L);
		pizzarraElectronica.setNombre("pizzarra Electronica");
		pizzarraElectronica.setDescripcion("pizzarra Electronica");

		Material servidorBD = new Material();
		servidorBD.setId(5L);
		servidorBD.setNombre("servidor BD");
		servidorBD.setDescripcion("servidor BD");

		Material servidorPRT = new Material();
		servidorPRT.setId(6L);
		servidorPRT.setNombre("servidor PRT");
		servidorPRT.setDescripcion("servidor PRT");

		Material servidorAPP = new Material();
		servidorAPP.setId(7L);
		servidorAPP.setNombre("servidor APP");
		servidorAPP.setDescripcion("servidor APP");

		Material microscopio = new Material();
		microscopio.setId(8L);
		microscopio.setNombre("microscopio");
		microscopio.setDescripcion("microscopio");

		Material tijeras = new Material();
		tijeras.setId(9L);
		tijeras.setNombre("tijeras");
		tijeras.setDescripcion("tijeras");

		Material televisor21 = new Material();
		televisor21.setId(10L);
		televisor21.setNombre("televisor 21");
		televisor21.setDescripcion("televisor 21");

		Material canion = new Material();
		canion.setId(11L);
		canion.setNombre("cañon");
		canion.setDescripcion("cañon");

		Material panelMovil = new Material();
		panelMovil.setId(12L);
		panelMovil.setNombre("panel Movil");
		panelMovil.setDescripcion("panel Movil");

		Material mesaOperaciones = new Material();
		mesaOperaciones.setId(13L);
		mesaOperaciones.setNombre("mesa de operaciones");
		mesaOperaciones.setDescripcion("mesa de operaciones");

		Material maqueta1 = new Material();
		maqueta1.setId(14L);
		maqueta1.setNombre("maqueta 1");
		maqueta1.setDescripcion("maqueta 1");

		Material maqueta2 = new Material();
		maqueta2.setId(15L);
		maqueta2.setNombre("maqueta 2");
		maqueta2.setDescripcion("maqueta 2");

		Material televisor48 = new Material();
		televisor48.setId(16L);
		televisor48.setNombre("televisor 48");
		televisor48.setDescripcion("televisor 48");

		Material mesaTrabajo = new Material();
		mesaTrabajo.setId(17L);
		mesaTrabajo.setNombre("mesa de trabajo");
		mesaTrabajo.setDescripcion("mesa de trabajo");

		Material tractor = new Material();
		tractor.setId(18L);
		tractor.setNombre("tractor");
		tractor.setDescripcion("tractor");

		Material molino = new Material();
		molino.setId(19L);
		molino.setNombre("molino");
		molino.setDescripcion("molino");

		//Finalizamos la creacion de materiales

		//A continuacion añadimos todos los materiales creados 
		//a un lista de materiales 
		ArrayList<Material> materialesABM = new ArrayList<>();
		materialesABM.add(placaArduino);
		materialesABM.add(imp3D);
		materialesABM.add(tv4);
		materialesABM.add(pizzarraElectronica);
		materialesABM.add(servidorBD);
		materialesABM.add(servidorPRT);
		materialesABM.add(servidorAPP);
		materialesABM.add(microscopio);
		materialesABM.add(tijeras);
		materialesABM.add(televisor21);
		materialesABM.add(canion);
		materialesABM.add(panelMovil);
		materialesABM.add(mesaOperaciones);
		materialesABM.add(maqueta1);
		materialesABM.add(maqueta2);
		materialesABM.add(televisor48);
		materialesABM.add(mesaTrabajo);
		materialesABM.add(tractor);
		materialesABM.add(molino);
		
		//Por cada material en la lista damos el alta del material
		try {
			for (Material material : materialesABM) {
				//Creamos
				materialBean.crear(material);
				//Se imprime mensaje en consola de que se ha creado exitosamente
				System.out.println("Se ha creado exitosamente el material: " + material.getNombre());
			}
			//En caso de que el material no cumpla con las condiciones
		} catch(ServiciosException e) {
			//Se imprime un mensaje de error
			System.out.println(e.getMessage()); 
		}

		//Modificacion de material
		try {
			//Insertamos el nombre en una variable para ser utilizado luego
			String viejoNombre1 = placaArduino.getNombre();
			
			//Seteamos un nuevo nombre para el material y lo actualizamos
			placaArduino.setNombre("placaArduinoV2.0");
			materialBean.actualizar(placaArduino);
			
			//Se imprime en consola que el cambio se ha realizado correctamente 
			System.out.println("Se ha actualizado exitosamente el material " + viejoNombre1 +  " a " + placaArduino.getNombre());

			//En caso de que se viole alguna restriccion al cambiar
		} catch(ServiciosException e) {
			//Se imprime un mensaje de error
			System.out.println(e.getMessage()); 
		}
		
		// Eliminacion de un material
		try {
			//Guardamos el nombre en una variable para usar despues
			String viejoNombre1 = placaArduino.getNombre();
			
			//Se borra el material 
			materialBean.borrar(placaArduino.getId());
			
			//Se imprime mensaje de que se ha borrado exitosamente
			System.out.println("Se ha borrado existosamente el material: " + viejoNombre1);

			//En caso de que se viole alguna restriccion al borrar
		} catch(ServiciosException e) {
			//Se imprime un mensaje de error
			System.out.println(e.getMessage()); 
		}

		//----------------------------------------------------------------------
			
			// Creamos el Bean de salon
			SalonBeanRemote salonBean = (SalonBeanRemote) InitialContext.doLookup("UniversidadEJB/SalonBean!com.servicios.SalonBeanRemote");
			
			//desde la linea 211 hasta la linea 327 creamos los materiales
			//de la siguiente manera

			//Ejemplo:
			//Creamos un salon
			Salon salonRobotica = new Salon();
			//Seteamos los valores de sus propiedades
			salonRobotica.setId(1L);
			salonRobotica.setNombre("Robotica");
			salonRobotica.setCapacidadMaxima(100);
			//Creamos una lista de los materiales que pertenecen al salon
			ArrayList<Material> salonRobotical = new ArrayList<>();
			//Se ingresan los materiales a la lista
			salonRobotical.add(placaArduino);
			salonRobotical.add(imp3D);
			salonRobotica.setMateriales(salonRobotical);
			salonRobotica.setPractica(true);
			salonRobotica.setTipo(Tipo.LABORATORIO);

			Salon aula3 = new Salon();
			aula3.setId(2L);
			aula3.setNombre("Aula de clases 3");
			aula3.setCapacidadMaxima(100);
			ArrayList<Material> aula3l = new ArrayList<>();
			aula3l.add(tv4);
			aula3l.add(pizzarraElectronica);
			aula3.setMateriales(aula3l);		
			aula3.setPractica(true);
			aula3.setTipo(Tipo.COMUN);

			Salon salaServidores = new Salon();
			salaServidores.setId(3L);
			salaServidores.setNombre("Sala de servidores");
			salaServidores.setCapacidadMaxima(100);
			ArrayList<Material> salaServidoresl = new ArrayList<>();
			salaServidoresl.add(servidorBD);
			salaServidoresl.add(servidorPRT);
			salaServidoresl.add(servidorAPP);
			salaServidores.setMateriales(salaServidoresl);
			salaServidores.setPractica(true);
			salaServidores.setTipo(Tipo.COMUN);

			Salon lab1 = new Salon();
			lab1.setId(4L);
			lab1.setNombre("Laboratorio 1");
			lab1.setCapacidadMaxima(100);
			ArrayList<Material> lab1l = new ArrayList<>();
			lab1l.add(microscopio);
			lab1l.add(tijeras);
			lab1.setMateriales(lab1l);
			lab1.setPractica(true);
			lab1.setTipo(Tipo.LABORATORIO);

			Salon aula2 = new Salon();
			aula2.setId(5L);
			aula2.setNombre("Aula de clases 2");
			aula2.setCapacidadMaxima(100);
			ArrayList<Material> aula2l = new ArrayList<>();
			aula2l.add(televisor21);
			aula2l.add(canion);
			aula2.setMateriales(aula2l);
			aula2.setPractica(true);
			aula2.setTipo(Tipo.COMUN);

			Salon depositoMat = new Salon();
			depositoMat.setId(6L);
			depositoMat.setNombre("Depósito de materiales");
			depositoMat.setCapacidadMaxima(100);
			ArrayList<Material> depositoMatl = new ArrayList<>();
			depositoMatl.add(panelMovil);
			depositoMatl.add(mesaOperaciones);
			depositoMat.setMateriales(depositoMatl);
			depositoMat.setPractica(true);
			depositoMat.setTipo(Tipo.DEPOSITO);

			Salon lab2 = new Salon();
			lab2.setId(7L);
			lab2.setNombre("Laboratorio 2");
			lab2.setCapacidadMaxima(100);
			ArrayList<Material> lab2l = new ArrayList<>();
			lab2l.add(maqueta1);
			lab2l.add(maqueta2);
			lab2.setMateriales(lab2l);
			lab2.setPractica(true);
			lab2.setTipo(Tipo.LABORATORIO);

			Salon aula1 = new Salon();
			aula1.setId(8L);
			aula1.setNombre("Aula de clases 1");
			aula1.setCapacidadMaxima(100);
			ArrayList<Material> aula1l = new ArrayList<>();
			aula1l.add(televisor48);
			aula1l.add(mesaTrabajo);
			aula1.setMateriales(aula1l);
			aula1.setPractica(true);
			aula1.setTipo(Tipo.COMUN);

			Salon galponMateriales = new Salon();
			galponMateriales.setId(9L);
			galponMateriales.setNombre("Galpón de materiales");
			galponMateriales.setCapacidadMaxima(100);
			ArrayList<Material> galponMaterialesl = new ArrayList<>();
			galponMaterialesl.add(tractor);
			galponMaterialesl.add(molino);
			galponMateriales.setMateriales(galponMaterialesl);
			galponMateriales.setPractica(true);
			galponMateriales.setTipo(Tipo.DEPOSITO);

			//Se crea una lista de Salones y se agregan los salones a la lista
			ArrayList<Salon> salonesABM = new ArrayList<>();
			salonesABM.add(salonRobotica);
			salonesABM.add(aula3);
			salonesABM.add(salaServidores);
			salonesABM.add(lab1);
			salonesABM.add(aula2);
			salonesABM.add(depositoMat);
			salonesABM.add(lab2);
			salonesABM.add(aula1);
			salonesABM.add(galponMateriales);
			
			//Por cada salon en la lista, el salon es dado de alta 
			try {
				for (Salon salon : salonesABM) {
					//Se crea el salon
					salonBean.crear(salon);
					//Se imprime en consola que el salon se ha creado correctamente
					System.out.println("Se ha creado exitosamente el salon: " + salon.getNombre());
				}
				//En caso de que se viole alguna restriccion
			} catch(ServiciosException e) {
				//Se imprime un mensaje de error
				System.out.println(e.getMessage()); 
			}

			//Modificacion de salon
			try {
				//Se guarda el nombre del salon en una variable
				String viejoNombre1 = salonRobotica.getNombre();
				
				//Seteamos el nuevo nombre
				salonRobotica.setNombre("roboticaV2.0");
				//Actualizamos el salon
				salonBean.actualizar(salonRobotica);
				
				//Imprimimos en consola que el salon ha sido modificado exitosamente
				System.out.println("Se ha actualizado exitosamente el salon " + viejoNombre1 +  " a " + salonRobotica.getNombre());

			//En caso de que no se cumpla con alguna condicion	
			} catch(ServiciosException e) {
				//Se imprime un mensaje de error
				System.out.println(e.getMessage()); 
			}
			
			//Eliminacion o baja del salon
			try {
				//Guardamos el nombre en una variable para utilizarlo luego
				String viejoNombre = salonRobotica.getNombre();
				
				//Eliminamos el salon
				salonBean.borrar(salonRobotica.getId());
				
				//Se imprime en pantalla que se ha borrado de manera exitosa
				System.out.println("Se ha borrado existosamente el salon: " + viejoNombre);
			
			// En caso de que no se cumpla alguna condicion o se viole alguna restriccion
			} catch(ServiciosException e) {
				// Se imprime mensaje de error
				System.out.println(e.getMessage()); 
			}


			//-----------------------------------------------------------------


			AreaBeanRemote areaBean = (AreaBeanRemote) InitialContext.doLookup("UniversidadEJB/AreaBean!com.servicios.AreaBeanRemote");
						
			/*AB Area*/
			/*Primer Area--------------------------------------------------------------*/
			Area areaLTI = new Area();
			areaLTI.setId(1L);
			areaLTI.setNombre("Area LTI");
			
			
			/*ACA VAN SALONES CREADOS Arriba*/
			ArrayList<Salon> salonesLTI = new ArrayList<>();
			
			salonesLTI.add(salonRobotica);
			salonesLTI.add(aula3);
			salonesLTI.add(salaServidores);
			
			areaLTI.setSalones(salonesLTI);
			
			/*Segunda Area--------------------------------------------------------------*/
			Area areaBiomedicas = new Area();
			areaBiomedicas.setId(2L);
			areaBiomedicas.setNombre("Area Biomedicas");
			
			
			/*ACA VAN SALONES CREADOS Arriba*/
			ArrayList<Salon> salonesBiomedica = new ArrayList<>();
			
			salonesBiomedica.add(lab1);
			salonesBiomedica.add(aula2);
			salonesBiomedica.add(depositoMat);
			
			areaBiomedicas.setSalones(salonesBiomedica);
			
			/*Tercer Area--------------------------------------------------------------*/
			Area areaIAgro = new Area();
			areaIAgro.setId(3L);
			areaIAgro.setNombre("Area IAgro");
			
			
			/*ACA VAN SALONES CREADOS Arriba*/
			ArrayList<Salon> salonesIAgro = new ArrayList<>();
			
			salonesIAgro.add(lab2);
			salonesIAgro.add(aula1);
			salonesIAgro.add(galponMateriales);

			areaIAgro.setSalones(salonesIAgro);
			
			/*ABM--------------------------------------------------------------*/
			
			ArrayList<Area> areasABM = new ArrayList<>();
			areasABM.add(areaLTI);
			areasABM.add(areaBiomedicas);
			areasABM.add(areaIAgro);
			
			
			try {
				for (Area area : areasABM) {
					areaBean.crear(area);
					System.out.println("Se ha creado exitosamente el Area: " + area.getNombre());
				}
			} catch(ServiciosException e) {
				System.out.println(e.getMessage()); 
			}
			
			/*MODIFICACION AreaLTI*/
						
			try {
				String viejoNombre2 = areaLTI.getNombre();
				
				areaLTI.setNombre("�reaLTIV2.0");
				areaBean.actualizar(areaLTI);
				
				System.out.println("Se ha actualizado exitosamente el Area " + viejoNombre2 +  " a " + areaLTI.getNombre());
			} catch(ServiciosException e) {
				System.out.println(e.getMessage()); 
			}
			
			/*BAJA AreaIAgro*/
			
			try {
				String viejoNombre2 = areaIAgro.getNombre();
				
				areaBean.borrar(areaIAgro.getId());
				
				System.out.println("Se ha borrado existosamente el Area: " + viejoNombre2);
			} catch(ServiciosException e) {
				System.out.println(e.getMessage()); 
			}
			
			/*LISTADOS*/
			
			
			List<Area> areasEnBD = areaBean.obtenerTodos();
			
			for (Area area : areasEnBD) {
				System.out.println("\n -------------AREA------------- \n");
				System.out.println("-" + area.getNombre());

				for (Salon salon : area.getSalones()) {
					System.out.println("---------SALON DE " + area.getNombre().toUpperCase() + " ---------");
					System.out.println("-" + salon.getNombre());
					System.out.println("- Tipo: " + salon.getTipo());
					System.out.println("- Cap maxima: " + salon.getCapacidadMaxima());
					
					for (Material material : salon.getMateriales()) {
						System.out.println("-----MATERIAL DE " + salon.getNombre().toUpperCase() + " -----");
						System.out.println("-" + material.getNombre());
						System.out.println("-" + material.getDescripcion());
					}
				}
			}
			
			
			
	}
	

}
