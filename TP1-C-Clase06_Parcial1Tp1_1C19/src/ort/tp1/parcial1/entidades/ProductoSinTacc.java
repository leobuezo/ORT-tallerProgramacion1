/**
 * 
 */
package ort.tp1.parcial1.entidades;

/**
 * @author leobuezo
 *
 */
public class ProductoSinTacc extends Producto {

	private static final String NOMBRE_MOSTRABLE = "Producto sin TACC";
	private String certificadora;
	
	/**
	 * constructor
	 */
	public ProductoSinTacc(FamiliaProducto familiaProducto, String nombre, float precio, String certificadora) {
		// TODO Auto-generated constructor stub
		super(familiaProducto, nombre, precio);
		this.setCertificadora(certificadora);
	}

	public static String getNombreMostrable() {
		return NOMBRE_MOSTRABLE;
	}

	public String getCertificadora() {
		return certificadora;
	}

	private void setCertificadora(String certificadora) {
		if(certificadora == null || certificadora.isEmpty()) {
			throw new IllegalArgumentException("certificadora no puede ser nulo o vacio.");
		}
		this.certificadora = certificadora;
	}

	@Override
	public void mostrar() {
		// TODO Auto-generated method stub
		System.out.printf(Mostrable.FORMATO_RENGLON_CONSOLA, getNombre(), getFamiliaProducto(), getPrecio(), getNombreMostrable());
	}

}
