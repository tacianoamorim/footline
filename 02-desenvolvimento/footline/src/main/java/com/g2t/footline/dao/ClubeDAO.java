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
	
	private static int idxClube;
	private static int idxJogador;
	
	/**
	 * Realiza o carregamento dos arquivos referentes aos clubes
	 * 
	 * @return List<Clube> 
	 */
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
				clube.setId( ++idxClube );
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
			case 'T': //idx,Nome,Acronomo,Nivel,Tecnico,Estadio,capacidade
				clube.setId(++idxClube);
				clube.setNome( arrayLinha[1] );
				clube.setAcronomo( arrayLinha[2] );
				clube.setNivel( Integer.valueOf(arrayLinha[3]) );				
				clube.setTecnico( arrayLinha[4] );				
				clube.setNomeEstadio( arrayLinha[5] );
				clube.setCapacidade( Integer.valueOf(arrayLinha[6]) );	
				clube.setNomeArquivo( nomeArquivo );
				break;
	
			case 'G': //idx,Nome Goleiro
				Jogador goleiro= new Jogador();
				goleiro.setPosicao("G");
				goleiro.setId( ++idxJogador );
				goleiro.setNome( arrayLinha[1] );
				listGoleiro.add( goleiro );
				break;
				
			case 'D': //idx,Nome Defesa
				Jogador defesa= new Jogador();
				defesa.setPosicao("D");
				defesa.setId( ++idxJogador );
				defesa.setNome( arrayLinha[1] );
				listDefesa.add( defesa );
				break;	
				
			case 'M': //idx,Nome MeioCampo
				Jogador meioCampo= new Jogador();
				meioCampo.setPosicao("M");
				meioCampo.setId( ++idxJogador );
				meioCampo.setNome( arrayLinha[1] );
				listMeioCampo.add( meioCampo );
				break;
				
			case 'A': //idx,Nome Ataque
				Jogador ataque= new Jogador();
				ataque.setPosicao("A");
				ataque.setId( ++idxJogador );
				ataque.setNome( arrayLinha[1] );
				listAtacante.add( ataque );
				break;					
				
			default:
				break;
			}
		}
		br.close();
		
		clube.setListaGoleiro(listGoleiro);
		clube.setListaDefesa(listDefesa);
		clube.setListaMeioCampo(listMeioCampo);
		clube.setListaAtaque(listAtacante);
		
		return clube;
	}

}
