package com.g2t.footline.dados;

import java.util.ArrayList;
import java.util.List;

import com.g2t.footline.exception.RegistroNaoEncontradoException;
import com.g2t.footline.negocio.entidades.Jogador;
import com.g2t.footline.negocio.entidades.Selecao;

public class RepositorioJogadorLista implements RepositorioJogador {

	private List<Jogador> dados= new ArrayList<Jogador>();
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
		for (Jogador jogador : dados) {
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
	 * Lista todos contidos na lista
	 * 
	 * return List<Jogador>
	 */
	@Override
	public List<Jogador> listar(Selecao selecao) {
		List<Jogador> lista= new ArrayList<Jogador>();
		
		if ( selecao == null ) {
			lista= dados;
		
		} else {
			for (Jogador jogador : dados) {
				if ( selecao.getId().equalsIgnoreCase(
						jogador.getSelecao().getId() ) ) {
					lista.add(jogador);
				}
			}
		}
		
		return lista;
	}

	@Override
	public void inserir(Jogador jogador) {
		jogador.setId( ++idx );
		dados.add(jogador);
	}

	/**
	 * Altera os dados de um determinado jogador
	 * @throws RegistroNaoEncontradoException 
	 */
	@Override
	public void alterar(Jogador jogador) throws RegistroNaoEncontradoException {
		boolean achei= false;
		for (Jogador jogadorLista : dados) {
			if ( jogador.getId() == jogadorLista.getId() ) {
				jogadorLista= jogador;
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
