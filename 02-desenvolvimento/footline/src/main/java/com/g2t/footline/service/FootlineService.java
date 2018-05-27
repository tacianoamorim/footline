package com.g2t.footline.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import com.g2t.footline.dao.FootlineDAO;
import com.g2t.footline.entity.Clube;
import com.g2t.footline.entity.Escalacao;
import com.g2t.footline.entity.Footline;
import com.g2t.footline.entity.Jogador;
import com.g2t.footline.entity.Partida;
import com.g2t.footline.entity.Rodada;

public class FootlineService {

	private static FootlineService uniqueInstance;
	private FootlineDAO gerenteDAO;

	private FootlineService() { 
		gerenteDAO= new FootlineDAO();
	}

	public static synchronized FootlineService getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new FootlineService();
		return uniqueInstance;
	}
	
	public void salvar(String nomeArquivo, Footline gerente) throws IOException {
		gerenteDAO.salvar(nomeArquivo, gerente);
	}

	public Footline carregar(String nomeArquivo) throws IOException, ClassNotFoundException {
		return gerenteDAO.carregar(nomeArquivo);
	}

	public List<String> listaArquivos() throws IOException, ClassNotFoundException {
		return gerenteDAO.listaArquivos();
	}

	/**
	 * Inializa o jogo carregando os dados dos clubes armazenado no arquivos .foot,
	 * 	realizando os sorteios e as demais operacoes.
	 * 
	 * @param gerente - atualiza as informacoes do jogo
	 */
	public void inicializarJogo(Footline footline) {
		
		// Carrega a lista de clubes
		List<Clube> clubes= ClubeService.getInstance().buscarClubes();

		// Gerar dados jogador
		for (Clube clube : clubes) {
			for (Jogador jogador : clube.getListaGoleiro()) {
				JogadorService.getInstance().gerarDadosComplementares(
						clube.getNivel(), jogador);
			}
			for (Jogador jogador : clube.getListaDefesa()) {
				JogadorService.getInstance().gerarDadosComplementares(
						clube.getNivel(), jogador);
			}
			for (Jogador jogador : clube.getListaMeioCampo()) {
				JogadorService.getInstance().gerarDadosComplementares(
						clube.getNivel(), jogador);
			}			
			for (Jogador jogador : clube.getListaAtaque()) {
				JogadorService.getInstance().gerarDadosComplementares(
						clube.getNivel(), jogador);
			}
		}
		
		// Sorteia o clube que sera gerenciado
		Clube clubeGerenciado= ClubeService.getInstance().sorteioClube( clubes );
		
		// Atualiza o nome do tecnico
		clubeGerenciado.setTecnico( footline.getUsuario() );
		footline.setClubeGerenciado( clubeGerenciado );
		
		// Criar as rodadas 
		footline.setRodadas( gerarRodadas( clubes ) );
	}

	/**
	 * Realiza o sorteios das partidas nas rodadas
	 * @param clubes
	 */
	private List<Rodada> gerarRodadas(List<Clube> clubes) {
		// Criar a rodadas
		int quantidadeRodadas= ( clubes.size() * 2 ) - 2;
		
		// Data inicial
		Calendar dataRodada= new GregorianCalendar(2018, 02, 4, 16, 0, 0);
		
		List<Rodada> rodadas= new ArrayList<Rodada>();
		for (int idx = 1; idx <= quantidadeRodadas; idx++) {
			Rodada rodada= new Rodada();
			rodada.setNumero( idx );
			rodada.setData( dataRodada );
			rodadas.add( rodada );

			// Nova data
			Calendar novaDataRodada= new GregorianCalendar();
			novaDataRodada.setTime( dataRodada.getTime() );
			
			novaDataRodada.add(Calendar.DATE, 8);
			dataRodada= novaDataRodada;
		}

		sortearClubesRodadas(rodadas, clubes);
		
		return rodadas;
	}

	private void sortearClubesRodadas(List<Rodada> rodadas, List<Clube> clubes) {
		// TODO: 003 - Sortear os times nas rodadas
		for (Rodada rodada : rodadas) {
			List<Partida> partidas= new ArrayList<Partida>();
			for (Clube clubeMandante : clubes) {
				Partida partida= new Partida();
				
				Escalacao escolacaoMandante= new Escalacao();
				escolacaoMandante.setClube(clubeMandante);
				partida.setMandante(escolacaoMandante);
				for (Clube clubeVisitante : clubes) {
					Escalacao escolacaoVisitante= new Escalacao();
					escolacaoVisitante.setClube(clubeVisitante);
					partida.setVisitante(escolacaoVisitante);
				}
				partidas.add( partida );
			}
			rodada.setPartidas(partidas);
		}
	}
}