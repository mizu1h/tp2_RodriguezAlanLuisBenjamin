package ar.edu.unju.fi.ejercicio06.model;

public class FelinoSalvaje {
	private String nombre;
    private byte edad;
    private float peso;
    public FelinoSalvaje(String nombre, byte edad, float peso) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
    }
    
    public String getNombre() {
        return nombre;
    }

    public byte getEdad() {
        return edad;
    }

    public float getPeso() {
        return peso;
    }
    public String toString() {
        return "Felino Salvaje [nombre=" + nombre + ", edad=" + edad + ", peso(kg)=" + peso + "]";
    }
}
