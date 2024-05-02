package ar.edu.unju.fi.ejercicio01.model;

public class Producto {
	private String  codigo;
	private String 	descripcion;
	private double preciounidad;
	private Origen origenFabricacion;
	private Categoria categoria;
	public enum Origen{
		ARGENTINA,CHINA,BRASIL,URUGUAY;
	}
	public enum Categoria{
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

	public Origen getOrigenFabricacion() {
		return origenFabricacion;
	}

	public void setOrigenFabricacion(Origen origenFabricacion) {
		this.origenFabricacion = origenFabricacion;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
}
	
