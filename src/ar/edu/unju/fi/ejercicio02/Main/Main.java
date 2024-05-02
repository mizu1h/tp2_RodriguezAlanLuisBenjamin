package ar.edu.unju.fi.ejercicio02.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio02.constantes.Constantes.Mes;
import ar.edu.unju.fi.ejercicio02.model.Efemeride;

public class Main {
	private static Scanner sc;
	public static void main(String[] args) {
		
		sc = new Scanner(System.in);
        List<Efemeride> Listado = new ArrayList<>();
        int opcion;

        do {
            mostrarMenu();
            System.out.print("Ingrese la opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch(opcion){
			case 1:{
				Efemeride efeme = new Efemeride();
				efeme = crearEfemeride(efeme);
				Listado.add(efeme);
				break;
			}
			case 2:{
				int p = 1;
				for(Efemeride f : Listado){
					System.out.println("Datos de la efemeride" + p);
					mostrarEfemerides(f);
				}
				break;
			}
			case 3:{
				eliminarEfemeride(Listado, sc);			
				break;
			}
			case 4:{
				System.out.println("ingrese el numero del mes: ");
				int mes = sc.nextInt();
				for(Efemeride f : Listado) {
					if(f.getMes().ordinal()+1 == mes){
						f = Modificar(f);
						System.out.println("*********");
					}
				}
				break;
			}
			
			case 5:{
				System.out.println("Fin de Programa");
				break;
			}
			}
        } while (opcion != 5);

        sc.close();
	}
	private static void mostrarMenu() {
        System.out.println("***Menu***");
        System.out.println("1 – Crear efeméride");
        System.out.println("2 – Mostrar efemérides");
        System.out.println("3 – Eliminar efeméride");
        System.out.println("4 – Modificar efeméride");
        System.out.println("5 – Salir.");
    }
	public static Efemeride crearEfemeride(Efemeride efe) {
		
		Boolean band = false;
		
		sc = new Scanner(System.in);
		do {
			try {
				System.out.println("Ingrese el codigo: ");
				String codigo = sc.next();
				efe.setCodigo(codigo);
				band = true;
			}catch (Exception e) {
				System.out.println("Error en el ingreso de datos");
			}
		}while(!band);
		band = false;
		
		do {
			try {
				System.out.println("***MES**");
				System.out.println("1 - Enero");
				System.out.println("2 - Febrero");
				System.out.println("3 - Marzo");
				System.out.println("4 - Abril");
				System.out.println("5 - Mayo");
				System.out.println("6 - Junio");
				System.out.println("7 - Julio");
				System.out.println("8 - Agosto");
				System.out.println("9 - Septiembre");
				System.out.println("10 - Octubre");
				System.out.println("11 - Noviembre");
				System.out.println("12 - Diciembre");
				System.out.println("Ingrese la opcion: ");
				int mes = sc.nextInt();
				switch(mes){
					case 1:{
						efe.setMes(Mes.ENERO);
						band = true;
						break;
					}
					case 2:{
						efe.setMes(Mes.FEBRERO);
						band = true;
						break;
					}
					case 3:{
						efe.setMes(Mes.MARZO);
						band = true;
						break;
					}
					case 4:{
						efe.setMes(Mes.ABRIL);
						band = true;
						break;
					}
					case 5:{
						efe.setMes(Mes.MAYO);
						band = true;
						break;
					}
					case 6:{
						efe.setMes(Mes.JUNIO);
						band = true;
						break;
					}
					case 7:{
						efe.setMes(Mes.JULIO);
						band = true;
						break;
					}
					case 8:{
						efe.setMes(Mes.AGOSTO);
						band = true;
						break;
					}
					case 9:{
						efe.setMes(Mes.SEPTIEMBRE);
						band = true;
						break;
					}
					case 10:{
						efe.setMes(Mes.OCTUBRE);
						band = true;
						break;
					}
					
					case 11:{
						efe.setMes(Mes.NOVIEMBRE);
						band = true;
						break;
					}
					case 12:{
						efe.setMes(Mes.DICIEMBRE);
						band = true;
						break;
					}
					default:{
						band = false;
						break;
					}
				}
			}catch (Exception e) {
				System.out.println("Error en el ingreso de datos");
			}
		}while(!band);
		band = false;
		do {
			try {
				System.out.println("Ingrese el dia: ");
				int dia = sc.nextInt();
				sc.nextLine();
				if(dia > 0 && dia < 32){
					efe.setDia(dia);
					band = true;
				}
			}catch(Exception e){
				System.out.println("Error en el ingreso de datos");
			}
		}while(!band);
		band = false;
		
		do {
			try {
				System.out.println("Ingrese el detalle: ");
				String detalle = sc.nextLine();
				efe.setDetalle(detalle);
				band = true;					
			}catch(Exception e){
				System.out.println("Error en el ingreso de datos");
			}
		}while(!band);
		band = false;
		
		return efe;
	}
	public static void mostrarEfemerides(Efemeride efe){
	System.out.println(efe.toString());
	}
	private static void eliminarEfemeride(List<Efemeride> efemerides, Scanner sc) {
	    if (efemerides.isEmpty()) {
	        System.out.println("No hay efemérides para eliminar.");
	        return; // Salir del método si no hay efemérides
	    }
	    System.out.print("Ingrese el código del efemeride a eliminar: ");
	    String codigo = sc.next();
	    boolean encontrado = false;
	    for (Efemeride efemeride : efemerides) {
	        if (codigo.equals(efemeride.getCodigo())) {
	            efemerides.remove(efemeride);
	            encontrado = true;
	            System.out.println("Efemeride eliminado.");
	            break; // Salir del bucle una vez que se encuentra y elimina la efeméride
	        }
	    }
	    if (!encontrado) {
	        System.out.println("No se encontró ninguna efeméride con ese código.");
	    }
	}
	public static Efemeride Modificar(Efemeride efe){
		sc = new Scanner(System.in);
		int opcion;
		
		do {
			System.out.println("***Menu***");
			System.out.println("1 – Cambiar mes");
			System.out.println("2 – Cambiar dia");
			System.out.println("3 – Cambiar detalle");
			System.out.println("4 – Salir");
			System.out.println("Ingrese la opcion: ");
			opcion = sc.nextInt();
			switch(opcion){
			case 1:{
				Boolean band  = false;
				do {
					try {
						System.out.println("***MES**");
						System.out.println("1 - Enero");
						System.out.println("2 - Febrero");
						System.out.println("3 - Marzo");
						System.out.println("4 - Abril");
						System.out.println("5 - Mayo");
						System.out.println("6 - Junio");
						System.out.println("7 - Julio");
						System.out.println("8 - Agosto");
						System.out.println("9 - Septiembre");
						System.out.println("10 - Octubre");
						System.out.println("11 - Noviembre");
						System.out.println("12 - Diciembre");
						System.out.println("Ingrese la opcion: ");
						int mes = sc.nextInt();
						switch(mes){
							case 1:{
								efe.setMes(Mes.ENERO);
								band = true;
								break;
							}
							case 2:{
								efe.setMes(Mes.FEBRERO);
								band = true;
								break;
							}
							case 3:{
								efe.setMes(Mes.MARZO);
								band = true;
								break;
							}
							case 4:{
								efe.setMes(Mes.ABRIL);
								band = true;
								break;
							}
							case 5:{
								efe.setMes(Mes.MAYO);
								band = true;
								break;
							}
							case 6:{
								efe.setMes(Mes.JUNIO);
								band = true;
								break;
							}
							case 7:{
								efe.setMes(Mes.JULIO);
								band = true;
								break;
							}
							case 8:{
								efe.setMes(Mes.AGOSTO);
								band = true;
								break;
							}
							case 9:{
								efe.setMes(Mes.SEPTIEMBRE);
								band = true;
								break;
							}
							case 10:{
								efe.setMes(Mes.OCTUBRE);
								band = true;
								break;
							}
							
							case 11:{
								efe.setMes(Mes.NOVIEMBRE);
								band = true;
								break;
							}
							case 12:{
								efe.setMes(Mes.DICIEMBRE);
								band = true;
								break;
							}
							default:{
								band = false;
								break;
							}
						}
					}catch (Exception e) {
						System.out.println("Error en el ingreso de datos");
					}
				}while(!band);
				break;
			}
			case 2:{
				Boolean band = false;
				do {
					try {
						System.out.println("Ingrese el dia: ");
						int dia = sc.nextInt();
						sc.nextLine();
						if(dia > 0 && dia < 32){
							efe.setDia(dia);
							band = true;
						}
					}catch(Exception e){
						System.out.println("Error en el ingreso de datos");
					}
				}while(!band);
				break;
			}
			case 3:{
				Boolean band = false;
				do {
					try {
						System.out.println("Ingrese el detalle: ");
						String detalle = sc.nextLine();
						sc.nextLine();
						efe.setDetalle(detalle);
						band = true;					
					}catch(Exception e){
						System.out.println("Error en el ingreso de datos");
					}
				}while(!band);
				break;
			}
			case 4:{
				
				break;
			}
			default:{
				System.out.println("fuera de rango");
				break;
			}
			}
		}while(opcion != 4);
		
		return efe;
	}
}
	
	

