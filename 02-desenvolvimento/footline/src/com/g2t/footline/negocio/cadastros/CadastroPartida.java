package com.g2t.footline.negocio.cadastros;

import java.util.ArrayList;
import java.util.List;

import com.g2t.footline.gui.FrmPrincipal;
import com.g2t.footline.negocio.entidades.Escalacao;
import com.g2t.footline.negocio.entidades.Jogador;
import com.g2t.footline.negocio.entidades.Partida;
import com.g2t.footline.negocio.entidades.Selecao;
import com.g2t.footline.negocio.entidades.Tatica;
import com.g2t.footline.util.Biblioteca;
import com.g2t.footline.util.Constantes;

public class CadastroPartida {
	private static CadastroPartida instance;
	
	private CadastroPartida() {
	}
	
	public static CadastroPartida getInstance() {
		if ( instance == null )
			instance= new CadastroPartida();
		return instance;
	}
	
	/**
	 * Realiza o processamento da partida
	 * 
	 * @param Partida partida
	 */
	public void processarPartida(Partida partida, int numeroRodada) {
		
		// carrega os titulares
		carregaTitulares(partida);
		
		// Carregar os jogadores por posicao
		List<Jogador> listMandGoleiro= extrairJogadorPosicao(
				partida.getMandante(), Jogador.GOLEIRO);
		List<Jogador> listMandDefesa= extrairJogadorPosicao(
				partida.getMandante(), Jogador.DEFESA);
		List<Jogador> listMandMeio= extrairJogadorPosicao(
				partida.getMandante(), Jogador.MEIO_CAMPO);
		List<Jogador> listMandAtaque= extrairJogadorPosicao(
				partida.getMandante(), Jogador.ATAQUE);

		List<Jogador> listVisGoleiro= extrairJogadorPosicao(
				partida.getVisitante(), Jogador.GOLEIRO);
		List<Jogador> listVisDefesa= extrairJogadorPosicao(
				partida.getVisitante(), Jogador.DEFESA);
		List<Jogador> listVisMeio= extrairJogadorPosicao(
				partida.getVisitante(), Jogador.MEIO_CAMPO);
		List<Jogador> listVisAtaque= extrairJogadorPosicao(
				partida.getVisitante(), Jogador.ATAQUE);
		
		/* 
		 * Define as posicoes do campo que foi divido
		 * 	em tres partes:
		 * - 0: ataque mandante / defesa visitante
		 * - 1: meio campo mandante / meio campo visitante
		 * - 2: defesa mandante / ataque visitante
		 */
		int quadranteAtual= 1;
		
		// Simula to tempo de partida
		for (int i = 1; i <= 90; i++) {
			int resultado= 0;
			
			// Simula a posicao da bola no campo
			switch (quadranteAtual) {
			case 0: // ataque mandante / defesa visitante
				resultado= processaAvancoQuadrante( listMandAtaque, listVisDefesa);
				if ( resultado > 0 ) { // Fez gol
					// Sorteia um jogador para fazer o gol
					if ( listMandAtaque.size() == 1 )
						partida.getGolsMandante().add( listMandAtaque.get(0) );
					else {
						int qtdeJogadores= listMandAtaque.size() -1;
						int idxGol= Biblioteca.geraValorAleatorio(0, qtdeJogadores);
						if (idxGol <  0) {
							idxGol= 0;
						}
						partida.getGolsMandante().add( listMandAtaque.get(idxGol) );
					}
					
				} else if ( resultado < 0 ) { // vai para a defesa
					quadranteAtual= 1;
				} 
				
				break;
				
			case 1: // meio campo
				resultado= processaAvancoQuadrante( listMandMeio, listVisMeio);
				if ( resultado > 0 ) { // vai para o ataque
					quadranteAtual= 2;
				} else if ( resultado < 0 ) { // vai para a defesa
					quadranteAtual= 0;
				} 
				break;
				
			case 2: // ataque mandante / defesa visitante
				resultado= processaAvancoQuadrante( listMandDefesa, listVisAtaque);
				if ( resultado > 0 ) { // vai para a meio
					quadranteAtual= 1;
					
				} else if ( resultado < 0 ) { // Fez gol
					// Sorteia um jogador para fazer o gol
					if ( listVisAtaque.size() == 1 )
						partida.getGolsVisitante().add( listVisAtaque.get(0) );
					else {					
						int qtdeJogadores= listVisAtaque.size() - 1;
						System.out.println(qtdeJogadores);
						int idxGol= Biblioteca.geraValorAleatorio(0, qtdeJogadores);
						if (idxGol <  0) {
							idxGol= 0;
						}
						partida.getGolsVisitante().add( listVisAtaque.get(idxGol) );
					}
				} 				
				break;				

			default:
				break;
			}
		}
		
		/*
		 *  se o time gerenciado ainda nao estiver desclassificado testa
		 *  	se foi
		 */
		if ( !FrmPrincipal.selecaoGerenciadaDesclassificada ) {
			if ( numeroRodada >= Constantes.RODADA_OITAVA_FINAL ) {
				if ( partida.getMandante().getSelecao().getId().equalsIgnoreCase(
						FrmPrincipal.selecaoGerenciada.getId()) ) {
					if ( partida.getGolsMandante().size() < 
						 partida.getGolsVisitante().size() ) {
						FrmPrincipal.selecaoGerenciadaDesclassificada= true;
					}
				}
				
				if ( partida.getVisitante().getSelecao().getId().equalsIgnoreCase(
						FrmPrincipal.selecaoGerenciada.getId())) {
					if ( partida.getGolsVisitante().size() < 
							 partida.getGolsMandante().size() ) {
							FrmPrincipal.selecaoGerenciadaDesclassificada= true;
					}	
				}
			}
		}
	}

	/**
	 * Carrega os titulares da partica de acordo com a tatica da selecao
	 * @param Partida partida
	 */
	private void carregaTitulares(Partida partida) {
		
		Selecao mandante= partida.getMandante().getSelecao();
		if (mandante.getId().equalsIgnoreCase(FrmPrincipal.selecaoGerenciada.getId()) ) {
			mandante= FrmPrincipal.selecaoGerenciada;
		}
		List<Jogador> titularesMandante= selecionarTitulares(mandante);
		partida.getMandante().setTitulares(titularesMandante);
		
		
		Selecao visitante= partida.getVisitante().getSelecao();
		if (visitante.getId().equalsIgnoreCase(FrmPrincipal.selecaoGerenciada.getId()) ) {
			visitante= FrmPrincipal.selecaoGerenciada;
		}
		List<Jogador> titularesVisitante= selecionarTitulares(visitante);
		partida.getMandante().setTitulares(titularesVisitante);	
	}

	/**
	 * Recupera os titulares de uma selecao
	 * @param selecao
	 * @return List<Jogador>
	 */
	private List<Jogador> selecionarTitulares(Selecao selecao) {
		List<Jogador> titulares= new ArrayList<Jogador>();
		int qtdeGoleiro= 1;
		int qtdeDefesa= 0;
		int qtdeMeia= 0;
		int qtdeAtaque= 0;
		
		if (selecao.getTatica() == Tatica._3_5_2) {
			qtdeDefesa= 3;
			qtdeMeia= 4;
			qtdeAtaque= 2;
		} else if (selecao.getTatica() == Tatica._4_3_3) {
			qtdeDefesa= 4;
			qtdeMeia= 3;
			qtdeAtaque= 3;
		} else if (selecao.getTatica() == Tatica._4_4_2) {
			qtdeDefesa= 4;
			qtdeMeia= 4;
			qtdeAtaque= 2;
		} else { //Tatica._4_5_1
			qtdeDefesa= 4;
			qtdeMeia= 5;
			qtdeAtaque= 1;
		}
		
		for (Jogador jogador : selecao.getJogadores() ) {
			if ( jogador.getPosicao().equals(Jogador.GOLEIRO) ) {
				if ( qtdeGoleiro > 0 ) {
					if ( jogador.getCartaoAmarelo() < 2 && jogador.getCartaoVermelho() < 1) {
						titulares.add(jogador);
						qtdeGoleiro--;
					}
				}
			}
			if ( jogador.getPosicao().equals(Jogador.DEFESA) ) {
				if ( qtdeDefesa > 0 ) {
					if ( jogador.getCartaoAmarelo() < 2 && jogador.getCartaoVermelho() < 1) {
						titulares.add(jogador);
						qtdeDefesa--;
					}
				}
			}	
			if ( jogador.getPosicao().equals(Jogador.MEIO_CAMPO) ) {
				if ( qtdeMeia > 0 ) {
					if ( jogador.getCartaoAmarelo() < 2 && jogador.getCartaoVermelho() < 1) {
						titulares.add(jogador);
						qtdeMeia--;
					}
				}
			}
			if ( jogador.getPosicao().equals(Jogador.ATAQUE) ) {
				if ( qtdeAtaque > 0 ) {
					if ( jogador.getCartaoAmarelo() < 2 && jogador.getCartaoVermelho() < 1) {
						titulares.add(jogador);
						qtdeAtaque--;
					}
				}
			}			
		}
		return titulares;
	}

	/**
	 * Extrai os jogadores de acordo com a posicao solicitada
	 * 
	 * @param mandante
	 * @param goleiro
	 * @return List<Jogador>
	 */
	private List<Jogador> extrairJogadorPosicao(Escalacao mandante, String posicao) {
		List<Jogador> retorno= new ArrayList<Jogador>();
		
		for (Jogador jogador : mandante.getSelecao().getJogadores()) {
			if ( posicao.equals( jogador.getPosicao() ) ) {
				retorno.add( jogador );
			} else if ( posicao.equals( jogador.getPosicao() ) ) {
				retorno.add( jogador );
			} else if ( posicao.equals( jogador.getPosicao() ) ) {
				retorno.add( jogador );
			} else if ( posicao.equals( jogador.getPosicao() ) ) {
				retorno.add( jogador );
			}
		}
		
		return retorno;
	}
	
	/**
	 * Retorna uma valor representado o sucesso ou nao da investida entre os quadrantes
	 * 
	 * 
	 * @param List<Jogador> listMandMeio
	 * @param List<Jogador> listVisMeio
	 * @return  1: houve sucesso na investida dos jogadores de referencia
	 * 			0: a investida foi anulada
	 * 		   -1: houve os jogadores conseguira se sobrepor a investida
	 */
	private int processaAvancoQuadrante(
			List<Jogador> jogadoresReferencia, List<Jogador> jogadores) {
		
		return Biblioteca.geraValorAleatorio(-1, 1);
	}

}
