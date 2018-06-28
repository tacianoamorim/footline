package com.g2t.footline.gui;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import com.g2t.footline.negocio.entidades.Arbitro;
import com.g2t.footline.negocio.entidades.Escalacao;
import com.g2t.footline.negocio.entidades.Jogador;
import com.g2t.footline.negocio.entidades.Partida;
import com.g2t.footline.negocio.entidades.Rodada;
import com.g2t.footline.negocio.entidades.Selecao;
import com.g2t.footline.negocio.entidades.Tecnico;

public class Main {

	public static void main(String[] args) {
		
		// Cria o objeto tecnico
		Tecnico tecnico= new Tecnico(1, "Joao Santana");
		
		// Cria o objeto clube
		Selecao selecao= new Selecao(1, "Brasil", tecnico, 101, "B");
		
		// Cria o objeto jogador
		int idx=0;
		Jogador jogador= new Jogador(++idx, "Antonio ", Jogador.GOLEIRO);
		Jogador jogador2= new Jogador(++idx, "Paulo ", Jogador.DEFESA);
		Jogador jogador3= new Jogador(++idx, "Andre ", Jogador.DEFESA);
		Jogador jogador4= new Jogador(++idx, "João ", Jogador.DEFESA);
		Jogador jogador5= new Jogador(++idx, "Adolfo ", Jogador.DEFESA);
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
		selecao.setJogadores(jogadores);
		
		// Cria uma escalacao mandante e visitante
		Escalacao escalacaoMandante= new Escalacao(selecao, Escalacao._4_2_4, jogadores, null);
		Escalacao escalacaoVisitante= new Escalacao(selecao, Escalacao._4_3_3, jogadores, null);
		
		// Cria uma partida
		Arbitro arbitro= new Arbitro(1, "Joao Santana", 53);

		Partida partida= new Partida(escalacaoMandante, escalacaoVisitante, arbitro);
		
		// Cria a lista de partidas
		List<Partida> partidas= new ArrayList<Partida>();	
		partidas.add(partida);
		
		// Cria a rodada
		Rodada rodada= new Rodada(1, partidas, false, new GregorianCalendar() );
		
		// Cria a lista de rodadas
		List<Rodada> rodadas= new ArrayList<Rodada>();	
		rodadas.add(rodada);	
		

	}
}
