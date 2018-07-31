package com.g2t.footline.negocio.cadastros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.g2t.footline.dados.RepositorioRodada;
import com.g2t.footline.dados.RepositorioRodadaLista;
import com.g2t.footline.exception.ArquivoNaoEncontradoException;
import com.g2t.footline.exception.RegistroNaoEncontradoException;
import com.g2t.footline.gui.FrmPrincipal;
import com.g2t.footline.negocio.Fachada;
import com.g2t.footline.negocio.entidades.Arbitro;
import com.g2t.footline.negocio.entidades.Escalacao;
import com.g2t.footline.negocio.entidades.Estadio;
import com.g2t.footline.negocio.entidades.Jogador;
import com.g2t.footline.negocio.entidades.Partida;
import com.g2t.footline.negocio.entidades.Rodada;
import com.g2t.footline.negocio.entidades.Selecao;
import com.g2t.footline.util.Biblioteca;
import com.g2t.footline.util.Constantes;

public class CadastroRodada {
	private RepositorioRodada repositorio;
	private static CadastroRodada instance;
	
	private CadastroRodada() {
		repositorio= new RepositorioRodadaLista();
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
	public Rodada buscar(int numero) throws RegistroNaoEncontradoException {
		return repositorio.buscar( numero );
	}
	
	/**
	 * Lista todos contidos na lista
	 * 
	 * return List<Rodada>
	 */
	public List<Rodada> listar() {
		return repositorio.listar();
	}	
	
	/**
	 * Adiciona um rodada na lista
	 * 
	 * @param Rodada
	 */
	public void inserir(Rodada rodada) {
		repositorio.inserir(rodada);
	}

	/**
	 * Le o arquivo rodadas e carrega na lista.
	 * 
	 * @throws ArquivoNaoEncontradoException 
	 * @throws RegistroNaoEncontradoException 
	 */
	public void carregar() throws ArquivoNaoEncontradoException, 
		RegistroNaoEncontradoException {
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
			   switch ( idx ) {
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
					Escalacao mandanteFG= new Escalacao(selecaoMananteFG, 
							selecaoMananteFG.getTatica(), 
							new ArrayList<Jogador>(), new ArrayList<Jogador>()); 

					Selecao selecaoVisitanteFG= Fachada.getInstance().buscarSelecao( arrayLinha[4] );
					Escalacao visitanteFG= new Escalacao(selecaoVisitanteFG, 
							selecaoVisitanteFG.getTatica(), 
							new ArrayList<Jogador>(), new ArrayList<Jogador>());			
					
					// Busca o arbitro
					int idArbitro= Integer.parseInt( String.valueOf( arrayLinha[6] ) );
					Arbitro arbitroFG= Fachada.getInstance().buscarArbitro( idArbitro );
					
					// Busca o estadio
					Estadio estadioFG= Fachada.getInstance().buscarEstadio( arrayLinha[5] );
					
					String grupoOF= arrayLinha[2];
					
					Partida partidaFG= new Partida(idPartidaFG, mandanteFG, visitanteFG, 
							arbitroFG, estadioFG);
					partidaFG.setGrupo(grupoOF);
					rodada.getPartidas().add(partidaFG);
					
					break;
					
				case Constantes.TIPO_DADO_PARTIDA_OF: //8,49,1,A,2,B,SOC,15
					int idPartidaOF= Integer.parseInt( String.valueOf( arrayLinha[1] ) );
					
					int mandantePosicaoOF= Integer.parseInt( String.valueOf( arrayLinha[2] ) );
					String mandanteGrupoOF= arrayLinha[3];
					int visitantePosicaoOF= Integer.parseInt( String.valueOf( arrayLinha[4] ) );
					String visitanteGrupoOF= arrayLinha[5];
					
					// Busca o arbitro
					int idArbitroOF= Integer.parseInt( String.valueOf( arrayLinha[7] ) );
					Arbitro arbitroOF= Fachada.getInstance().buscarArbitro( idArbitroOF );
					
					// Busca o estadio
					Estadio estadioOF= Fachada.getInstance().buscarEstadio( arrayLinha[6] );
					
					Partida partidaOF= new Partida(idPartidaOF, null, null, 
							arbitroOF, estadioOF);
					partidaOF.setMandanteGrupo(mandanteGrupoOF);
					partidaOF.setMandantePosicao(mandantePosicaoOF);
					partidaOF.setVisitanteGrupo(visitanteGrupoOF);
					partidaOF.setVisitantePosicao(visitantePosicaoOF);
					
					rodada.getPartidas().add(partidaOF);
					
					break;
					
				case Constantes.TIPO_DADO_PARTIDA_QF: //4,57,49,50,NIZ,23
					int idPartidaQF= Integer.parseInt( String.valueOf( arrayLinha[1] ) );
					
					// Busca o arbitro
					int idArbitroQF= Integer.parseInt( String.valueOf( arrayLinha[5] ) );
					Arbitro arbitroQF= Fachada.getInstance().buscarArbitro( idArbitroQF );
					
					// Busca o estadio
					Estadio estadioQF= Fachada.getInstance().buscarEstadio( arrayLinha[4] );
					
					int mandantePosicaoQF= Integer.parseInt( String.valueOf( arrayLinha[2] ) );
					int visitantePosicaoQF= Integer.parseInt( String.valueOf( arrayLinha[3] ) );
					
					Partida partidaQF= new Partida(idPartidaQF, null, null, 
							arbitroQF, estadioQF);
					partidaQF.setMandantePosicao(mandantePosicaoQF);
					partidaQF.setVisitantePosicao(visitantePosicaoQF);
					
					rodada.getPartidas().add(partidaQF);
					
					break;
					
				case Constantes.TIPO_DADO_PARTIDA_SF: //2,61,57,58,SAO,27
					int idPartidaSF= Integer.parseInt( String.valueOf( arrayLinha[1] ) );
					
					// Busca o arbitro
					int idArbitroSF= Integer.parseInt( String.valueOf( arrayLinha[5] ) );
					Arbitro arbitroSF= Fachada.getInstance().buscarArbitro( idArbitroSF );
					
					// Busca o estadio
					Estadio estadioSF= Fachada.getInstance().buscarEstadio( arrayLinha[4] );
					
					int mandantePosicaoSF= Integer.parseInt( String.valueOf( arrayLinha[2] ) );
					int visitantePosicaoSF= Integer.parseInt( String.valueOf( arrayLinha[3] ) );
					
					Partida partidaSF= new Partida(idPartidaSF, null, null, 
							arbitroSF, estadioSF);
					partidaSF.setMandantePosicao(mandantePosicaoSF);
					partidaSF.setVisitantePosicao(visitantePosicaoSF);
					
					rodada.getPartidas().add(partidaSF);
					
					break;		
					
				case Constantes.TIPO_DADO_PARTIDA_3L: //1,63,61,62,SAO,29
					int idPartida3L= Integer.parseInt( String.valueOf( arrayLinha[1] ) );
					
					// Busca o arbitro
					int idArbitro3L= Integer.parseInt( String.valueOf( arrayLinha[5] ) );
					Arbitro arbitro3L= Fachada.getInstance().buscarArbitro( idArbitro3L );
					
					// Busca o estadio
					Estadio estadio3L= Fachada.getInstance().buscarEstadio( arrayLinha[4] );
					
					int mandantePosicao3L= Integer.parseInt( String.valueOf( arrayLinha[2] ) );
					int visitantePosicao3L= Integer.parseInt( String.valueOf( arrayLinha[3] ) );
					
					Partida partida3L= new Partida(idPartida3L, null, null, 
							arbitro3L, estadio3L);
					partida3L.setMandantePosicao(mandantePosicao3L);
					partida3L.setVisitantePosicao(visitantePosicao3L);
					
					rodada.getPartidas().add(partida3L);
					
					break;		
					
				case Constantes.TIPO_DADO_PARTIDA_PF: //0,64,61,62,LUJ,30
					int idPartidaPF= Integer.parseInt( String.valueOf( arrayLinha[1] ) );
					
					// Busca o arbitro
					int idArbitroPF= Integer.parseInt( String.valueOf( arrayLinha[5] ) );
					Arbitro arbitroPF= Fachada.getInstance().buscarArbitro( idArbitroPF );
					
					// Busca o estadio
					Estadio estadioPF= Fachada.getInstance().buscarEstadio( arrayLinha[4] );

					int mandantePosicaoPF= Integer.parseInt( String.valueOf( arrayLinha[2] ) );
					int visitantePosicaoPF= Integer.parseInt( String.valueOf( arrayLinha[3] ) );
										
					Partida partidaPF= new Partida(idPartidaPF, null, null, 
							arbitroPF, estadioPF);
					partidaPF.setMandantePosicao(mandantePosicaoPF);
					partidaPF.setVisitantePosicao(visitantePosicaoPF);
					
					rodada.getPartidas().add(partidaPF);
					
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
	
	/**
	 * Realiza o processamento de uma rodada
	 * 
	 * @param int numero
	 * @param FrmPrincipal frmPrincipal
	 * @throws RegistroNaoEncontradoException
	 */
	public void processarRodada(int numero, FrmPrincipal frmPrincipal) 
			throws RegistroNaoEncontradoException {

		// busca as partidas da rodada
		Rodada rodada= repositorio.buscar( numero );
		
		Jogador jogador1= CadastroJogador.getInstance().buscar(1);
		Jogador jogador2= CadastroJogador.getInstance().buscar(2);
		Jogador jogador3= CadastroJogador.getInstance().buscar(200);
		Jogador jogador4= CadastroJogador.getInstance().buscar(100);
		int idx= 0;

		List<Partida> partidas= rodada.getPartidas();
		for (Partida partida : partidas) {
			
			// calcula o publico da partida
			float capacidade= partida.getEstadio().getCapacidade();
			float capacidadeMinima= (float) (capacidade * 0.8);
			float publico= Biblioteca.geraValorAleatorio(
					capacidadeMinima, capacidade);
			partida.setPublico( publico );
	
			if ( idx==0 ) {
				partida.getGolsMandante().add(jogador1);
				partida.getGolsMandante().add(jogador1);
				partida.getGolsMandante().add(jogador3);
				partida.getGolsVisitante().add(jogador4);
				partida.getListaCartaoAmarelo().add(jogador1);
				partida.getListaCartaoVermelho().add(jogador1);
				partida.getListaCartaoAmarelo().add(jogador2);
				idx++;
			} 
			
			CadastroPartida.getInstance().processarPartida(partida);
		}
		
		// Atualiza os dados da rodada
		rodada.setFinalizada( true );
		repositorio.atualizar(rodada);
		
		// registra as informacoes dos jogadores
		CadastroJogador.getInstance().atualizarDadosRodada( rodada );
		
	}

	
}
