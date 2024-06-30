package ar.edu.unju.fi.ejercicio05.main;

import ar.edu.unju.fi.ejercicio05.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio05.model.PagoTarjeta;
import ar.edu.unju.fi.ejercicio05.model.Producto;
import ar.edu.unju.fi.ejercicio05.interfaces.Pago;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
	 public static void main(String[] args) {
	List<Producto> productos = new ArrayList<>();
    productos.add(new Producto(1, "Televisor", 5000.0, true, "Electrohogar"));
    productos.add(new Producto(2, "Lavadora", 3000.0, true, "Electrohogar"));
    productos.add(new Producto(3, "Refrigerador", 7000.0, false, "Electrohogar"));
    productos.add(new Producto(4, "Computadora", 1500.0, true, "Tecnología"));
    productos.add(new Producto(5, "Celular", 8000.0, false, "Tecnología"));

    Scanner scanner = new Scanner(System.in);
    while (true) {
        System.out.println("1 – Mostrar productos");
        System.out.println("2 – Realizar compra");
        System.out.println("3 – Salir");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                mostrarProductos(productos);
                break;
            case 2:
                realizarCompra(productos, scanner);
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Opción no válida");
        }
    }
}
	private static void mostrarProductos(List<Producto> productos) {
	for (Producto producto : productos) {
	            System.out.println(producto);
	}
	}
	private static void realizarCompra(List<Producto> productos, Scanner scanner) {
	System.out.println("Ingrese el ID del producto que desea comprar:");
	int idProducto = scanner.nextInt();
	Producto productoSeleccionado = null;

	 	        for (Producto producto : productos) {
	 	            if (producto.getId() == idProducto) {
	 	                productoSeleccionado = producto;
	 	                break;
	 	            }
	 	        }
	 	       if (productoSeleccionado == null) {
	 	            System.out.println("Producto no encontrado.");
	 	            return;
	 	        }
	 	      System.out.println("Seleccione el método de pago:");
	 	        System.out.println("1 – Tarjeta");
	 	        System.out.println("2 – Efectivo");
	 	        int metodoPago = scanner.nextInt();
	 	        Pago pago = null;

	 	        switch (metodoPago) {
	 	            case 1:
	 	                System.out.println("Ingrese el número de tarjeta:");
	 	                String numeroTarjeta = scanner.next();
	 	                pago = new PagoTarjeta(numeroTarjeta, LocalDate.now());
	 	                break;
	 	            case 2:
	 	                pago = new PagoEfectivo(LocalDate.now());
	 	                break;
	 	            default:
	 	                System.out.println("Método de pago no válido.");
	 	                return;
	 	        }
	 	       pago.realizarPago(productoSeleccionado.getPrecio());
	 	       pago.imprimirRecibo();
	 	    }
}

