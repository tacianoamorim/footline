package com.g2t.footline.negocio.cadastros;

import com.g2t.footline.exception.RegistroNaoEncontradoException;
import com.g2t.footline.gui.FrmPrincipal;
import com.g2t.footline.negocio.entidades.Jogador;
import com.g2t.footline.negocio.entidades.Partida;
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
		
		try {
			Jogador jogador1;
			jogador1 = CadastroJogador.getInstance().buscar(1);
			Jogador jogador2= CadastroJogador.getInstance().buscar(2);
			Jogador jogador3= CadastroJogador.getInstance().buscar(200);
			Jogador jogador4= CadastroJogador.getInstance().buscar(100);
			int idx= 0;
			
			if ( idx==0 ) {
				partida.getGolsMandante().add(jogador1);
				partida.getGolsMandante().add(jogador1);
				partida.getGolsMandante().add(jogador3);
				partida.getGolsVisitante().add(jogador4);
				partida.getListaCartaoAmarelo().add(jogador1);
				partida.getListaCartaoVermelho().add(jogador1);
				partida.getListaCartaoAmarelo().add(jogador2);
				idx++;
			} 
		} catch (RegistroNaoEncontradoException e) {
			e.printStackTrace();
		}
		
		// Carregar os jogadores por posicao
		
//		if ( tatica == Tatica._3_5_2.getValor() ) { 
//			retorno= Tatica._3_5_2;
//		} else if ( tatica == Tatica._4_3_3.getValor() ) { 
//			retorno= Tatica._4_3_3;
//		} else if ( tatica == Tatica._4_4_2.getValor() ) { 
//			retorno= Tatica._4_4_2;
//		} else { 
//			retorno= Tatica._4_5_1;	
//		}		
		
		/* 
		 * Define as posicoes do campo que foi divido
		 * 	em tres partes:
		 * - 0: ataque mandante / defesa visitante
		 * - 1: meio campo mandante / meio campo visitante
		 * - 2: defesa mandante / ataque visitante
		 */
		int quadranteAtual= 1;
		
		/* 
		 * Define a selecao que esta com a bola
		 * - V: visitante
		 * - M: mandante
		 */		
		char selecaoBola= 'M';
		boolean visitanteBateCentro= Biblioteca.geraBooleanAleatorio();
		
		// Simula to tempo de partida
		for (int i = 1; i <= 90; i++) {
			
			// Simula a posicao da bola no campo
			switch (quadranteAtual) {
			case 0: // ataque mandante / defesa visitante
				
				
				break;
				
			case 1: // meio campo
				
				break;
				
			case 2: // ataque mandante / defesa visitante
				
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

}
