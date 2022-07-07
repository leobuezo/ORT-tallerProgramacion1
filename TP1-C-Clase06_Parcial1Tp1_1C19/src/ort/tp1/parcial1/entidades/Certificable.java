/**
 * 
 */
package ort.tp1.parcial1.entidades;

/**
 * @author leobuezo
 * Interfaz que define si una clase es certificable
 * de algun tipo
 *
 */
public interface Certificable {

	/**
	 * Indica si la clase es certificable.
	 * 
	 * @return <code>true</code> si es certificable, 
	 * <code>false</code> si no lo es.
	 */
	public boolean isCertificadoSinTACC();
}
