package com.g2t.footline.dados;

import com.g2t.footline.negocio.entidades.Selecao;

public class RepositorioSelecaoArray implements RepositorioSelecao {

	private Selecao[] arrayDados= new Selecao[32];
	private int idx= 0;

	/**
	 * Busca um determinado selecao pelo codigo
	 * 
	 * return Selecao selecao
	 */
	@Override
	public Selecao buscar(int id) {
		Selecao retorno= new Selecao();
		for (int i = 0; i < arrayDados.length; i++) {
			Selecao selecao = arrayDados[i];
			if ( id == selecao.getId() ) {
				retorno= selecao;
				break;
			}
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
				selecao.setId(++idx);
				arrayDados[i] = selecao;
				break;
			}
		}
	}

	@Override
	public Selecao[] listar() {
		return arrayDados;
	}

}
