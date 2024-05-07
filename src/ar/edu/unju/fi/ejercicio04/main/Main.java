package ar.edu.unju.fi.ejercicio04.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio04.Constantes.Posicion;
import ar.edu.unju.fi.ejercicio04.model.Jugador;

public class Main {

	public static void main(String[] args) {
		ArrayList<Jugador> jugadores = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("Menú:");
            System.out.println("1 – Alta de jugador");
            System.out.println("2 – Mostrar todos los jugadores");
            System.out.println("3 – Modificar la posición de un jugador");
            System.out.println("4 – Eliminar un jugador");
            System.out.println("5 – Salir");

            try {
                opcion = scanner.nextInt();
                switch (opcion) {
                    case 1:
                        agregarJugador(jugadores);
                        break;
                    case 2:
                        mostrarJugadores(jugadores);
                        break;
                    case 3:
                        modificarPosicion(jugadores);
                        break;
                    case 4:
                        eliminarJugador(jugadores);
                        break;
                    case 5:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Debe ingresar un número.");
                scanner.nextLine(); // Limpiar el buffer del scanner
                opcion = 0;
            } finally {
                System.out.println();
            }
        } while (opcion != 5);

        scanner.close();
	}

	private static void agregarJugador(ArrayList<Jugador> jugadores) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre del jugador:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el apellido del jugador:");
        String apellido = scanner.nextLine();
        System.out.println("Ingrese la fecha de nacimiento del jugador (AAAA-MM-DD):");
        LocalDate fechaNacimiento = LocalDate.parse(scanner.nextLine());
        System.out.println("Ingrese la nacionalidad del jugador:");
        String nacionalidad = scanner.nextLine();
        System.out.println("Ingrese la estatura del jugador:");
        double estatura = scanner.nextDouble();
        System.out.println("Ingrese el peso del jugador:");
        double peso = scanner.nextDouble();

        System.out.println("Posiciones:");
        for (Posicion posicion : Posicion.values()) {
            System.out.println((posicion.ordinal() + 1) + " - " + posicion);
        }
        System.out.println("Ingrese la posición del jugador:");
        int posicionIndex = scanner.nextInt();
        Posicion posicion = Posicion.values()[posicionIndex - 1];

        jugadores.add(new Jugador(nombre, apellido, fechaNacimiento, nacionalidad, estatura, peso, posicion));
        System.out.println("Jugador agregado con éxito.");
    }
	private static void mostrarJugadores(ArrayList<Jugador> jugadores) {
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores registrados.");
        } else {
            for (Jugador jugador : jugadores) {
                System.out.println(jugador);
            }
        }
    
    }
	private static void modificarPosicion(ArrayList<Jugador> jugadores) {
        Scanner scanner = new Scanner(System.in);

        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores registrados.");
        } else {
            System.out.println("Ingrese el nombre del jugador:");
            String nombre = scanner.nextLine();
            System.out.println("Ingrese el apellido del jugador:");
            String apellido = scanner.nextLine();

            boolean encontrado = false;
            Iterator<Jugador> iterator = jugadores.iterator();
            while (iterator.hasNext()) {
                Jugador jugador = iterator.next();
                if (jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)) {
                    System.out.println("Posiciones:");
                    for (Posicion posicion : Posicion.values()) {
                        System.out.println((posicion.ordinal() + 1) + " - " + posicion);
                    }
                    System.out.println("Ingrese la nueva posición del jugador:");
                    int posicionIndex = scanner.nextInt();
                    Posicion nuevaPosicion = Posicion.values()[posicionIndex - 1];
                    jugador.setPosicion(nuevaPosicion);
                    System.out.println("Posición modificada con éxito.");
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("No se encontró ningún jugador con ese nombre y apellido.");
            }
        }
    }
	private static void eliminarJugador(ArrayList<Jugador> jugadores) {
        Scanner scanner = new Scanner(System.in);

        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores registrados.");
        } else {
            System.out.println("Ingrese el nombre del jugador:");
            String nombre = scanner.nextLine();
            System.out.println("Ingrese el apellido del jugador:");
            String apellido = scanner.nextLine();

            Iterator<Jugador> iterator = jugadores.iterator();
            while (iterator.hasNext()) {
                Jugador jugador = iterator.next();
                if (jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)) {
                    iterator.remove();
                    System.out.println("Jugador eliminado con éxito.");
                    return;
                }
            }
            System.out.println("No se encontró ningún jugador con ese nombre y apellido.");
        }
    }
}
