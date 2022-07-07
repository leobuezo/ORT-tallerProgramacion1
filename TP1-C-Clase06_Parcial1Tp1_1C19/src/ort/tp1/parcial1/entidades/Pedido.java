/**
 * 
 */
package ort.tp1.parcial1.entidades;
import java.util.ArrayList;
/**
 * @author leobuezo
 * Clase que contiene un pedido generado.
 *
 */
public class Pedido implements Certificable, Mostrable {

	/*
	 * Completar atributos
	 */
	private TipoPedido tipo;
	private ArrayList<Producto> productosList;
	private ArrayList<Integer> cantidadList;
	
	public Pedido(TipoPedido tipo) {
		this.tipo = tipo;
		productosList = new ArrayList<>();
		cantidadList = new ArrayList<>();
	}
	
	/**
	 * Permite agregar un producto al pedido
	 * 
	 * @param producto El {@link Producto} a agregar.
	 * @param cantidad La cantidad del {@link Producto} a agregar.
	 */
	public void agregarProducto(Producto producto, Integer cantidad) {
		int idxPro = buscarProducto(producto);
		if(idxPro >= 0) {
			Integer cant = cantidadList.get(idxPro);
			cant += cantidad;
			this.cantidadList.set(idxPro, cant);
		} else {
			this.productosList.add(producto);
			this.cantidadList.add(cantidad);
		}
	}

	/**
	 * Saca un producto del pedido.
	 * 
	 * @param producto El {@link Producto} a sacar del pedido.
	 * @param cantidad Cantidad del {@link Producto} a sacar del pedido.
	 *
	 */
	public void sacarProducto(Producto producto, int cantidadASacar) {
		int idxPro = buscarProducto(producto);
		if(idxPro != -1) {
			int cant = cantidadList.get(idxPro);
			int cantAux = cant - cantidadASacar;
			if(cantAux > 0) {
				this.cantidadList.set(idxPro, cantAux);				
			} else {
				this.cantidadList.remove(idxPro);
				this.productosList.remove(idxPro);
			}
		} else {
			System.out.println("Sacar Producto: no se encontro el producto.");
		}
	}
	
	/**
	 * Devuelve el indice del producto buscado en la lista.
	 * 
	 * @param p {@link Producto}
	 * @return El indice >=0 si encuentra el producto y -1 si no lo encuentra.
	 */
	public int buscarProducto(Producto p) {
		int idx = -1;
		int i = 0;
		while(i < this.productosList.size() && idx == -1) {
			if(p.equals(this.productosList.get(i))) {
				idx = i;
			}
			i++;
		}
		return idx;
	}

	/** Indica la cantidad del producto dado.
	 * Es basicamente el getter de la lista en la posicion.
	 * @param producto El {@link Producto} cuya cantidad se desea averiguar.
	 * @return {@link Integer} conteniendo la cantidad del producto en el pedido.
	 * Devuelve -1 si no esta el producto.
	 */
	public int cantidadProducto(Producto producto) {
		// completar
		int cant = -1;
		int idxProducto = buscarProducto(producto);
		if(idxProducto >= 0) {
			cant = this.cantidadList.get(idxProducto);
		}
		return cant;
	}
	
	/**
	 * Devuelve una estructura conteniendo las lineas del pedido.
	 * 
	 * @return una estructura conteniendo {@link LineaPedido}s
	 */
	private ArrayList<LineaPedido> getTablaProductosPedidos() {
		// completar
		ArrayList<LineaPedido> lps = new ArrayList<LineaPedido>();
		for(int i = 0; i < this.productosList.size(); i++) {
			lps.add(new LineaPedido(this.productosList.get(i), this.cantidadList.get(i)));
		}
		return lps;
	}
	
	/**
	 * Calcula el importe del pedido.
	 * 
	 * @return {@link Float} conteniendo el importe del pedido.
	 */
	private float calcularImportePedido() {
		// completar
		float importe = 0;
		for(LineaPedido lp: getTablaProductosPedidos()) {
			importe += lp.getPrecioLineaPedido(this.tipo);
		}
		return importe;
	}

	@Override
	public boolean isCertificadoSinTACC() {
		// TODO Auto-generated method stub
		int idx = 0;
		boolean isCertificadoSinTACC = true;
		while(idx < this.productosList.size() || isCertificadoSinTACC == true) {
			isCertificadoSinTACC = this.productosList.get(idx) instanceof ProductoConTacc;
			idx++;
		}
		return isCertificadoSinTACC;
	}

	@Override
	public void mostrar() {
		// TODO Auto-generated method stub
		System.out.printf(Mostrable.FORMATO_ENCABEZADO_CONSOLA, "Cantidad", "Nombre", "Tipo de Producto", 
				"Precio Unitario", "Tipo de Producto");
		for(LineaPedido lp: this.getTablaProductosPedidos()) {
			lp.mostrar();
		}
		System.out.println("-------------------------------------------------------");
		boolean esCertif = this.isCertificadoSinTACC();
		System.out.println("El pedido " + (esCertif ? "" : "NO ") + "es certificado.");
		System.out.println("-------------------------------------------------------");
		System.out.printf("El precio total del pedido es: $ %.2f\n", this.calcularImportePedido());
	}

}
