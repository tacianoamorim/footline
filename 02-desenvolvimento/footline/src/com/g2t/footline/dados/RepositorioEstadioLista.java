package com.g2t.footline.dados;

import java.util.ArrayList;
import java.util.List;

import com.g2t.footline.exception.RegistroNaoEncontradoException;
import com.g2t.footline.negocio.entidades.Estadio;

public class RepositorioEstadioLista implements RepositorioEstadio {

	private List<Estadio> dados= new ArrayList<Estadio>();
	
	/**
	 * Busca um determinado estadio pelo codigo
	 * 
	 * return Estadio estadio
	 * @throws RegistroNaoEncontradoException 
	 */
	@Override
	public Estadio buscar(String id) throws RegistroNaoEncontradoException {
		Estadio retorno= null;
		for (Estadio estadio : dados) {
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
	 * Lista todos contidos na lista
	 * 
	 * return List<Estadio>
	 */
	@Override
	public List<Estadio> listar() {
		return dados;
	}

	/**
	 * Adiciona um estadio na lista
	 * 
	 * @param Estadio
	 */
	@Override
	public void inserir(Estadio estadio) {
		dados.add( estadio );
	}

}
