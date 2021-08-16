package ort.edu.ar.ej2;

import java.util.ArrayList;

public class Carrera {
	private ArrayList<Corredor> corredores;
	public Carrera() {
		this.corredores = new ArrayList<Corredor>();
	}
	
	public void agregarCorredor(Corredor corredor) {
		this.corredores.add(corredor);
	}
	
	public ArrayList<Corredor> calcularGanador() {
		double tiempoRecord = Double.MAX_VALUE;
		ArrayList<Corredor> ganadores = new ArrayList<Corredor>();
		for(Corredor corredor: corredores) {
			if(corredor.getTiempo() < tiempoRecord) {
				ganadores.clear();
				ganadores.add(corredor);
				tiempoRecord = corredor.getTiempo();
			} else if(corredor.getTiempo() == tiempoRecord) {
				ganadores.add(corredor);
			}
		}
		return ganadores;
	}
}
