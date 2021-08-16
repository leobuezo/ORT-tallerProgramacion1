package ort.edu.ar.ej3;

import java.util.ArrayList;

public class Posicion {
	private ArrayList<Corredor> corredores;
	private double tiempo;

	public Posicion() {
		this.setTiempo(Double.MAX_VALUE);
		this.setCorredores(new ArrayList<Corredor>());
	}

	public ArrayList<Corredor> getCorredores() {
		return corredores;
	}

	public void setCorredores(ArrayList<Corredor> corredores) {
		this.corredores = corredores;
	}

	public double getTiempo() {
		return tiempo;
	}

	public void setTiempo(double tiempo) {
		this.tiempo = tiempo;
	}
}
