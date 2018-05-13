package com.g2t.footline.dao;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.g2t.footline.entity.Clube;

public class ClubeDAO {

	
	public List<Clube> buscarClubes() throws ClassNotFoundException, IOException {
		return listaArquivos();
	} 
	
	/**
	 * Carregar os dados dos clubes armazenados nos arquivos .foot
	 *  
	 * @return List<Clube> - Lista de clubes carregados
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private List<Clube> listaArquivos() throws IOException, ClassNotFoundException {
		List<Clube> retorno = new ArrayList<Clube>();
		
		// Carrega o path de armazenamento dos arquivos
		File file = new File(ClubeDAO.class.getResource("").getPath() + "times");
		File afile[] = file.listFiles();
		
		// Carregar os dados dos clubes
		for (int i=0; i < afile.length; i++) {
			if (afile[i].getName().endsWith("foot")) {
				Clube clube= converteArquivo(afile[i]);
				retorno.add(clube);
			}
		}
		return retorno;
	}

	private Clube converteArquivo(File file) {
		String nomeArquivo= file.getName().replaceAll(".foot", "");
		System.out.println(nomeArquivo);
		
		Clube clube= new Clube();
		clube.setAcronomo(nomeArquivo);
		clube.setNomeEstadio(nomeArquivo);
		clube.setNomeArquivo(nomeArquivo);
		clube.setTecnico(nomeArquivo);
		
		return clube;
	}
	
	

}
