package ort.edu.ar.ej3;

import java.util.ArrayList;

public class Carrera2 {
	private ArrayList<Corredor> corredores;
	private Posicion pos1, pos2, pos3;

	public Carrera2() {
		this.corredores = new ArrayList<Corredor>();
		this.pos1 = new Posicion();
		this.pos2 = new Posicion();
		this.pos3 = new Posicion();
	}
	
	public void agregarCorredor(Corredor corredor) {
		this.corredores.add(corredor);
	}
	
	public void calcularTernaGanadora() {
		mostrarCorredores();
		for(Corredor corredor: corredores) {
			// *** EVALUAMOS PRIMER PUESTO ***
			if(corredor.getTiempo() < this.pos1.getTiempo()) {
				actualizarPodio(this.pos2, this.pos3);
				actualizarPodio(this.pos1, this.pos2);
				this.pos1.setTiempo(corredor.getTiempo());
				this.pos1.getCorredores().add(corredor);
			} else if(corredor.getTiempo() == this.pos1.getTiempo()) {
				this.pos1.getCorredores().add(corredor);
			}

			// *** EVALUAMOS SEGUNDO PUESTO ***
			else if(corredor.getTiempo() < this.pos2.getTiempo()) {
				actualizarPodio(this.pos2, this.pos3);
				this.pos2.setTiempo(corredor.getTiempo());
				this.pos2.getCorredores().add(corredor);
			} else if(corredor.getTiempo() == this.pos2.getTiempo()) {
				this.pos2.getCorredores().add(corredor);
			}
			
			// *** EVALUAMOS TERCER PUESTO ***
			else if(corredor.getTiempo() < this.pos3.getTiempo()) {
				this.pos3.setTiempo(corredor.getTiempo());
				this.pos3.getCorredores().clear();
				this.pos3.getCorredores().add(corredor);
			} else if(corredor.getTiempo() == this.pos3.getTiempo()) {
				this.pos3.getCorredores().add(corredor);
			}
		}
		mostrarPodio(this.pos1.getCorredores(), this.pos2.getCorredores(), this.pos3.getCorredores());
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
	
	private void actualizarPodio(Posicion puestoOrigen, Posicion puestoDestino) {
		if(!puestoOrigen.getCorredores().isEmpty()) {
			puestoDestino.getCorredores().clear();
		}
		for(Corredor co: puestoOrigen.getCorredores()) {
			puestoDestino.getCorredores().add(co);
		}
		puestoOrigen.getCorredores().clear();
		puestoDestino.setTiempo(puestoOrigen.getTiempo());
	}
	
}
