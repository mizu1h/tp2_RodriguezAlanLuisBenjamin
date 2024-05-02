package ar.edu.unju.fi.ejercicio01.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import ar.edu.unju.fi.ejercicio01.model.Producto;
import ar.edu.unju.fi.ejercicio01.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio01.model.Producto.Origen;

public class Main {

	public static void main(String[] args) {
		        List<Producto> productos = new ArrayList<>();
		        Scanner sc = new Scanner(System.in);
		        int opcion = 0;
		        boolean valido = false;

		         do{
		            do {
		                valido = false;
		                System.out.print("\n*** MENÚ ***\n");
		                System.out.print("1) Crear Producto\n");
		                System.out.print("2) Mostrar productos\n");
		                System.out.print("3) Modificar producto\n");
		                System.out.print("4) Salir\n");
		                try {
		                    System.out.print("Opción: ");
		                    opcion = Integer.parseInt(sc.next());
		                    if (opcion < 1 || opcion > 4) {
		                        System.out.print("\nOpción no válida\n");
		                    } else {
		                        valido = true;
		                    }
		                } catch (NumberFormatException e) {
		                    System.out.print("\nIngrese una opción válida\n");
		                }
		            } while (!valido);

		            switch (opcion) {
		                case 1:
		                    crearProducto(productos, sc);
		                    break;
		                case 2:
		                    mostrarProductos(productos);
		                    break;
		                case 3:
		                    modificarProducto(productos, sc);
		                    break;
		            }
		        }while (opcion != 4);
		        sc.close();
		    }

		    private static void crearProducto(List<Producto> productos, Scanner sc) {
		        Producto producto = new Producto();
		        String codigo = null, descripcion;
		        float precio = 0;
		        boolean valido = false;

		        while (!valido) {
		            valido = true;
		            System.out.print("Ingrese el código del Producto: ");
		            codigo = sc.next();
		            for (Producto p : productos) {
		                if (p.getCodigo().equals(codigo)) {
		                    valido = false;
		                    break;
		                }
		            }
		            if (!valido) {
		                System.out.println("Código ya existente. Ingrese uno nuevo\n");
		            }
		        }

		        System.out.print("Ingrese la descripción: ");
		        sc.nextLine();
		        descripcion = sc.nextLine();

		        valido = false;
		        while (!valido) {
		            System.out.print("Ingrese el precio del Producto: ");
		            try {
		                precio = Float.parseFloat(sc.next());
		                if (precio < 0) {
		                    System.out.println("Precio no válido");
		                } else {
		                    valido = true;
		                }
		            } catch (NumberFormatException e) {
		                System.out.println("Ingrese un precio valido");
		            }
		        }

		        producto.setCodigo(codigo);
		        producto.setDescripcion(descripcion);
		        producto.setPreciounidad(precio);

		        valido = false;
		        int opcion = 0;
		        do {
		            System.out.print("\n*** Origen de Fabricación ***\n");
		            System.out.print("1) ARGENTINA\n");
		            System.out.print("2) CHINA\n");
		            System.out.print("3) BRASIL\n");
		            System.out.print("4) URUGUAY\n");
		            try {
		                System.out.print("Opción: ");
		                opcion = Integer.parseInt(sc.next());
		                if (opcion < 1 || opcion > 4) {
		                    System.out.print("\nOpción no válida\n");
		                } else {
		                    valido = true;
		                }
		            } catch (NumberFormatException e) {
		                System.out.print("\nIngrese una opción válida\n");
		            }
		        } while (!valido);

		        switch (opcion) {
		            case 1:
		                producto.setOrigenFabricacion(Origen.ARGENTINA);
		                break;
		            case 2:
		                producto.setOrigenFabricacion(Origen.CHINA);
		                break;
		            case 3:
		                producto.setOrigenFabricacion(Origen.BRASIL);
		                break;
		            case 4:
		                producto.setOrigenFabricacion(Origen.URUGUAY);
		                break;
		        }

		        valido = false;
		        do {
		            System.out.print("\n*** Categoría ***\n");
		            System.out.print("1) Telefonía\n");
		            System.out.print("2) Informática\n");
		            System.out.print("3) Electro Hogar\n");
		            System.out.print("4) Herramientas\n");
		            try {
		                System.out.print("Opción: ");
		                opcion = Integer.parseInt(sc.next());
		                if (opcion < 1 || opcion > 4) {
		                    System.out.print("\nOpción no válida\n");
		                } else {
		                    valido = true;
		                }
		            } catch (NumberFormatException e) {
		                System.out.print("\nIngrese una opción válida\n");
		            }
		        } while (!valido);

		        switch (opcion) {
		            case 1:
		                producto.setCategoria(Categoria.TELEFONIA);
		                break;
		            case 2:
		                producto.setCategoria(Categoria.INFORMATICA);
		                break;
		            case 3:
		                producto.setCategoria(Categoria.ELECTRO_HOGAR);
		                break;
		            case 4:
		                producto.setCategoria(Categoria.HERRAMIENTAS);
		                break;
		        }

		        productos.add(producto);
		    }

		    private static void mostrarProductos(List<Producto> productos) {
		        System.out.println("\n** Productos **\n");
		        for (Producto producto : productos) {
		            System.out.println("Código: " + producto.getCodigo());
		            System.out.println("Descripción: " + producto.getDescripcion());
		            System.out.println("Precio Unitario: " + producto.getPreciounidad() + " $");
		            System.out.println("Origen de Fabricación: " + producto.getOrigenFabricacion());
		            System.out.println("Categoría: " + producto.getCategoria() + "\n");
		        }
		    }

		    private static void modificarProducto(List<Producto> productos, Scanner sc) {
		        String codigo, descripcion;
		        float precio = 0;
		        int opcion = 0;
		        boolean encontrado = false;

		        System.out.print("\nIngrese el código del Producto a modificar: ");
		        codigo = sc.next();

		        for (Producto producto : productos) {
		            if (producto.getCodigo().equals(codigo)) {
		                encontrado = true;
		                System.out.print("\nProducto Encontrado\n");
		                System.out.print("Ingrese la descripción: ");
		                sc.nextLine();
		                descripcion = sc.nextLine();
		                producto.setDescripcion(descripcion);

		                boolean valido = false;
		                while (!valido) {
		                    System.out.print("Ingrese el precio del Producto: ");
		                    try {
		                        precio = Float.parseFloat(sc.next());
		                        if (precio < 0) {
		                            System.out.println("Precio no válido");
		                        } else {
		                            valido = true;
		                        }
		                    } catch (NumberFormatException e) {
		                        System.out.println("Ingrese un precio valido ");
		                    }
		                }
		                producto.setPreciounidad(precio);

		                valido = false;
		                do {
		                    System.out.print("\n*** Origen de Fabricación ***\n");
		                    System.out.print("1) ARGENTINA\n");
		                    System.out.print("2) CHILE\n");
		                    System.out.print("3) BRASIL\n");
		                    System.out.print("4) URUGUAY\n");
		                    try {
		                        System.out.print("Opción: ");
		                        opcion = Integer.parseInt(sc.next());
		                        if (opcion < 1 || opcion > 4) {
		                            System.out.print("\nOpción no válida\n");
		                        } else {
		                            valido = true;
		                        }
		                    } catch (NumberFormatException e) {
		                        System.out.print("\nIngrese una opción válida\n");
		                    }
		                } while (!valido);

		                switch (opcion) {
		                    case 1:
		                        producto.setOrigenFabricacion(Origen.ARGENTINA);
		                        break;
		                    case 2:
		                        producto.setOrigenFabricacion(Origen.CHINA);
		                        break;
		                    case 3:
		                        producto.setOrigenFabricacion(Origen.BRASIL);
		                        break;
		                    case 4:
		                        producto.setOrigenFabricacion(Origen.URUGUAY);
		                        break;
		                }

		                valido = false;
		                do {
		                    System.out.print("\n*** Categoría ***\n");
		                    System.out.print("1) Telefonía\n");
		                    System.out.print("2) Informática\n");
		                    System.out.print("3) Electro Hogar\n");
		                    System.out.print("4) Herramientas\n");
		                    try {
		                        System.out.print("Opción: ");
		                        opcion = Integer.parseInt(sc.next());
		                        if (opcion < 1 || opcion > 4) {
		                            System.out.print("\nOpción no válida\n");
		                        } else {
		                            valido = true;
		                        }
		                    } catch (NumberFormatException e) {
		                        System.out.print("\nIngrese una opcion válida\n");
		                    }
		                } while (!valido);

		                switch (opcion) {
		                    case 1:
		                        producto.setCategoria(Categoria.TELEFONIA);
		                        break;
		                    case 2:
		                        producto.setCategoria(Categoria.INFORMATICA);
		                        break;
		                    case 3:
		                        producto.setCategoria(Categoria.ELECTRO_HOGAR);
		                        break;
		                    case 4:
		                        producto.setCategoria(Categoria.HERRAMIENTAS);
		                        break;
		                }
		                System.out.print("\nProducto Modificado\n");
		                break;
		            }
		        }

		        if (!encontrado) {
		            System.out.print("\nProducto no encontrado\n");
		        }
		    }
		
}

