package com.g2t.footline.dados;

import java.util.ArrayList;
import java.util.List;

import com.g2t.footline.exception.RegistroNaoEncontradoException;
import com.g2t.footline.negocio.entidades.Selecao;

public class RepositorioSelecaoLista implements RepositorioSelecao {

	private List<Selecao> dados= new ArrayList<Selecao>();

	/**
	 * Busca um determinado selecao pelo codigo
	 * 
	 * return Selecao selecao
	 * @throws RegistroNaoEncontradoException 
	 */
	@Override
	public Selecao buscar(String id) throws RegistroNaoEncontradoException {
		Selecao retorno= null;
		for (Selecao selecao : dados) {
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
	 * Busca um determinado selecao pelo nome
	 * 
	 * return Selecao selecao
	 * @throws RegistroNaoEncontradoException 
	 */
	@Override
	public Selecao buscarPorNome(String nome) throws RegistroNaoEncontradoException {
		Selecao retorno= null;
		for (Selecao selecao : dados) {
			if ( selecao.getNome().equalsIgnoreCase( nome ) ) {
				retorno= selecao;
				break;
			}
		}
		
		if ( retorno == null ) {
			throw new RegistroNaoEncontradoException("Selecao nome="+ nome
					+" não localizada.");
		}		
		return retorno;
	}
	
	/**
	 * Insere uma selacao na lista
	 */
	@Override
	public void inserir(Selecao selecao) {
		dados.add(selecao);
	}

	/**
	 * Lista todos
	 * 
	 * return List<Selecao>
	 */
	@Override
	public List<Selecao> listar() {
		return dados;
	}
	
	/**
	 * Altera os dados de uma determinada selecao
	 * @throws RegistroNaoEncontradoException 
	 */
	@Override
	public void alterar(Selecao selecao) throws RegistroNaoEncontradoException {
		boolean achei= false;
		for (Selecao selecao2 : dados) {
			if ( selecao.getId().equalsIgnoreCase( selecao2.getId() ) ) {
				selecao2= selecao;
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
