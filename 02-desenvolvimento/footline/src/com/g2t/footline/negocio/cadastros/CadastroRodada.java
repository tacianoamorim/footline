package com.g2t.footline.negocio.cadastros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.g2t.footline.dados.RepositorioRodada;
import com.g2t.footline.dados.RepositorioRodadaArray;
import com.g2t.footline.exception.ArquivoNaoEncontradoException;
import com.g2t.footline.exception.RegistroNaoEncontradoException;
import com.g2t.footline.negocio.Fachada;
import com.g2t.footline.negocio.entidades.Arbitro;
import com.g2t.footline.negocio.entidades.Escalacao;
import com.g2t.footline.negocio.entidades.Estadio;
import com.g2t.footline.negocio.entidades.Jogador;
import com.g2t.footline.negocio.entidades.Partida;
import com.g2t.footline.negocio.entidades.Rodada;
import com.g2t.footline.negocio.entidades.Selecao;
import com.g2t.footline.util.Constantes;

public class CadastroRodada {
	private RepositorioRodada repositorio;
	private static CadastroRodada instance;
	
	private CadastroRodada() {
		repositorio= new RepositorioRodadaArray();
	}
	
	public static CadastroRodada getInstance() {
		if ( instance == null )
			instance= new CadastroRodada();
		return instance;
	}
	
	/**
	 * Busca uma determinada rodada pelo codigo
	 * 
	 * return Rodada rodada
	 * @throws RegistroNaoEncontradoException 
	 */
	public Rodada buscar(int id) throws RegistroNaoEncontradoException {
		return repositorio.buscar(id);
	}
	
	/**
	 * Lista todos contidos no array
	 * 
	 * return Rodada[]
	 */
	public Rodada[] listar() {
		return repositorio.listar();
	}	
	
	/**
	 * Adiciona um rodada no array
	 * 
	 * @param Rodada
	 */
	public void inserir(Rodada rodada) {
		repositorio.inserir(rodada);
	}

	/**
	 * Le o arquivo rodadas e carrega o array.
	 * 
	 * @throws ArquivoNaoEncontradoException 
	 * @throws RegistroNaoEncontradoException 
	 */
	public void carregar() throws ArquivoNaoEncontradoException, RegistroNaoEncontradoException {
		try {
			// Carrega o arquivo de arbitros
			File file = new File(Constantes.FILE_PATH + 
					File.separator + "rodadas.foot");
			
			// le os dados de um arquivo
			BufferedReader br = new BufferedReader(new FileReader(file));
			Rodada rodada= null;
			Rodada rodadaAnterior= new Rodada();
			List<Partida> partidas= new ArrayList<Partida>();
			
			while(br.ready()){
			   String linha = br.readLine();
			   
			   // Monta um array da linha
			   String[] arrayLinha= linha.split(","); 
			   char idx= arrayLinha[0].charAt(0);
			   System.out.println(linha);
			   switch (idx) {
				case Constantes.TIPO_DADO_RODADA: //R,1,FASE DE GRUPOS
					int numero= Integer.parseInt( String.valueOf( arrayLinha[1] ) );
					String descricao= arrayLinha[2];
					
					rodada= new Rodada(numero, descricao, false);

					if ( rodada.getNumero() != rodadaAnterior.getNumero() ) {
						rodada.setPartidas( partidas );
						CadastroRodada.getInstance().inserir( rodada );
						partidas= new ArrayList<Partida>();
						rodadaAnterior= rodada;
					}
					break;
					
				case Constantes.TIPO_DADO_PARTIDA_FG: //P,1,A,RUS,ARA,LUJ,1
					int idPartidaFG= Integer.parseInt( String.valueOf( arrayLinha[1] ) );
					
					// Partida 
					Selecao selecaoMananteFG= Fachada.getInstance().buscarSelecao( arrayLinha[3] );
					Escalacao mandanteFG= new Escalacao(selecaoMananteFG, Escalacao._4_4_2, 
							new ArrayList<Jogador>(), new ArrayList<Jogador>()); 

					Selecao selecaoVisitanteFG= Fachada.getInstance().buscarSelecao( arrayLinha[4] );
					Escalacao visitanteFG= new Escalacao(selecaoVisitanteFG, Escalacao._4_4_2, 
							new ArrayList<Jogador>(), new ArrayList<Jogador>());			
					
					// Busca o arbitro
					int idArbitro= Integer.parseInt( String.valueOf( arrayLinha[6] ) );
					Arbitro arbitroFG= Fachada.getInstance().buscarArbitro( idArbitro );
					
					// Busca o estadio
					Estadio estadioFG= Fachada.getInstance().buscarEstadio( arrayLinha[5] );
					
					Partida partidaFG= new Partida(idPartidaFG, mandanteFG, visitanteFG, 
							arbitroFG, estadioFG);
					rodada.getPartidas().add(partidaFG);
					
					break;
					
				default:
					break;
				}
			}					

			br.close();
		} catch (IOException e) {
			throw new ArquivoNaoEncontradoException("Não foi localizado o "
					+ "arquivo arbitros.foot");
		}
			
	}
}
