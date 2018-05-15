package com.g2t.footline.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.g2t.footline.entity.Clube;
import com.g2t.footline.entity.Jogador;

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

	private Clube converteArquivo(File file) throws IOException {
		String nomeArquivo= file.getName().replaceAll(".foot", "");
		Clube clube= new Clube();
		List<Jogador> listGoleiro= new ArrayList<Jogador>();
		List<Jogador> listDefesa= new ArrayList<Jogador>();
		List<Jogador> listMeioCampo= new ArrayList<Jogador>();
		List<Jogador> listAtacante= new ArrayList<Jogador>();
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		while(br.ready()){
		   String linha = br.readLine();
		   
		   // Monta um array da linha
		   String[] arrayLinha= linha.split(","); 
		   char idx= arrayLinha[0].charAt(0);
		   
		   switch (idx) {
			case 'T': //idx,Nome,Acronomo,Estadio,Nivel,Tecnico
				clube.setNome( arrayLinha[1] );
				clube.setAcronomo( arrayLinha[2] );
				clube.setNomeEstadio( arrayLinha[3] );
				clube.setNomeArquivo( nomeArquivo );
				clube.setNivel( Integer.valueOf(arrayLinha[4]) );				
				clube.setTecnico( arrayLinha[1] );				
				break;
	
			case 'G': //idx,Nome Goleiro
				Jogador goleiro= new Jogador();
				goleiro.setNome( arrayLinha[1] );
				listGoleiro.add( goleiro );
				break;
				
			case 'D': //idx,Nome Defesa
				Jogador defesa= new Jogador();
				defesa.setNome( arrayLinha[1] );
				listDefesa.add( defesa );
				break;			
				
			default:
				break;
			}
		}
		br.close();
		
		return clube;
	}
	
	

}
