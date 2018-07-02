package com.g2t.footline.dados;

import com.g2t.footline.exception.RegistroNaoEncontradoException;
import com.g2t.footline.negocio.entidades.Arbitro;

public class RepositorioArbitroArray implements RepositorioArbitro {

	private Arbitro[] arrayDados= new Arbitro[36];
	private int idx= 0;
	
	/**
	 * Busca um determinado arbitro pelo codigo
	 * 
	 * return Arbitro arbitro
	 * @throws RegistroNaoEncontradoException 
	 */
	@Override
	public Arbitro buscar(int id) throws RegistroNaoEncontradoException {
		Arbitro retorno= null;
		for (int i = 0; i < arrayDados.length; i++) {
			Arbitro arbitro = arrayDados[i];
			if ( id == arbitro.getId() ) {
				retorno= arbitro;
				break;
			}
		}
		
		if ( retorno == null ) {
			throw new RegistroNaoEncontradoException("Arbitro id="+ id
					+" não localizado.");
		}
		return retorno;
	}
	
	
	/**
	 * Lista todos contidos no array
	 * 
	 * return Arbitro[]
	 */
	@Override
	public Arbitro[] listar() {
		return arrayDados;
	}


	@Override
	public void inserir(Arbitro arbitro) {
		for (int i = 0; i < arrayDados.length; i++) {
			if ( arrayDados[i] == null ) {
				arbitro.setId(++idx);
				arrayDados[i] = arbitro;
				break;
			}
		}	
	}	

}
