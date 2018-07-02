package com.g2t.footline.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.g2t.footline.dao.ClubeDAO;
import com.g2t.footline.entisade.Clube;
import com.g2t.footline.entisade.Footline;

public class ClubeService {

	private static ClubeService uniqueInstance;
	private ClubeDAO clubeDAO;

	private ClubeService() {
		clubeDAO= new ClubeDAO();
	}

	public static synchronized ClubeService getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new ClubeService();
		return uniqueInstance;
	}
	
	/**
	 * Realiza o carregamento dos arquivos referentes aos clubes
	 * 
	 * @return List<Clube> 
	 */
	protected List<Clube> buscarClubes() {
		List<Clube> retorno= new ArrayList<Clube>();
		try {
			retorno= clubeDAO.buscarClubes();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return retorno;
	}
	
	/**
	 * Realiza o sorteio dos clubes existentes e retorna um
	 * 
	 * @param lista carregada dos clubes
	 * @return clube sorteado para gerenciamento
	 */
	protected Clube sorteioClube(List<Clube> lista) {
		Random random = new Random();
		int nAleatorio = random.nextInt(9);
		return lista.get(nAleatorio);
	}	
	
	/**
	 * Retorna uma lista com a classificacao atual dos times 
	 * 	seguindo a seguinte ordem:
	 *   1- maior numero de pontos
	 *   2- maior numero de vitorias
	 *   3- maior saldo de gols
	 *   4- maior quantidade de gols a favor
	 *   5- menor quantidade de gols a favor  
	 * 	 6- sorteio
	 * 
	 * @param Footline footline
	 * @return List<Clube>
	 */
	public List<Clube> retornaClassificacao(Footline footline) {
		// TODO: 005 - implementar classificacao dos times
		return new ArrayList();
	}
	
}