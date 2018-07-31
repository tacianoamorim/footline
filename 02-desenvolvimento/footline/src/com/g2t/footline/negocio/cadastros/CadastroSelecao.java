package com.g2t.footline.negocio.cadastros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.g2t.footline.dados.RepositorioSelecao;
import com.g2t.footline.dados.RepositorioSelecaoLista;
import com.g2t.footline.exception.RegistroNaoEncontradoException;
import com.g2t.footline.negocio.entidades.Jogador;
import com.g2t.footline.negocio.entidades.Selecao;
import com.g2t.footline.negocio.entidades.Tatica;
import com.g2t.footline.negocio.entidades.Tecnico;
import com.g2t.footline.util.Constantes;

public class CadastroSelecao {
	private RepositorioSelecao repositorio;
	private static CadastroSelecao instance;
	
	private CadastroSelecao() {
		repositorio= new RepositorioSelecaoLista();
	}
	
	public static CadastroSelecao getInstance() {
		if ( instance == null )
			instance= new CadastroSelecao();
		return instance;
	}
	
	/**
	 * Carrega o arrayDados com as informacoes das selecoes 
	 * 	 obtidas nos arquivos das selecoes
	 * 
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public void carregar() throws NumberFormatException, IOException {
		// Carrega o path de armazenamento dos arquivos
		File file = new File(Constantes.FILE_PATH + 
				File.separator + "selecoes");
		File afile[] = file.listFiles();
		
		// Carregar os dados dos clubes
		for (int i=0; i < afile.length; i++) {
			// recupera a extensao do arquivo
			if (afile[i].getName().endsWith("foot")) {
				
				Selecao selecao= null;
				List<Jogador> jogadores= new ArrayList<Jogador>();
				
				// le os dados de um arquivo
				BufferedReader br = new BufferedReader(new FileReader(afile[i]));
				while(br.ready()){
				   String linha = br.readLine();
				   
				   // Monta um array da linha
				   String[] arrayLinha= linha.split(","); 
				   char idx= arrayLinha[0].charAt(0);
				   
				   switch (idx) {
					case Constantes.FILE_DADOS_SELECAO: 
						//S,Alemanha,Joachim Löw,97,ALE,F,442
						String nome= arrayLinha[1];
						int nivel= Integer.valueOf(arrayLinha[3]);
						String acronomo= arrayLinha[4];
						String grupo= arrayLinha[5];

						// Cadastrar um tecnico
						String nomeTecnico= arrayLinha[2];
						Tecnico tecnico= new Tecnico(0, nomeTecnico);
						CadastroTecnico.getInstance().inserir(tecnico);
						
						// Cadastrar a selecao
						selecao= new Selecao(acronomo, nome, tecnico, nivel, 
								grupo, null);
						
						// identifica qual é a tatica
						int taticaCodigo= Integer.parseInt( arrayLinha[6] );
						selecao.setTatica( identificarTatica( taticaCodigo ) );
						
						repositorio.inserir(selecao);
						
						break;
			
					case Constantes.FILE_DADOS_JOGADOR_GOLEIRO: //idx,Nome,nivel
						Jogador goleiro= new Jogador();
						goleiro.setNome( arrayLinha[1] );
						goleiro.setNivel( Integer.valueOf(arrayLinha[2]) );
						goleiro.setPosicao( Jogador.GOLEIRO );
						goleiro.setSelecao(selecao);
						
						// Cadastrar jogador
						CadastroJogador.getInstance().inserir(goleiro);
						
						// Adiciona o jogador na lista
						jogadores.add( goleiro );
						break;
						
					case Constantes.FILE_DADOS_JOGADOR_DEFESA: //idx,Nome,nivel
						Jogador defesa= new Jogador();
						defesa.setNome( arrayLinha[1] );
						defesa.setNivel( Integer.valueOf(arrayLinha[2]) );
						defesa.setPosicao( Jogador.DEFESA );
						defesa.setSelecao(selecao);
						
						// Cadastrar jogador
						CadastroJogador.getInstance().inserir(defesa);
						
						// Adiciona o jogador na lista
						jogadores.add( defesa );						
						break;
						
					case Constantes.FILE_DADOS_JOGADOR_MEIA: //idx,Nome,nivel
						Jogador meioCampo= new Jogador();
						meioCampo.setPosicao( Jogador.MEIO_CAMPO );
						meioCampo.setNome( arrayLinha[1] );
						meioCampo.setNivel( Integer.valueOf(arrayLinha[2]) );
						meioCampo.setSelecao(selecao);
						
						// Cadastrar jogador
						CadastroJogador.getInstance().inserir(meioCampo);	
						
						// Adiciona o jogador na lista
						jogadores.add( meioCampo );	
						break;
						
					case Constantes.FILE_DADOS_JOGADOR_ATAQUE: //idx,Nome,nivel
						Jogador ataque= new Jogador();
						ataque.setPosicao("A");
						ataque.setNome( arrayLinha[1] );
						ataque.setSelecao(selecao);
						ataque.setNivel( Integer.valueOf(arrayLinha[2]) );
						
						// Cadastrar jogador
						CadastroJogador.getInstance().inserir(ataque);	
						
						// Adiciona o jogador na lista
						jogadores.add( ataque );	
						break;					
						
					default:
						break;
					}
				}
				selecao.setJogadores( jogadores );
				br.close();
			}
		}
	}
	
	/**
	 * Identifica a tatica utilizada pela equipe
	 * 
	 * @param int
	 * @return Tatica
	 */
	private Tatica identificarTatica(int tatica) {
		Tatica retorno;
		if ( tatica == Tatica._3_5_2.getValor() ) { 
			retorno= Tatica._3_5_2;
		} else if ( tatica == Tatica._4_3_3.getValor() ) { 
			retorno= Tatica._4_3_3;
		} else if ( tatica == Tatica._4_4_2.getValor() ) { 
			retorno= Tatica._4_4_2;
		} else { 
			retorno= Tatica._4_5_1;	
		}
		return retorno;
	}

	/**
	 * Lista todos contidos no array de selecoes
	 * 
	 * return List<Selecao>
	 */
	public List<Selecao> listar() {
		return repositorio.listar();
	}

	/**
	 * Adiciona uma selecao no array
	 * 
	 * @param Selecao
	 */
	public void inserir(Selecao selecao) {
		repositorio.inserir(selecao);
	}	
	
	/**
	 * Busca um determinado selecao pelo codigo
	 * 
	 * return selecao selecao
	 * @throws RegistroNaoEncontradoException 
	 */
	public Selecao buscar(String id) throws RegistroNaoEncontradoException {
		return repositorio.buscar(id);
	}	
	
	/**
	 * Busca um determinado selecao pelo nome
	 * 
	 * return selecao selecao
	 * @throws RegistroNaoEncontradoException 
	 */
	public Selecao buscarPorNome(String nome) throws RegistroNaoEncontradoException {
		return repositorio.buscarPorNome(nome);
	}	
}
