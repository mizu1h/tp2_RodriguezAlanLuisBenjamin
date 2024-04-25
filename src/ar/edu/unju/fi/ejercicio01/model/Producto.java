package ar.edu.unju.fi.ejercicio01.model;

public class Producto {
	private String  codigo;
	private String 	descripcion;
	private double preciounidad;
	private Origenes origenFabricacion;
	private Categorias categoria;
	public enum Origenes{
		ARGENTINA,CHINA,BRASIL,URUGUAY;
	}
	public enum Categorias{
		TELEFONIA,INFORMATICA,ELECTRO_HOGAR,HERRAMIENTAS;
	}
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPreciounidad() {
		return preciounidad;
	}

	public void setPreciounidad(double preciounidad) {
		this.preciounidad = preciounidad;
	}

	public Origenes getOrigenFabricacion() {
		return origenFabricacion;
	}

	public void setOrigenFabricacion(Origenes origenFabricacion) {
		this.origenFabricacion = origenFabricacion;
	}

	public Categorias getCategoria() {
		return categoria;
	}

	public void setCategoria(Categorias categoria) {
		this.categoria = categoria;
	}
	
}
	
