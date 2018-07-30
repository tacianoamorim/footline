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
		for (Jogador jogador : listar()) {
			if ( jogador.getQuantidadeGols() > 0 ) {
				mapJogadorGol.put(jogador.getId(), jogador.getQuantidadeGols());
			}
		}
		
//		List<Rodada> rodadas= CadastroRodada.getInstance().listar();
//		// Passa pelas rodadas que estao finalizadas
//		for (Rodada rodada : rodadas) {  
//			if (rodada.isFinalizada()) {
//				// Passa pelas partidas
//				for (Partida partida : rodada.getPartidas()) {
//					// Cataloga os gols do mandante
//					for (Jogador jogador : partida.getGolsMandante()) {
//						if ( mapJogadorGol.containsKey(jogador.getId() )) {
//							int qtde= mapJogadorGol.get(jogador.getId());
//							mapJogadorGol.put(jogador.getId(), ++qtde );
//							
//						} else {
//							mapJogadorGol.put(jogador.getId(), 1);
//						}
//					}
//					// Cataloga os gols do visitante
//					for (Jogador jogador : partida.getGolsVisitante()) {
//						if ( mapJogadorGol.containsKey(jogador.getId() )) {
//							int qtde= mapJogadorGol.get(jogador.getId());
//							mapJogadorGol.put(jogador.getId(), ++qtde );
//							
//						} else {
//							mapJogadorGol.put(jogador.getId(), 1);
//						}						
//					}					
//				}
//			}
//		}
		
		// Monta a lista ordenada
		for (Integer key : mapJogadorGol.keySet()) {
            Jogador jogador= CadastroJogador.getInstance().buscar(key);
			jogadores.add( jogador );
		}		
		
		return jogadores;
	}	
	
	
	/**
	 * Atualiza os dados da rodada feitos pelos jogadores,
	 * 	tais como; quantidade de gols, cartões amarelos e vermelho
	 * 
	 * @param Rodada rodada
	 * @throws RegistroNaoEncontradoException 
	 */
	public void atualizarDadosRodada(Rodada rodada) throws RegistroNaoEncontradoException {
		
		/*
		 * Limpar cartoes amarelos e vermelhos de jogadores
		 * que não participaram da rodada
		 */
		for ( Jogador jogador : listar() ) {
			// Limpa os cartoes amarelos
			if (jogador.getCartaoAmarelo() == 2) {
				jogador.setCartaoAmarelo(0);
				alterar(jogador);
			}
			
			// Limpa os cartoes vermelhos
			if (jogador.getCartaoVermelho() == 1) {
				jogador.setCartaoVermelho(0);
				alterar(jogador);				
			}			
		}
		
		// Armazena temporariamente as informacoes da rodada por jogador
		Map<Integer, Integer> mapGols= new TreeMap<Integer, Integer>();
		Map<Integer, Integer> mapCartaoAmarelo= new TreeMap<Integer, Integer>();
		Map<Integer, Integer> mapCartaoVermelho= new TreeMap<Integer, Integer>();
		
		// Varre a lista de partidas coletnado informacoes
		for (Partida partida : rodada.getPartidas()) {
			/*
			 * Cataloga os Gols
			 */
			// Mandante
			for (Jogador jogador : partida.getGolsMandante()) {
				if ( mapGols.containsKey(jogador.getId() )) {
					int qtde= mapGols.get(jogador.getId());
					mapGols.put(jogador.getId(), ++qtde );
					
				} else {
					mapGols.put(jogador.getId(), 1);
				}
			}
			// Visitante
			for (Jogador jogador : partida.getGolsVisitante()) {
				if ( mapGols.containsKey(jogador.getId() )) {
					int qtde= mapGols.get(jogador.getId());
					mapGols.put(jogador.getId(), ++qtde );
					
				} else {
					mapGols.put(jogador.getId(), 1);
				}						
			}
			
			/*
			 * Cataloga os cartoes
			 */		
			// Amarelo
			for (Jogador jogador : partida.getListaCartaoAmarelo()) {
				if ( mapCartaoAmarelo.containsKey(jogador.getId() )) {
					int qtde= mapCartaoAmarelo.get(jogador.getId());
					mapCartaoAmarelo.put(jogador.getId(), ++qtde );
					
				} else {
					mapCartaoAmarelo.put(jogador.getId(), 1);
				}						
			}			
			// Vermelho
			for (Jogador jogador : partida.getListaCartaoVermelho()) {
				if ( mapCartaoVermelho.containsKey(jogador.getId() )) {
					int qtde= mapCartaoVermelho.get(jogador.getId());
					mapCartaoVermelho.put(jogador.getId(), ++qtde );
					
				} else {
					mapCartaoVermelho.put(jogador.getId(), 1);
				}						
			}	
			
			
		} // FIM for rodada.getPartidas() 
		
		// Atualiza os dados gols
		for (Integer key : mapGols.keySet()) {
            Jogador jogador= CadastroJogador.getInstance().buscar(key);
            int qtde= jogador.getQuantidadeGols() + mapGols.get(key);
			jogador.setQuantidadeGols( qtde );
			CadastroJogador.getInstance().alterar(jogador);
		}	
		// Atualiza os dados cartoes vermelhos
		for (Integer key : mapCartaoVermelho.keySet()) {
            Jogador jogador= CadastroJogador.getInstance().buscar(key);
            int qtde= jogador.getCartaoVermelho() + mapCartaoVermelho.get(key);
			jogador.setCartaoVermelho( qtde );
			CadastroJogador.getInstance().alterar(jogador);
		}
		// Atualiza os dados cartoes amarelos
		for (Integer key : mapCartaoAmarelo.keySet()) {
            Jogador jogador= CadastroJogador.getInstance().buscar(key);
            int qtde= jogador.getCartaoAmarelo() + mapCartaoAmarelo.get(key);
			jogador.setCartaoAmarelo( qtde );
			CadastroJogador.getInstance().alterar(jogador);
		}	
		
		
	}
	
}
