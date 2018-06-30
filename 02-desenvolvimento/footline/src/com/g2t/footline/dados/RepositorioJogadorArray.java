package com.g2t.footline.dados;

import com.g2t.footline.exception.RegistroNaoEncontradoException;
import com.g2t.footline.negocio.entidades.Jogador;

public class RepositorioJogadorArray implements RepositorioJogador {

	private Jogador[] arrayDados= new Jogador[1000];
	private int idx= 0;
	
	/**
	 * Busca um determinado jogador pelo codigo
	 * 
	 * return Jogador jogador
	 * @throws RegistroNaoEncontradoException 
	 */
	@Override
	public Jogador buscar(int id) throws RegistroNaoEncontradoException {
		Jogador retorno= null;
		for (int i = 0; i < arrayDados.length; i++) {
			Jogador jogador = arrayDados[i];
			if ( id == jogador.getId() ) {
				retorno= jogador;
				break;
			}
		}
		
		if ( retorno == null ) {
			throw new RegistroNaoEncontradoException("Jogador id="+ id
					+" não localizado.");
		}
		return retorno;
	}

	/**
	 * Lista todos contidos no array
	 * 
	 * return Jogador[]
	 */
	@Override
	public Jogador[] listar() {
		return arrayDados;
	}

	@Override
	public void inserir(Jogador jogador) {
		for (int i = 0; i < arrayDados.length; i++) {
			if ( arrayDados[i] == null ) {
				jogador.setId(++idx);
				arrayDados[i] = jogador;
				break;
			}
		}	
	}

	/**
	 * Altera os dados de um determinado jogador
	 * @throws RegistroNaoEncontradoException 
	 */
	@Override
	public void alterar(Jogador jogador) throws RegistroNaoEncontradoException {
		boolean achei= false;
		for (int i = 0; i < arrayDados.length; i++) {
			if ( jogador.getId() == arrayDados[i].getId() ) {
				arrayDados[i]= jogador;
				achei= true;
				break;
			}
		}
		
		if ( !achei ) {
			throw new RegistroNaoEncontradoException("Jogador id="+ 
					jogador.getId() +" não localizado.");
		}
	}

}
