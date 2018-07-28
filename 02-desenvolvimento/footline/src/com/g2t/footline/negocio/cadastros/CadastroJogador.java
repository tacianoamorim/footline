package com.g2t.footline.negocio.cadastros;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.g2t.footline.dados.RepositorioJogador;
import com.g2t.footline.dados.RepositorioJogadorLista;
import com.g2t.footline.exception.RegistroNaoEncontradoException;
import com.g2t.footline.negocio.entidades.Jogador;
import com.g2t.footline.negocio.entidades.Partida;
import com.g2t.footline.negocio.entidades.Rodada;
import com.g2t.footline.negocio.entidades.Selecao;

public class CadastroJogador {
	private RepositorioJogador repositorio;
	private static CadastroJogador instance;
	
	private CadastroJogador() {
		repositorio= new RepositorioJogadorLista();
	}
	
	public static CadastroJogador getInstance() {
		if ( instance == null )
			instance= new CadastroJogador();
		return instance;
	}
	
	public Jogador buscar(int id) throws RegistroNaoEncontradoException {
		return repositorio.buscar(id);
	}
	
	public List<Jogador> listar() {
		return repositorio.listar(null);
	}
	
	public void inserir(Jogador jogador) {
		repositorio.inserir(jogador);
	}
	
	public void alterar(Jogador jogador) throws RegistroNaoEncontradoException {
		repositorio.alterar(jogador);
	}
	
	public List<Jogador> listar(Selecao selecao) {
		return repositorio.listar(selecao);
	}

	/**
	 * Retorna a lista de jogadores com gols
	 * 
	 * @return List<Jogador>
	 * @throws RegistroNaoEncontradoException 
	 */
	public List<Jogador> listarArtilheiros() throws RegistroNaoEncontradoException {
		List<Jogador> jogadores= new ArrayList<Jogador>();
		
		Map<Integer, Integer> mapJogadorGol = new TreeMap<Integer, Integer>();
		List<Rodada> rodadas= CadastroRodada.getInstance().listar();
		// Passa pelas rodadas que estao finalizadas
		for (Rodada rodada : rodadas) {  
			if (rodada.isFinalizada()) {
				// Passa pelas partidas
				for (Partida partida : rodada.getPartidas()) {
					// Cataloga os gols do mandante
					for (Jogador jogador : partida.getGolsMandante()) {
						if ( mapJogadorGol.containsKey(jogador.getId() )) {
							int qtde= mapJogadorGol.get(jogador.getId());
							mapJogadorGol.put(jogador.getId(), ++qtde );
							
						} else {
							mapJogadorGol.put(jogador.getId(), 1);
						}
					}
					// Cataloga os gols do visitante
					for (Jogador jogador : partida.getGolsVisitante()) {
						if ( mapJogadorGol.containsKey(jogador.getId() )) {
							int qtde= mapJogadorGol.get(jogador.getId());
							mapJogadorGol.put(jogador.getId(), ++qtde );
							
						} else {
							mapJogadorGol.put(jogador.getId(), 1);
						}						
					}					
				}
			}
		}
		
		// Monta a lista ordenada
		for (Integer key : mapJogadorGol.keySet()) {
            Jogador jogador= CadastroJogador.getInstance().buscar(key);
			jogador.setQuantidadeGols( mapJogadorGol.get(key) );
			// Adiciona na lista de retorno
			jogadores.add( jogador );
		}		
		
		return jogadores;
	}	
	
}
