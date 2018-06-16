package com.g2t.footline.entity;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		// Cria o objeto tecnico
		Tecnico tecnico= new Tecnico(1, "João Santana");
		
		// Cria o objeto clube
		Clube clube= new Clube(1, "Santa Cruz", "STA", tecnico, "Arruda", "SantaCruz", 98, 62530);
		
		// Cria o objeto jogador
		int idx=0;
		Jogador jogador= new Jogador(++idx, "Antonio ", Jogador.GOLEIRO);
		Jogador jogador2= new Jogador(++idx, "Paulo ", Jogador.DEFEZA);
		Jogador jogador3= new Jogador(++idx, "Andre ", Jogador.DEFEZA);
		Jogador jogador4= new Jogador(++idx, "João ", Jogador.DEFEZA);
		Jogador jogador5= new Jogador(++idx, "Adolfo ", Jogador.DEFEZA);
		Jogador jogador6= new Jogador(++idx, "Paulo Henrique ", Jogador.MEIO_CAMPO);
		Jogador jogador7= new Jogador(++idx, "Saulo ", Jogador.MEIO_CAMPO);
		Jogador jogador8= new Jogador(++idx, "João Tiago", Jogador.MEIO_CAMPO);
		Jogador jogador9= new Jogador(++idx, "Carlos ", Jogador.MEIO_CAMPO);		
		Jogador jogador10= new Jogador(++idx, "Pedro", Jogador.MEIO_CAMPO);
		Jogador jogador11= new Jogador(++idx, "Cueca ", Jogador.MEIO_CAMPO);	

		// Cria a lista de jogadores
		List<Jogador> jogadores= new ArrayList<Jogador>();
		jogadores.add(jogador);
		jogadores.add(jogador2);
		jogadores.add(jogador3);
		jogadores.add(jogador4);
		jogadores.add(jogador5);
		jogadores.add(jogador6);
		jogadores.add(jogador7);
		jogadores.add(jogador8);
		jogadores.add(jogador9);
		jogadores.add(jogador10);
		jogadores.add(jogador11);
		
		// Passa a lista de jogadores para o clube 
		clube.setJogadores(jogadores);
		
		// Cria uma escalacao mandante e visitante
		Escalacao escalacaoMandante= new Escalacao(clube, Escalacao._4_2_4, jogadores, null);
		Escalacao escalacaoVisitante= new Escalacao(clube, Escalacao._4_3_3, jogadores, null);
		
		// Cria uma partida
		Partida partida= new Partida(escalacaoMandante, escalacaoVisitante);
		
		// Cria a lista de partidas
		List<Partida> partidas= new ArrayList<Partida>();	
		partidas.add(partida);
		
		// Cria a rodada
		Rodada rodada= new Rodada(1, partidas, false, new GregorianCalendar() );
		
		// Cria a lista de rodadas
		List<Rodada> rodadas= new ArrayList<Rodada>();	
		rodadas.add(rodada);	
		
		// Cria o objeto do jogo
		Footline footline= new Footline("Gustavo", clube, rodadas, "gustavo1");
		
		
		System.out.println(footline);

	}

}
