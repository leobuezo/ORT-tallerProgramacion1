package ort.edu.ar.ej1;

import java.util.ArrayList;

public class Grupo {
	private String nombre;
	private ArrayList<String> integrantes;
	
	public Grupo(String nombre) {
		this.nombre = nombre;
		this.integrantes = new ArrayList<String>();
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getCantidadIntegrantes() {
		return integrantes.size();
	}
	
	public void agregarIntegrante(String nombreIntegrante) {
		int contador = this.obtenerPosicionIntegrante(nombreIntegrante);
		if(contador == -1) {
			this.integrantes.add(nombreIntegrante);
		}
	}
	
	public int obtenerPosicionIntegrante(String nombreIntegrante) {
		boolean existe = false;
		int contador = 0;
		while(contador < this.integrantes.size() && existe == false) {
			if(this.integrantes.get(contador).equals(nombreIntegrante)) {
				existe = true;
			} else {
				contador++;
			}
		}
		if(existe == false) {
			contador = 0;
		}
		return contador;
	}

	public String obtenerIntegrante(int posicion) {
		String nombreIntegrante = null;
		if(posicion > 0 && posicion -1 < this.integrantes.size()) {
			nombreIntegrante = this.integrantes.get(posicion -1);
		}
		return nombreIntegrante;
	}
	
	public String buscarIntegrante(String nombreIntegrante) {
		String nombreBuscar = null;
		int posicion = this.obtenerPosicionIntegrante(nombreIntegrante);
		if(posicion != -1) {
			nombreBuscar = this.integrantes.get(posicion);
		}
		return nombreBuscar;
	}
	
	public String removerIntegrante(String nombreIntegrante) {
		String nombreABorrar = null;
		if(this.buscarIntegrante(nombreIntegrante) != null) {
			nombreABorrar = this.integrantes.remove(this.obtenerPosicionIntegrante(nombreIntegrante));
		}
		return nombreABorrar;
	}
	
}
