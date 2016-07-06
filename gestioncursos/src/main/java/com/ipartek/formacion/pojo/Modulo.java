/**
 * 
 */
package com.ipartek.formacion.pojo;

import java.io.Serializable;

/**
 * @author Curso
 *
 */
public class Modulo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int CODIGO_MODULO=-1;
	private int codigoModulo;
	private String nombreModulo;
	private String refModulo;
	private Duracion durModulo;
	
	/**
	 * 
	 */
	public Modulo() {
		super();
		setCodigoModulo(CODIGO_MODULO);
		setNombreModulo("");
		
	}
	/**
	 * @return the codigoModulo
	 */
	public int getCodigoModulo() {
		return codigoModulo;
	}
	/**
	 * @param codigoModulo the codigoModulo to set
	 */
	public void setCodigoModulo(int codigoModulo) {
		this.codigoModulo = codigoModulo;
	}
	/**
	 * @return the nombreModulo
	 */
	public String getNombreModulo() {
		return nombreModulo;
	}
	/**
	 * @param nombreModulo the nombreModulo to set
	 */
	public void setNombreModulo(String nombreModulo) {
		this.nombreModulo = nombreModulo;
	}
	
	
	
	
	
	
	
}
