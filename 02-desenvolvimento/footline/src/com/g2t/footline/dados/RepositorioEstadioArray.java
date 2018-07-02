package com.g2t.footline.dados;

import com.g2t.footline.exception.RegistroNaoEncontradoException;
import com.g2t.footline.negocio.entidades.Tecnico;

public class RepositorioEstadioArray implements RepositorioTecnico {

	private Tecnico[] arrayDados= new Tecnico[40];
	private int idx= 0;
	
	/**
	 * Busca um determinado tecnico pelo codigo
	 * 
	 * return Tecnico tecnico
	 * @throws RegistroNaoEncontradoException 
	 */
	@Override
	public Tecnico buscar(int id) throws RegistroNaoEncontradoException {
		Tecnico retorno= null;
		for (int i = 0; i < arrayDados.length; i++) {
			Tecnico tecnico = arrayDados[i];
			if ( id == tecnico.getId() ) {
				retorno= tecnico;
				break;
			}
		}
		
		if ( retorno == null ) {
			throw new RegistroNaoEncontradoException("Tecnico id="+ id
					+" não localizado.");
		}
		return retorno;
	}

	/**
	 * Lista todos contidos no array
	 * 
	 * return Tecnico[]
	 */
	@Override
	public Tecnico[] listar() {
		return arrayDados;
	}

	/**
	 * Adiciona um tecnico no array
	 * 
	 * @param Tecnico
	 */
	@Override
	public void inserir(Tecnico tecnico) {
		for (int i = 0; i < arrayDados.length; i++) {
			if ( arrayDados[i] == null ) {
				tecnico.setId(++idx);
				arrayDados[i] = tecnico;
				break;
			}
		}	
	}

}
