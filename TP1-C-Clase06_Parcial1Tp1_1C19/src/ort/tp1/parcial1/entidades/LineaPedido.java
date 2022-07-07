/**
 * 
 */
package ort.tp1.parcial1.entidades;

/**
 * @author leobuezo
 * Linea de un pedido, incluye el producto y la cantidad del mismo
 *
 */
public class LineaPedido implements Mostrable {

	// completar atributos
	private int cantidad;
	private Producto producto;
	/**
	 * Constructor de la entidad
	 * 
	 * @param producto {@link Producto} contenido en la linea.
	 * @param cantidad {@link Integer} representando la cantidad de producto en esa linea.
	 */
	public LineaPedido(Producto producto, int cantidad) {
		this.producto = producto;
		this.cantidad = cantidad;
	}
	
	public Producto getProducto() {
		return producto;
	}
	
	/** Devuelve el precio de una linea de pedido.
	 * 
	 * @param tipo {@link TipoPedido} para calcular el precio.
	 * @return {@link Float} con el precio de la linea.
	 */
	public float getPrecioLineaPedido(TipoPedido tipo) {
		// completar
		return producto.getPrecio(tipo) * cantidad;
	}
	
	/**
	 * Agrega la cantidad indicada de producto a la {@link LineaPedido}
	 * 
	 * @param cantidad {@link Integer} con la cantidad a agregar
	 * (debe ser positivo, sino no agrega).
	 */
	public void adicionarCantidad(int cantidad) {
		// completar
		if(cantidad > 0) {
			this.cantidad += cantidad;
		} else {
			System.out.println("La cantidad a adicionar debe ser positiva.");
		}
	}

	@Override
	public void mostrar() {
		// TODO Auto-generated method stub
		System.out.printf(Mostrable.FORMATO_CANT_RENGLON_CONSOLA, cantidad);
		producto.mostrar();
	}
}
