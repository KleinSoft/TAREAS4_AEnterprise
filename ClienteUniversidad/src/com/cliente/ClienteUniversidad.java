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
			
			Salon salonRobotica = new Salon();
			salonRobotica.setId(1L);
			salonRobotica.setNombre("Robótica");
			salonRobotica.setCapacidadMaxima(100);
			salonRobotica.setPractica(true);
			//robotica.setTipo(?);

			ArrayList<Material> salonRobotical = new ArrayList<>();
			salonRobotical.add(placaArduino);
			salonRobotical.add(imp3D);

			Salon aula3 = new Salon();
			aula3.setId(2L);
			aula3.setNombre("Aula de clases 3");
			aula3.setCapacidadMaxima(100);
			aula3.setPractica(true);
			//aula3.setTipo(?);

			ArrayList<Material> aula3l = new ArrayList<>();
			aula3l.add(tv4);
			aula3l.add(pizzarraElectronica);

			Salon salaServidores = new Salon();
			salaServidores.setId(3L);
			salaServidores.setNombre("Sala de servidores");
			salaServidores.setCapacidadMaxima(100);
			salaServidores.setPractica(true);
			//salaServidores.setTipo(?);

			ArrayList<Material> salaServidoresl = new ArrayList<>();
			salaServidoresl.add(servidorBD);
			salaServidoresl.add(servidorPRT);
			salaServidoresl.add(servidorAPP);

			Salon lab1 = new Salon();
			lab1.setId(4L);
			lab1.setNombre("Laboratorio 1");
			lab1.setCapacidadMaxima(100);
			lab1.setPractica(true);
			//lab1.setTipo(?);

			ArrayList<Material> lab1l = new ArrayList<>();
			lab1l.add(microscopio);
			lab1l.add(tijeras);

			Salon aula2 = new Salon();
			aula2.setId(5L);
			aula2.setNombre("Aula de clases 2");
			aula2.setCapacidadMaxima(100);
			aula2.setPractica(true);
			//robotica.setTipo(?);

			ArrayList<Material> aula2l = new ArrayList<>();
			aula2l.add(televisor21);
			aula2l.add(cañon);

			Salon depositoMat = new Salon();
			depositoMat.setId(6L);
			depositoMat.setNombre("Depósito de materiales");
			depositoMat.setCapacidadMaxima(100);
			depositoMat.setPractica(true);
			//robotica.setTipo(?);

			ArrayList<Material> depositoMatl = new ArrayList<>();
			depositoMatl.add(panelMovil);
			depositoMatl.add(mesaOperaciones);

			Salon lab2 = new Salon();
			lab2.setId(7L);
			lab2.setNombre("Laboratorio 2");
			lab2.setCapacidadMaxima(100);
			lab2.setPractica(true);
			//lab2.setTipo(?);

			ArrayList<Material> lab2l = new ArrayList<>();
			lab2l.add(maqueta1);
			lab2l.add(maqueta2);

			Salon aula1 = new Salon();
			aula1.setId(8L);
			aula1.setNombre("Aula de clases 1");
			aula1.setCapacidadMaxima(100);
			aula1.setPractica(true);
			//robotica.setTipo(?);

			ArrayList<Material> aula1l = new ArrayList<>();
			aula1l.add(televisor48);
			aula1l.add(mesaTrabajo);

			Salon galponMateriales = new Salon();
			galponMateriales.setId(9L);
			galponMateriales.setNombre("Galpón de materiales");
			galponMateriales.setCapacidadMaxima(100);
			galponMateriales.setPractica(true);
			galponMateriales.setMateriales(galponMaterialesl);
			//robotica.setTipo(?);

			ArrayList<Material> galponMaterialesl = new ArrayList<>();
			galponMaterialesl.add(tractor);
			galponMaterialesl.add(molino);


			ArrayList<Salon> salonesABM = new ArrayList<>();
			salonesABM.add(robotica);
			salonesABM.add(aula3);
			salonesABM.add(salaServidores);
			salonesABM.add(lab1);
			salonesABM.add(aula2);
			salonesABM.add(depositoMat);
			salonesABM.add(lab2);
			salonesABM.add(aula1);
			salonesABM.add(galponMateriales);
			
			
			try {
				for (Salon salon : salonesABM) {
					salonesBean.crear(salon);
					System.out.println("Se ha creado exitosamente el salon: " + salon.getNombre());
				}
			} catch(ServiciosException e) {
				System.out.println(e.getMessage()); 
			}

			try {
				String viejoNombre1 = robotica.getNombre();
				
				robotica.setNombre("roboticaV2.0");
				salonesBean.actualizar(robotica);
				
				System.out.println("Se ha actualizado exitosamente el salon " + viejoNombre +  " a " + robotica.getNombre());
			} catch(ServiciosException e) {
				System.out.println(e.getMessage()); 
			}
			
			
			try {
				String viejoNombre = robotica.getNombre();
				
				salonesBean.borrar(robotica.getId());
				
				System.out.println("Se ha borrado existosamente el salon: " + viejoNombre);
			} catch(ServiciosException e) {
				System.out.println(e.getMessage()); 
			}


			//-----------------------------------------------------------------

			MaterialBeanRemote materialBean = (MaterialBeanRemote) InitialContext.doLookup("UniversidadEJB/MaterialBean!com.servicios.MaterialBeanRemote");
			
			Material placaArduino = new Material();
			placaArduino.setId(1L);
			placaArduino.setNombre("placa Arduino");
			placaArduino.setDescripcion("placa de Arduino");

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

			Material cañon = new Material();
			cañon.setId(11L);
			cañon.setNombre("cañon");
			cañon.setDescripcion("cañon");

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
			materialesABM.add(cañon);
			materialesABM.add(panelMovil);
			materialesABM.add(mesaOperaciones);
			materialesABM.add(maqueta1);
			materialesABM.add(maqueta2);
			materialesABM.add(televisor48);
			materialesABM.add(mesaTrabajo);
			materialesABM.add(tractor);
			materialesABM.add(molino);
			
			
			try {
				for (Material material : materialesABM) {
					areaBean.crear(material);
					System.out.println("Se ha creado exitosamente el material: " + material.getNombre());
				}
			} catch(ServiciosException e) {
				System.out.println(e.getMessage()); 
			}

			try {
				String viejoNombre1 = placaArduino.getNombre();
				
				placaArduino.setNombre("placaArduinoV2.0");
				materialBean.actualizar(placaArduino);
				
				System.out.println("Se ha actualizado exitosamente el material " + viejoNombre1 +  " a " + placaArduino.getNombre());
			} catch(ServiciosException e) {
				System.out.println(e.getMessage()); 
			}
			
			
			try {
				String viejoNombre1 = placaArduino.getNombre();
				
				materialBean.borrar(placaArduino.getId());
				
				System.out.println("Se ha borrado existosamente el material: " + viejoNombre1);
			} catch(ServiciosException e) {
				System.out.println(e.getMessage()); 
			}

			//----------------------------------------------------------------------

			AreaBeanRemote areaBean = (AreaBeanRemote) InitialContext.doLookup("UniversidadEJB/AreaBean!com.servicios.AreaBeanRemote");
			
			/* PRIMERO CREAR MATERIALES
			 * LUEGO SALONES y AGREGARLES MATERIALES
			 * 
			 * UNA VEZ HECHO ESO DESCOMENTAR EL AGREGADO DE SALONES A AREA
			 * */
			
			/*AB Area*/
			/*Primer Area--------------------------------------------------------------*/
			Area areaLTI = new Area();
			areaLTI.setId(1L);
			areaLTI.setNombre("�rea LTI");
			
			
			/*ACA VAN SALONES CREADOS Arriba*/
			ArrayList<Salon> salonesLTI = new ArrayList<>();
			
			//salonesLTI.add(salonRobotica)
			//salonesLTI.add(aula3)
			//salonesLTI.add(salaServidores)
			
			//areaLTI.setSalones(salonesLTI);
			
			/*Segunda Area--------------------------------------------------------------*/
			Area areaBiomedicas = new Area();
			areaBiomedicas.setId(2L);
			areaBiomedicas.setNombre("�rea Biom�dicas");
			
			
			/*ACA VAN SALONES CREADOS Arriba*/
			ArrayList<Salon> salonesBiomedica = new ArrayList<>();
			
			//salonesBiomedica.add(lab1)
			//salonesBiomedica.add(aula2)
			//salonesBiomedica.add(depositoMat)
			
			//areaBiomedicas.setSalones(salonesBiomedica);
			
			/*Tercer Area--------------------------------------------------------------*/
			Area areaIAgro = new Area();
			areaIAgro.setId(3L);
			areaIAgro.setNombre("�rea IAgro");
			
			
			/*ACA VAN SALONES CREADOS Arriba*/
			ArrayList<Salon> salonesIAgro = new ArrayList<>();
			
			//salonesIAgro.add(lab2)
			//salonesIAgro.add(aula1)
			//salonesIAgro.add(galponMateriales)

			//areaIAgro.setSalones(salonesIAgro);
			
			/*ABM--------------------------------------------------------------*/
			
			ArrayList<Area> areasABM = new ArrayList<>();
			areasABM.add(areaLTI);
			areasABM.add(areaBiomedicas);
			areasABM.add(areaIAgro);
			
			
			try {
				for (Area area : areasABM) {
					areaBean.crear(area);
					System.out.println("Se ha creado exitosamente el �rea: " + area.getNombre());
				}
			} catch(ServiciosException e) {
				System.out.println(e.getMessage()); 
			}
			
			/*MODIFICACION AreaLTI*/
						
			try {
				String viejoNombre2 = areaLTI.getNombre();
				
				areaLTI.setNombre("�reaLTIV2.0");
				areaBean.actualizar(areaLTI);
				
				System.out.println("Se ha actualizado exitosamente el �rea " + viejoNombre2 +  " a " + areaLTI.getNombre());
			} catch(ServiciosException e) {
				System.out.println(e.getMessage()); 
			}
			
			/*BAJA AreaIAgro*/
			
			try {
				String viejoNombre2 = areaIAgro.getNombre();
				
				areaBean.borrar(areaIAgro.getId());
				
				System.out.println("Se ha borrado existosamente el �rea: " + viejoNombre2);
			} catch(ServiciosException e) {
				System.out.println(e.getMessage()); 
			}
			
	}
	

}
