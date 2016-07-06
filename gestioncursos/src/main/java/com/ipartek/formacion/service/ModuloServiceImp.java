/**
 * 
 */
package com.ipartek.formacion.service;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.pojo.Curso;
import com.ipartek.formacion.pojo.Modulo;
import com.ipartek.formacion.pojo.exception.ModuloException;

/**
 * @author Curso
 *
 */
public class ModuloServiceImp implements ModuloService {

	private static ModuloServiceImp INSTANCE=null;
	private List<Modulo>modulos;
	private static int aCounter;
	
	private ModuloServiceImp(){
		this.modulos=new ArrayList<Modulo>();
		init();
	}
	
	public static ModuloServiceImp getInstance(){
		if (INSTANCE==null) {
			INSTANCE=new ModuloServiceImp();
		}
		return INSTANCE;
	}
	
	private synchronized static void createInstance(){
		if (INSTANCE==null) {
			INSTANCE=new ModuloServiceImp();
		}
	}
	
	
	
	public void init(){
		
		Modulo m1=new Modulo();
		Modulo m2=new Modulo();
		Modulo m3=new Modulo();
		
		m1.setNombreModulo("modulo mnbv");
		m2.setNombreModulo("modulo fghj");
		m3.setNombreModulo("modulo rtyu");
		
		
		createModulo(m1);
		createModulo(m2);
		createModulo(m3);
		
		aCounter=0;
		
		
	}
	@Override
	public Modulo createModulo(Modulo modulo) {
		modulo.setCodigoModulo(aCounter);
		aCounter++;
		this.modulos.add(modulo);
		return modulo;
	}

	@Override
	public Modulo getById(int codigo) throws ModuloException {
		Modulo aux=null;
		int index=this.getIndex(codigo);
		if (index <0) {
			throw new ModuloException(ModuloException.CODIGO_ERROR_INDEX_MODULO,ModuloException.MSG_ERROR_INDEX_MODULO);
		}
		
		aux=this.modulos.get(index);
		return aux;
	}

	@Override
	public void deleteModulo(int codigo) {
		int index=this.getIndex(codigo);
		this.modulos.remove(index);
		
	}

	@Override
	public List<Modulo> getAll() {
		
		return this.modulos;
	}

	@Override
	public Modulo updateModulo(Modulo modulo) {
		int index=this.getIndex(modulo.getCodigoModulo());
		this.modulos.add(index, modulo);
		
		return modulo;
	}

	private int getIndex(int codigo) {
		int index = -1;
		int i = 0;
		int len = this.modulos.size();
		boolean found = false;
		while (i < len && found == false) {
			Modulo aux = this.modulos.get(i);

			if (aux.getCodigoModulo() == codigo) {
				found = true;
				index = i;
			}
			i++;
		}

		return index;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	
	
}
