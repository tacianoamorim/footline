package com.g2t.footline.dados;

import com.g2t.footline.negocio.entidades.Arbitro;

public class RepositorioArbitro implements IRepositorioArbitro {

	private Arbitro[] arrayDados= new Arbitro[100];
	
	@Override
	public void carregarDados() {
	
	}

	/**
	 * Busca um determinado arbitro pelo codigo
	 * 
	 * return Arbitro arbitro
	 */
	@Override
	public Arbitro buscar(int id) {
		Arbitro retorno= new Arbitro();
		for (int i = 0; i < arrayDados.length; i++) {
			Arbitro arbitro = arrayDados[i];
			if ( id == arbitro.getId() ) {
				retorno= arbitro;
				break;
			}
		}
		return retorno;
	}

}
