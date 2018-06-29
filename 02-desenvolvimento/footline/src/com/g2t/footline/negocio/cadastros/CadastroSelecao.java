package com.g2t.footline.negocio.cadastros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.g2t.footline.dados.RepositorioSelecao;
import com.g2t.footline.dados.RepositorioSelecaoArray;
import com.g2t.footline.negocio.Constantes;
import com.g2t.footline.negocio.entidades.Jogador;
import com.g2t.footline.negocio.entidades.Selecao;
import com.g2t.footline.negocio.entidades.Tecnico;

public class CadastroSelecao {
	private RepositorioSelecao repositorioSelecao;
	private static CadastroSelecao instance;
	
	private CadastroSelecao() {
		repositorioSelecao= new RepositorioSelecaoArray();
	}
	
	public static CadastroSelecao getInstance() {
		if ( instance == null )
			instance= new CadastroSelecao();
		return instance;
	}
	
	/**
	 * Carrega o arrayDados com as informacoes das selecoes 
	 * 	 obtidas nos arquivos das selecoes
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public void carregarDados() throws NumberFormatException, IOException {
		// Carrega o path de armazenamento dos arquivos
		File file = new File(Constantes.FILE_PATH + 
				File.separator + "selecoes");
		File afile[] = file.listFiles();
		
		// Carregar os dados dos clubes
		for (int i=0; i < afile.length; i++) {
			// recupera a extensao do arquivo
			if (afile[i].getName().endsWith("foot")) {
				
				// le os dados de um arquivo
				BufferedReader br = new BufferedReader(new FileReader(afile[i]));
				while(br.ready()){
				   String linha = br.readLine();
				   
				   // Monta um array da linha
				   String[] arrayLinha= linha.split(","); 
				   char idx= arrayLinha[0].charAt(0);
				   
				   switch (idx) {
					case Constantes.FILE_DADOS_SELECAO: 
						String nome= arrayLinha[1];
						int nivel= Integer.valueOf(arrayLinha[3]);
						String grupo= arrayLinha[4];
						
						// Cadastrar um tecnico
						String nomeTecnico= arrayLinha[2];
						Tecnico tecnico= new Tecnico(0, nomeTecnico);
						//CadastroTecnico.getInstance().inserir(tecnico);
						
						// Cadastrar a selecao
						Selecao selecao= new Selecao(0, nome, tecnico, nivel, grupo);
						repositorioSelecao.inserir(selecao);
						
						break;
			
					case Constantes.FILE_DADOS_JOGADOR_GOLEIRO: //idx,Nome,nivel
						Jogador jogadorG= new Jogador();
						jogadorG.setNome( arrayLinha[1] );
						jogadorG.setNivel( Integer.valueOf(arrayLinha[2]) );
						jogadorG.setPosicao( Jogador.GOLEIRO );
						
						// Cadastrar jogador
						//CadastroJogador.getInstance().inserir(jogador);
						break;
						
					case Constantes.FILE_DADOS_JOGADOR_ZAGA: //idx,Nome,nivel
						Jogador jogadorZ= new Jogador();
						jogadorZ.setNome( arrayLinha[1] );
						jogadorZ.setNivel( Integer.valueOf(arrayLinha[2]) );
						jogadorZ.setPosicao( Jogador.DEFESA );
						
						// Cadastrar jogador
						//CadastroJogador.getInstance().inserir(jogadorZ);
						break;
						
					case Constantes.FILE_DADOS_JOGADOR_MEIA: //idx,Nome,nivel
						Jogador meioCampo= new Jogador();
						meioCampo.setPosicao( Jogador.MEIO_CAMPO );
						meioCampo.setNome( arrayLinha[1] );
						meioCampo.setNivel( Integer.valueOf(arrayLinha[2]) );
						
						// Cadastrar jogador
						//CadastroJogador.getInstance().inserir(meioCampo);						
						break;
						
					case Constantes.FILE_DADOS_JOGADOR_ATAQUE: //idx,Nome,nivel
						Jogador ataque= new Jogador();
						ataque.setPosicao("A");
						ataque.setNome( arrayLinha[1] );
						ataque.setNivel( Integer.valueOf(arrayLinha[2]) );
						
						// Cadastrar jogador
						//CadastroJogador.getInstance().inserir(ataque);						
						break;					
						
					default:
						break;
					}
				}
				br.close();
			}
		}
	}
	
}
