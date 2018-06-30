package com.g2t.footline.gui;

import java.io.IOException;

import com.g2t.footline.exception.RegistroNaoEncontradoException;
import com.g2t.footline.negocio.Fachada;
import com.g2t.footline.negocio.entidades.Jogador;
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
			//Fachada.getInstance().carregarArbitro();
			
			// Carrega o array de estadio
			//Fachada.getInstance().carregarEstadio();	
			
			// Listar estadios
			
			// Listar arbitros
			
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
								+"- "+ jogador.getNome() );
					}		
				}
			}			
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (RegistroNaoEncontradoException e) {
			e.printStackTrace();
		}

	}
}
