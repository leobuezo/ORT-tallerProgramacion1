package ort.edu.ar.ej3;

public class Corredor {
	private String nombre;
	private double tiempo;
	
	public Corredor (String nombre, double tiempo) {
		this.nombre = nombre;
		this.tiempo = tiempo;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getTiempo() {
		return tiempo;
	}
	public void setTiempo(double tiempo) {
		this.tiempo = tiempo;
	}
	
}
