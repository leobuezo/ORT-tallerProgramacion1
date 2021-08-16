package ort.edu.ar.ej3;

import java.util.ArrayList;

public class Carrera {
	private ArrayList<Corredor> corredores;

	public Carrera() {
		this.corredores = new ArrayList<Corredor>();
	}
	
	public void agregarCorredor(Corredor corredor) {
		this.corredores.add(corredor);
	}
	
	public void calcularTernaGanadora() {
		ArrayList<Corredor> listaPrimerPuesto  = new ArrayList<Corredor>();
		ArrayList<Corredor> listaSegundoPuesto = new ArrayList<Corredor>();
		ArrayList<Corredor> listaTercerPuesto = new ArrayList<Corredor>();
		double tiempoPrimero = Double.MAX_VALUE;
		double tiempoSegundo = Double.MAX_VALUE;
		double tiempoTercero = Double.MAX_VALUE;

		mostrarCorredores();
		for(Corredor corredor: corredores) {
			// *** EVALUAMOS PRIMER PUESTO ***
			if(corredor.getTiempo() < tiempoPrimero) {
				tiempoTercero = tiempoSegundo;
				tiempoSegundo = tiempoPrimero;
				tiempoPrimero = corredor.getTiempo();
				actualizarPodio(listaSegundoPuesto, listaTercerPuesto);
				actualizarPodio(listaPrimerPuesto, listaSegundoPuesto);
				listaPrimerPuesto.add(corredor);
			} else if(corredor.getTiempo() == tiempoPrimero) {
				listaPrimerPuesto.add(corredor);
			}

			// *** EVALUAMOS SEGUNDO PUESTO ***
			else if(corredor.getTiempo() < tiempoSegundo) {
				tiempoTercero = tiempoSegundo;
				tiempoSegundo = corredor.getTiempo();
				actualizarPodio(listaSegundoPuesto, listaTercerPuesto);
				listaSegundoPuesto.add(corredor);
			} else if(corredor.getTiempo() == tiempoSegundo) {
				listaSegundoPuesto.add(corredor);
			}
			
			// *** EVALUAMOS TERCER PUESTO ***
			else if(corredor.getTiempo() < tiempoTercero) {
				tiempoTercero = corredor.getTiempo();
				listaTercerPuesto.clear();
				listaTercerPuesto.add(corredor);
			} else if(corredor.getTiempo() == tiempoTercero) {
				listaTercerPuesto.add(corredor);
			}
		}
		mostrarPodio(listaPrimerPuesto, listaSegundoPuesto, listaTercerPuesto);
	}
	
	private void mostrarCorredores() {
		System.out.println();
		System.out.println("Mostramos lista de corredores");
		System.out.println("-----------------------------");
		System.out.println();
		for(Corredor co: corredores) {
			System.out.println(co.getNombre() + " - " + co.getTiempo());
		}
	}

	private void mostrarPodio(ArrayList<Corredor> primerPuesto, ArrayList<Corredor> segundoPuesto, ArrayList<Corredor> tercerPuesto) {
		System.out.println();
		System.out.println("Así quedó el podio:");
		System.out.println("-------------------");
		imprimirPuesto(primerPuesto, "PRIMER PUESTO");
		imprimirPuesto(segundoPuesto, "SEGUNDO PUESTO");
		imprimirPuesto(tercerPuesto, "TERCER PUESTO");
	}

	private void imprimirPuesto(ArrayList<Corredor> puesto, String titulo) {
		System.out.println();
		System.out.println(titulo);
		for(Corredor co: puesto) {
			System.out.println(" + " + co.getNombre());
		}
	}
	
	private void actualizarPodio(ArrayList<Corredor> puestoOrigen, ArrayList<Corredor> puestoDestino) {
		if(!puestoOrigen.isEmpty()) {
			puestoDestino.clear();
		}
		for(Corredor co: puestoOrigen) {
			puestoDestino.add(co);
		}
		puestoOrigen.clear();
	}
	
}
