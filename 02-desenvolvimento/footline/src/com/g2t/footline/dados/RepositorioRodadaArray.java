package com.g2t.footline.dados;

import com.g2t.footline.exception.RegistroNaoEncontradoException;
import com.g2t.footline.negocio.entidades.Rodada;

public class RepositorioRodadaArray implements RepositorioRodada {

	private Rodada[] arrayDados= new Rodada[40];
	
	/**
	 * Busca um determinado Rodada pelo codigo
	 * 
	 * return Rodada Rodada
	 * @throws RegistroNaoEncontradoException 
	 */
	@Override
	public Rodada buscar(int numero) throws RegistroNaoEncontradoException {
		Rodada retorno= null;
		for (int i = 0; i < arrayDados.length; i++) {
			Rodada Rodada = arrayDados[i];
			if ( numero == Rodada.getNumero() ) {
				retorno= Rodada;
				break;
			}
		}
		
		if ( retorno == null ) {
			throw new RegistroNaoEncontradoException("Rodada numero="+ numero
					+" não localizado.");
		}
		return retorno;
	}

	/**
	 * Lista todos contidos no array
	 * 
	 * return Rodada[]
	 */
	@Override
	public Rodada[] listar() {
		return arrayDados;
	}

	/**
	 * Adiciona um Rodada no array
	 * 
	 * @param Rodada
	 */
	@Override
	public void inserir(Rodada rodada) {
		for (int i = 0; i < arrayDados.length; i++) {
			if ( arrayDados[i] == null ) {
				arrayDados[i] = rodada;
				break;
			}
		}	
	}

}
