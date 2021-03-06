package com.g2t.footline.dados;

import java.util.ArrayList;
import java.util.List;

import com.g2t.footline.exception.RegistroNaoEncontradoException;
import com.g2t.footline.negocio.entidades.Partida;
import com.g2t.footline.negocio.entidades.Rodada;

public class RepositorioRodadaLista implements RepositorioRodada {

	private List<Rodada> dados= new ArrayList<Rodada>();
	
	/**
	 * Busca uma determinada Rodada pelo codigo
	 * 
	 * return Rodada Rodada
	 * @throws RegistroNaoEncontradoException 
	 */
	@Override
	public Rodada buscar(int numero) throws RegistroNaoEncontradoException {
		Rodada retorno= null;
		for (Rodada rodada : dados) {
			if ( numero == rodada.getNumero() ) {
				retorno= rodada;
				break;
			}
		}
		
		if ( retorno == null ) {
			throw new RegistroNaoEncontradoException("Rodada numero="+ numero
					+" não localizada.");
		}
		return retorno;
	}

	/**
	 * Lista todos contidos na lista
	 * 
	 * return List<Rodada>
	 */
	@Override
	public List<Rodada> listar() {
		return listar(null);
	}

	/**
	 * Lista todas as partidas de uma rodada
	 * 
	 * return List<Rodada>
	 */
	@Override
	public List<Rodada> listar(Integer numero) {
		List<Rodada> dadosRetorno= null;
		if ( numero == null ) {
			dadosRetorno= dados;
		
		} else {
			dadosRetorno= new ArrayList<Rodada>();
			for (Rodada rodada : dados) {
				if ( numero.equals( rodada.getNumero() )) {
					dadosRetorno.add(rodada);
				}
			}
		} 
		
		return dadosRetorno;
	}
	
	/**
	 * Adiciona um Rodada na lista
	 * 
	 * @param Rodada
	 */
	@Override
	public void inserir(Rodada rodada) {
		dados.add(rodada);
	}

	@Override
	public void atualizar(Rodada rodada) {
		for (Rodada rodadaLista : dados) {
			if ( rodadaLista.getNumero() == rodada.getNumero() )
				rodadaLista= rodada;
		}
	}
	
	/**
	 * Busca um determinada Partida pelo codigo
	 * 
	 * return Partida partida
	 * @throws RegistroNaoEncontradoException 
	 */
	@Override
	public Partida buscarPartida(int numero) throws RegistroNaoEncontradoException {
		Partida retorno= null;
		for (Rodada rodada : dados) {
			for (Partida partida : rodada.getPartidas()) {
				if ( numero == partida.getId() ) {
					retorno= partida;
					break;
				}
			}
		}
		
		if ( retorno == null ) {
			throw new RegistroNaoEncontradoException("Partida numero="+ numero
					+" não localizada.");
		}
		return retorno;
	}	

}
