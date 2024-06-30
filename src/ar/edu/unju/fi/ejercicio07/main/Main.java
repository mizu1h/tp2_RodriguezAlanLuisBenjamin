package ar.edu.unju.fi.ejercicio07.main;
import ar.edu.unju.fi.ejercicio05.model.Producto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		List<Producto> productos = new ArrayList<>();
        productos.add(new Producto(1, "Televisor", 2500.0, true, "Electrohogar"));
        productos.add(new Producto(2, "Lavadora", 3000.0, true, "Electrohogar"));
        productos.add(new Producto(3, "Refrigerador", 7000.0, false, "Electrohogar"));
        productos.add(new Producto(4, "Computadora", 10000.0, true, "Tecnología"));
        productos.add(new Producto(5, "Celular", 80000.0, false, "Tecnología"));
        productos.add(new Producto(6, "Aspiradora",24000.0, true, "Electrohogar"));
        productos.add(new Producto(7, "Tableta gráfica",12000.0, false, "Tecnología"));
        productos.add(new Producto(8, "Plancha de vapor",2500.0, true, "Electrohogar"));
        
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1 – Mostrar productos disponibles");
            System.out.println("2 – Mostrar productos faltantes");
            System.out.println("3 – Incrementar precios en un 20%");
            System.out.println("4 – Mostrar productos de categoría 'Electrohogar' disponibles");
            System.out.println("5 – Ordenar productos por precio de forma descendente");
            System.out.println("6 – Mostrar productos con nombres en mayúsculas");
            System.out.println("7 – Salir");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    ProductosDisponibles(productos);
                    break;
                case 2:
                    ProductosFaltantes(productos);
                    break;
                case 3:
                    incrementarPrecios(productos);
                    break;
                case 4:
                    mostrarProductosElectrohogarDisponibles(productos);
                    break;
                case 5:
                    ordenarProductosPorPrecioDescendente(productos);
                    break;
                case 6:
                    mostrarProductosConNombresEnMayusculas(productos);
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
	}
	
	//opción 1
	private static void ProductosDisponibles(List<Producto> productos) {
		Consumer<Producto> consumidor = System.out::println;
        productos.stream()
                .filter(Producto::isDisponible)
                .forEach(consumidor);
	   }	
	//opción 2
	private static void ProductosFaltantes(List<Producto> productos) {
		Predicate<Producto> predicado = producto -> !producto.isDisponible();
        productos.stream()
                .filter(predicado)
                .forEach(System.out::println);
    }
	//opción 3
	private static void incrementarPrecios(List<Producto> productos) {
		 Function<Producto, Producto> funcion = producto -> {
	            producto.setPrecio(producto.getPrecio() * 1.20);
	            return producto;
	        };
	        List<Producto> productosIncrementados = productos.stream()
	                .map(funcion)
	                .collect(Collectors.toList());
	        productosIncrementados.forEach(System.out::println);
	        
    }
	//opción 4
    private static void mostrarProductosElectrohogarDisponibles(List<Producto> productos) {
    	 Predicate<Producto> predicado = producto -> "Electrohogar".equals(producto.getCategoria()) && producto.isDisponible();
         productos.stream()
                 .filter(predicado)
                 .forEach(System.out::println);
    }
    //opción 5
    private static void ordenarProductosPorPrecioDescendente(List<Producto> productos) {
    	productos.sort(Comparator.comparingDouble(Producto::getPrecio).reversed());
        productos.forEach(System.out::println);
    }
    //opción 6
    private static void mostrarProductosConNombresEnMayusculas(List<Producto> productos) {
    	 Function<Producto, Producto> funcion = producto -> {
             producto.setNombre(producto.getNombre().toUpperCase());
             return producto;
         };
         productos.stream()
                 .map(funcion)
                 .forEach(System.out::println);
    }
    
}
