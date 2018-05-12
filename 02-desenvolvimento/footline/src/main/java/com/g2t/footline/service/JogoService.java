package com.g2t.footline.service;

import java.io.IOException;
import java.util.List;

import com.g2t.footline.dao.JogoDAO;
import com.g2t.footline.entity.Jogo;

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
}