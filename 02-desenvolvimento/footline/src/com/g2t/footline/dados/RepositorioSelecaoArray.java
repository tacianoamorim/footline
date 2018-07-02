package com.g2t.footline.dados;

import com.g2t.footline.exception.RegistroNaoEncontradoException;
import com.g2t.footline.negocio.entidades.Selecao;

public class RepositorioSelecaoArray implements RepositorioSelecao {

	private Selecao[] arrayDados= new Selecao[32];

	/**
	 * Busca um determinado selecao pelo codigo
	 * 
	 * return Selecao selecao
	 * @throws RegistroNaoEncontradoException 
	 */
	@Override
	public Selecao buscar(String id) throws RegistroNaoEncontradoException {
		Selecao retorno= null;
		for (int i = 0; i < arrayDados.length; i++) {
			Selecao selecao = arrayDados[i];
			if ( selecao.getId().equalsIgnoreCase( id ) ) {
				retorno= selecao;
				break;
			}
		}
		
		if ( retorno == null ) {
			throw new RegistroNaoEncontradoException("Selecao id="+ id
					+" não localizada.");
		}		
		return retorno;
	}
	
	/**
	 * Insere uma selacao no array
	 */
	@Override
	public void inserir(Selecao selecao) {
		for (int i = 0; i < arrayDados.length; i++) {
			if ( arrayDados[i] == null ) {
				arrayDados[i] = selecao;
				break;
			}
		}
	}

	/**
	 * Lista todos contidos no array
	 * 
	 * return Selecao[]
	 */
	@Override
	public Selecao[] listar() {
		return arrayDados;
	}
	
	/**
	 * Altera os dados de uma determinada selecao
	 * @throws RegistroNaoEncontradoException 
	 */
	@Override
	public void alterar(Selecao selecao) throws RegistroNaoEncontradoException {
		boolean achei= false;
		for (int i = 0; i < arrayDados.length; i++) {
			if ( selecao.getId().equalsIgnoreCase( arrayDados[i].getId() ) ) {
				arrayDados[i]= selecao;
				achei= true;
				break;
			}
		}
		
		if ( !achei ) {
			throw new RegistroNaoEncontradoException("Selecao id="+ 
					selecao.getId() +" não localizada.");
		}
	}	

}
