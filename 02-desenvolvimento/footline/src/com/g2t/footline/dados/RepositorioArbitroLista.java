package com.g2t.footline.dados;

import java.util.ArrayList;
import java.util.List;

import com.g2t.footline.exception.RegistroNaoEncontradoException;
import com.g2t.footline.negocio.entidades.Arbitro;

public class RepositorioArbitroLista implements RepositorioArbitro {

	private  List<Arbitro> dados= new ArrayList<Arbitro>();
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
		for (Arbitro arbitro : dados) {
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
	 * Lista todos contidos na lista
	 * 
	 * return List<Arbitro>
	 */
	@Override
	public List<Arbitro> listar() {
		return dados;
	}


	@Override
	public void inserir(Arbitro arbitro) {
		arbitro.setId( ++idx );
		dados.add( arbitro );
	}	

}
