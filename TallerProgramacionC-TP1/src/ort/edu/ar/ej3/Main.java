package ort.edu.ar.ej3;

public class Main {

	public static void main(String[] args) {		
		Corredor c1 = new Corredor("John Doe", 32.2);
		Corredor c2 = new Corredor("Juan Delpo", 33.2);
		Corredor c3 = new Corredor("Joaquín Rojdik", 34.2);
		Corredor c4 = new Corredor("Ale Fantino", 32.2);
		Corredor c5 = new Corredor("Alejandro Lerner", 32.2);
		Corredor c6 = new Corredor("Ariel Mota", 33.2);
		Corredor c7 = new Corredor("Jose Bajko", 34.2);
		Corredor c8 = new Corredor("Jose Morabito", 31.2);
		Corredor c9 = new Corredor("Esteban Zalez", 33.2);
		Corredor c10 = new Corredor("Esteban Candia", 32.2);
		Corredor c11 = new Corredor("Esteban Fernandez", 34.2);
		Corredor c12 = new Corredor("Alberto Fernandez", 52.2);
		Corredor c13 = new Corredor("Alberto Gutierrez", 31.2);
		Corredor c14 = new Corredor("Alberto Olmedo", 42.2);
		Corredor c15 = new Corredor("Peter Alfonso", 45.2);
		Corredor c16 = new Corredor("El corredor Alonso", 33.2);
		Corredor c17 = new Corredor("El beto Alonso", 33.2);
		Corredor c18 = new Corredor("El beto Mársico", 38.2);
		Corredor c19 = new Corredor("El chapo Guzman", 36.2);
		Corredor c20 = new Corredor("Capusoto", 32.2);

		Carrera atletismo42KVaronil = new Carrera();
		atletismo42KVaronil.agregarCorredor(c1);
		atletismo42KVaronil.agregarCorredor(c2);
		atletismo42KVaronil.agregarCorredor(c3);
		atletismo42KVaronil.agregarCorredor(c4);
		atletismo42KVaronil.agregarCorredor(c5);
		atletismo42KVaronil.agregarCorredor(c6);
		atletismo42KVaronil.agregarCorredor(c7);
		atletismo42KVaronil.agregarCorredor(c8);
		atletismo42KVaronil.agregarCorredor(c9);
		atletismo42KVaronil.agregarCorredor(c10);
		atletismo42KVaronil.agregarCorredor(c11);
		atletismo42KVaronil.agregarCorredor(c12);
		atletismo42KVaronil.agregarCorredor(c13);
		atletismo42KVaronil.agregarCorredor(c14);
		atletismo42KVaronil.agregarCorredor(c15);
		atletismo42KVaronil.agregarCorredor(c16);
		atletismo42KVaronil.agregarCorredor(c17);
		atletismo42KVaronil.agregarCorredor(c18);
		atletismo42KVaronil.agregarCorredor(c19);
		atletismo42KVaronil.agregarCorredor(c20);

		atletismo42KVaronil.calcularTernaGanadora();
	}

}
