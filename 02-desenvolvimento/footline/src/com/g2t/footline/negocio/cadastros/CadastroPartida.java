package com.g2t.footline.negocio.cadastros;

import java.util.Random;

import com.g2t.footline.negocio.entidades.Partida;

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
	public void processarPartida(Partida partida) {
		
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
		
		Random random = new Random();
		
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
		
	}

	/**
	 * Retorna um boolean aleatorio
	 * 
	 * @return boolean
	 */
	private boolean getBoolean() {
		Random random = new Random();
		boolean retorno= false;
		if ( (random.nextInt((1 - 0) + 1) + 0) == 1 ) {
			retorno= true;
		}
		return retorno;
	}

}
