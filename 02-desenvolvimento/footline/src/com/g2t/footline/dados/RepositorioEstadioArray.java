package com.g2t.footline.dados;

import com.g2t.footline.exception.RegistroNaoEncontradoException;
import com.g2t.footline.negocio.entidades.Estadio;

public class RepositorioEstadioArray implements RepositorioEstadio {

	private Estadio[] arrayDados= new Estadio[40];
	
	/**
	 * Busca um determinado estadio pelo codigo
	 * 
	 * return Estadio estadio
	 * @throws RegistroNaoEncontradoException 
	 */
	@Override
	public Estadio buscar(String id) throws RegistroNaoEncontradoException {
		Estadio retorno= null;
		for (int i = 0; i < arrayDados.length; i++) {
			Estadio estadio = arrayDados[i];
			if ( estadio.getId().equalsIgnoreCase( id ) ) {
				retorno= estadio;
				break;
			}
		}
		
		if ( retorno == null ) {
			throw new RegistroNaoEncontradoException("Estadio id="+ id
					+" não localizado.");
		}
		return retorno;
	}

	/**
	 * Lista todos contidos no array
	 * 
	 * return Estadio[]
	 */
	@Override
	public Estadio[] listar() {
		return arrayDados;
	}

	/**
	 * Adiciona um estadio no array
	 * 
	 * @param Estadio
	 */
	@Override
	public void inserir(Estadio estadio) {
		for (int i = 0; i < arrayDados.length; i++) {
			if ( arrayDados[i] == null ) {
				arrayDados[i] = estadio;
				break;
			}
		}	
	}

}
