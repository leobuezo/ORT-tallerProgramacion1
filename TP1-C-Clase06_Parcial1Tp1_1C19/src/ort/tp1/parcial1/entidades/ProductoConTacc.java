/**
 * 
 */
package ort.tp1.parcial1.entidades;

/**
 * @author leobuezo
 *
 */
public class ProductoConTacc extends Producto {

	private static final String NOMBRE_MOSTRABLE = "Producto con TACC";
	
	/**
	 * constructor
	 */
	public ProductoConTacc(FamiliaProducto familiaProducto, String nombre, float precio) {
		// TODO Auto-generated constructor stub
		super(familiaProducto, nombre, precio);
	}

	public static String getNombreMostrable() {
		return NOMBRE_MOSTRABLE;
	}

	@Override
	public void mostrar() {
		// TODO Auto-generated method stub
		System.out.printf(Mostrable.FORMATO_RENGLON_CONSOLA, getNombre(), getFamiliaProducto(), getPrecio(), getNombreMostrable());
	}

}
