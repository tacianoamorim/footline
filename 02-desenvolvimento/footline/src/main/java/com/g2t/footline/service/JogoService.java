package com.g2t.footline.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.g2t.footline.dao.JogoDAO;
import com.g2t.footline.entity.Clube;
import com.g2t.footline.entity.Jogo;
import com.g2t.footline.entity.Rodada;

public class JogoService {

	private static JogoService uniqueInstance;
	private JogoDAO jogoDAO;

	private JogoService() { 
		jogoDAO= new JogoDAO();
	}

	public static synchronized JogoService getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new JogoService();
		return uniqueInstance;
	}
	
	public void salvar(String nomeArquivo, Jogo jogo) throws IOException {
		jogoDAO.salvar(nomeArquivo, jogo);
	}

	public Jogo carregar(String nomeArquivo, Jogo jogo) throws IOException, ClassNotFoundException {
		return jogoDAO.carregar(nomeArquivo, jogo);
	}

	public List<String> listaArquivos() throws IOException, ClassNotFoundException {
		return jogoDAO.listaArquivos();
	}

	/**
	 * Inializa o jogo carregando os dados dos clubes armazenado no arquivos .foot,
	 * 	realizando os sorteios e as demais operacoes.
	 * 
	 * @param jogo - atualiza as informacoes do jogo
	 */
	public void inicializarJogo(Jogo jogo) {
		
		// Carrega a lista de clubes
		List<Clube> clubes= ClubeService.getInstance().buscarClubes();

		// Sorteia o clube que sera gerenciado
		Clube clubeGerenciado= ClubeService.getInstance().sorteioClube(clubes);
		
		// Atualiza o nome do tecnico
		clubeGerenciado.setTecnico(jogo.getUsuario());
		jogo.setClubeGerenciado(clubeGerenciado);
		
		// Criar a rodadas
		int quantidadeRodadas= (clubes.size() * 2) - 2;
		List<Rodada> rodadas= new ArrayList<Rodada>();
		for (int i = 1; i <= quantidadeRodadas; i++) {
			Rodada rodada= new Rodada();
			rodada.setNumero(i);
			rodadas.add(rodada);
		}
		
		
		
	
	}
}