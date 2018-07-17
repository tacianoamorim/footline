package com.g2t.footline.dados;

import java.util.ArrayList;
import java.util.List;

import com.g2t.footline.exception.RegistroNaoEncontradoException;
import com.g2t.footline.negocio.entidades.Tecnico;

public class RepositorioTecnicoLista implements RepositorioTecnico {

	private List<Tecnico> dados= new ArrayList<Tecnico>();
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
		for (Tecnico tecnico : dados) {
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
	 * Lista todos contidos na lista
	 * 
	 * return List<Tecnico>
	 */
	@Override
	public List<Tecnico> listar() {
		return dados;
	}

	/**
	 * Adiciona um tecnico na lista
	 * 
	 * @param Tecnico
	 */
	@Override
	public void inserir(Tecnico tecnico) {
		tecnico.setId(++idx);
		dados.add( tecnico );
	}

}
