/**
 * 
 */
package ort.tp1.parcial1.entidades;

/**
 * @author leobuezo
 * Un producto
 *
 */
public abstract class Producto implements Mostrable {

	/*
	 * agregar atributos
	 */
	public static final float DESCUENTO_POR_MAYOR = 0.9f;
	private String nombre;
	private FamiliaProducto familiaProducto;
	private float precio;
	
	/**
	 * Constructor del producto pedido, recibe sus atributos como parametro.
	 * 
	 *  @param familiaProducto	{@link FamiliaProducto}
	 *  @param nombre			{@link String} con el nombre
	 *  @param precio			{@link Float} con su precio
	 *  
	 */
	public Producto(FamiliaProducto familiaProducto, String nombre, float precio) {
		// completar
		this.familiaProducto = familiaProducto;
		this.setNombre(nombre);
		this.precio = precio;
	}
	
	public FamiliaProducto getFamiliaProducto() {
		return familiaProducto;
	}

	public float getPrecio(TipoPedido tipoPedido) {
		// completar
		return tipoPedido == TipoPedido.POR_MENOR ? 
				this.precio : this.precio * DESCUENTO_POR_MAYOR;
	}

	public float getPrecio() {
		return precio;
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		if(nombre == null || nombre.isEmpty()) {
			throw new IllegalArgumentException("nombre no puede ser nulo o vacio.");
		}
		this.nombre = nombre;
	}	
}
