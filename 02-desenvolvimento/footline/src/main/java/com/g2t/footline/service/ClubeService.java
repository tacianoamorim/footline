package com.g2t.footline.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.g2t.footline.dao.ClubeDAO;
import com.g2t.footline.entity.Clube;

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
	 * @return clube sorteado para gerenciamento
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
		
		
		return new Clube();
	}	
	
}