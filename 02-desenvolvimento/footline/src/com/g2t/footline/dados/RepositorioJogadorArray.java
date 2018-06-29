package com.g2t.footline.dados;

import com.g2t.footline.negocio.entidades.Jogador;

public class RepositorioJogadorArray implements RepositorioJogador {

	private Jogador[] arrayDados= new Jogador[1000];
	private int idx= 0;
	
	/**
	 * Busca um determinado jogador pelo codigo
	 * 
	 * return Jogador jogador
	 */
	@Override
	public Jogador buscar(int id) {
		Jogador retorno= new Jogador();
		for (int i = 0; i < arrayDados.length; i++) {
			Jogador jogador = arrayDados[i];
			if ( id == jogador.getId() ) {
				retorno= jogador;
				break;
			}
		}
		return retorno;
	}

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

}
