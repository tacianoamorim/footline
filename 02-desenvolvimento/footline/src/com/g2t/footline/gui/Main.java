package com.g2t.footline.gui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

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
import com.g2t.footline.negocio.entidades.Tecnico;

public class Main {

	public static void main(String[] args) {
		try {
			/*
			 * Le os arquivos de selecoes e carrega os 
			 * 	array de selecao e jogador
			 */
			Fachada.getInstance().carregarSelecaoJogador();
			
			// Carrega o array de arbitro
			Fachada.getInstance().carregarArbitro();
			
			// Listar arbitros
			System.out.println("--------------------------------------");
			System.out.println("  LISTA ARBITROS");
			System.out.println("--------------------------------------");
			Arbitro[] arbitros= Fachada.getInstance().listarArbitro();
			for (int i = 0; i < arbitros.length; i++) {
				Arbitro arbitro = arbitros[i];
				if ( arbitro != null )
					System.out.println(arbitro);
			}
			
			// Busca o arbitro pelo codigo 
			System.out.println();
			System.out.print("Busca arbitro codigo 11 =>");
			System.out.println(Fachada.getInstance().buscarArbitro(11));
			System.out.print("Busca arbitro codigo 22 =>");
			System.out.println(Fachada.getInstance().buscarArbitro(22));			
			
			// Carrega o array de estadio
			Fachada.getInstance().carregarEstadio();	
			
			// Listar estadios
			System.out.println("--------------------------------------");
			System.out.println("  LISTA ESTADIOS");
			System.out.println("--------------------------------------");
			Estadio[] estadios= Fachada.getInstance().listarEstadio();
			for (int i = 0; i < estadios.length; i++) {
				Estadio estadio = estadios[i];
				if ( estadio != null )
					System.out.println(estadio);
			}			
			
			// Busca o estadio pelo codigo 
			System.out.println();
			System.out.print("Busca estadio codigo SAR =>");
			System.out.println(Fachada.getInstance().buscarEstadio("SAR"));
			
			// Listar tecnicos
			System.out.println("--------------------------------------");
			System.out.println("  LISTA TECNICOS");
			System.out.println("--------------------------------------");
			Tecnico[] tecnicos= Fachada.getInstance().listarTecnicos();
			for (int i = 0; i < tecnicos.length; i++) {
				Tecnico tecnico = tecnicos[i];
				if ( tecnico != null )
					System.out.println(tecnico);
			}
			
			// Busca o tecnico pelo codigo 
			System.out.println();
			System.out.print("Busca tecnico codigo 10 =>");
			System.out.println(Fachada.getInstance().buscarTecnico(10));
			System.out.print("Busca tecnico codigo 20 =>");
			System.out.println(Fachada.getInstance().buscarTecnico(20));			
			
			// Listar Selecoes e jogadores
			System.out.println();
			System.out.println("--------------------------------------");
			System.out.println("  LISTA SELECOES E SEUS JOGADORES");
			System.out.println("--------------------------------------");			
			Selecao[] selecoes= Fachada.getInstance().listarSelecoes();
			for (int i = 0; i < selecoes.length; i++) {
				Selecao selecao = selecoes[i];
				if ( selecao != null ) {
					System.out.println("Selecao: "+ selecao.getId()
					+ "- " + selecao.getNome() );
					// Lista jogadores
					for( Jogador jogador: selecao.getJogadores() ) {
						System.out.println("   -> "+ jogador.getPosicao()
								+": "+ jogador.getId()
								+"- "+ jogador.getNome() 
								+"- "+ jogador.getNivel() );
					}		
				}
			}
			
			// Cadastro das rodadas
			System.out.println();
			System.out.println("--------------------------------------");
			System.out.println("  CADASTRO DAS RODADAS ");
			System.out.println("--------------------------------------");			
			Fachada.getInstance().carregarRodadas();
//			////////////////////////////////////////////////////////////////////
//			// 1 Rodada
//			////////////////////////////////////////////////////////////////////
//			Rodada rodada1= new Rodada(1, "Fase Grupo", false);
//			rodada1.setPartidas( new ArrayList<Partida>() );
//			
//			// 1 Partida ///////////////////////////////////////////////////////
//			Selecao selecaoManante1= Fachada.getInstance().buscarSelecao("RUS");
//			Escalacao mandante1= new Escalacao(selecaoManante1, Escalacao._4_2_4, 
//					new ArrayList<Jogador>(), new ArrayList<Jogador>()); 
//
//			Selecao selecaoVisitante1= Fachada.getInstance().buscarSelecao("ARA");
//			Escalacao visitante1= new Escalacao(selecaoVisitante1, Escalacao._4_5_1, 
//					new ArrayList<Jogador>(), new ArrayList<Jogador>());			
//			
//			Arbitro arbitro= Fachada.getInstance().buscarArbitro(1);
//			
//			Partida partida1= new Partida(mandante1, visitante1, arbitro);
//			rodada1.getPartidas().add(partida1);
//			
//			// 2 Partida ///////////////////////////////////////////////////////
//			Selecao selecaoManante2= Fachada.getInstance().buscarSelecao("EGI");
//			Escalacao mandante2= new Escalacao(selecaoManante2, Escalacao._4_2_4, 
//					new ArrayList<Jogador>(), new ArrayList<Jogador>()); 
//
//			Selecao selecaoVisitante2= Fachada.getInstance().buscarSelecao("ARA");
//			Escalacao visitante2= new Escalacao(selecaoVisitante2, Escalacao._4_4_2, 
//					new ArrayList<Jogador>(), new ArrayList<Jogador>());			
//			
//			Arbitro arbitro2= Fachada.getInstance().buscarArbitro(2);
//			
//			Partida partida2= new Partida(mandante2, visitante2, arbitro2);
//			rodada1.getPartidas().add(partida2);		
//			
//			Fachada.getInstance().inserir(rodada1);
			
			// Listar Rodadas
			System.out.println();
			System.out.println("--------------------------------------");
			System.out.println("  LISTA RODADAS");
			System.out.println("--------------------------------------");			
			Rodada[] rodadas= Fachada.getInstance().listarRodadas();
			for (int i = 0; i < rodadas.length; i++) {
				Rodada rodadaArray = rodadas[i];
				if ( rodadaArray != null ) {
					System.out.println("Rodada: "+ rodadaArray.getNumero());
					
					for( Partida partida: rodadaArray.getPartidas() ) {
						System.out.print( partida.getMandante().getSelecao().getId()+"-"
								+ partida.getMandante().getSelecao().getNome() );
						System.out.println(" X "+ partida.getVisitante().getSelecao().getId()+"-"
								+ partida.getVisitante().getSelecao().getNome() );						
					}
				}
			}
			
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (RegistroNaoEncontradoException e) {
			e.printStackTrace();
		} catch (ArquivoNaoEncontradoException e) {
			e.printStackTrace();
		}

	}
}
