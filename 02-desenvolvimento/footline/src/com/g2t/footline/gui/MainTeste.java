package com.g2t.footline.gui;

public class MainTeste {

	public static void main(String[] args) {
//		try {
//			/*
//			 * Le os arquivos de selecoes e carrega os 
//			 * 	array de selecao e jogador
//			 */
//			Fachada.getInstance().carregarSelecaoJogador();
//			
//			// Carrega o array de arbitro
//			Fachada.getInstance().carregarArbitro();
//			
//			// Listar arbitros
//			System.out.println("--------------------------------------");
//			System.out.println("  LISTA ARBITROS");
//			System.out.println("--------------------------------------");
//			Arbitro[] arbitros= Fachada.getInstance().listarArbitro();
//			for (int i = 0; i < arbitros.length; i++) {
//				Arbitro arbitro = arbitros[i];
//				if ( arbitro != null )
//					System.out.println(arbitro);
//			}
//			
//			// Busca o arbitro pelo codigo 
//			System.out.println();
//			System.out.print("Busca arbitro codigo 11 =>");
//			System.out.println(Fachada.getInstance().buscarArbitro(11));
//			System.out.print("Busca arbitro codigo 22 =>");
//			System.out.println(Fachada.getInstance().buscarArbitro(22));			
//			
//			// Carrega o array de estadio
//			Fachada.getInstance().carregarEstadio();	
//			
//			// Listar estadios
//			System.out.println("--------------------------------------");
//			System.out.println("  LISTA ESTADIOS");
//			System.out.println("--------------------------------------");
//			Estadio[] estadios= Fachada.getInstance().listarEstadio();
//			for (int i = 0; i < estadios.length; i++) {
//				Estadio estadio = estadios[i];
//				if ( estadio != null )
//					System.out.println(estadio);
//			}			
//			
//			// Busca o estadio pelo codigo 
//			System.out.println();
//			System.out.print("Busca estadio codigo SAR =>");
//			System.out.println(Fachada.getInstance().buscarEstadio("SAR"));
//			
//			// Listar tecnicos
//			System.out.println("--------------------------------------");
//			System.out.println("  LISTA TECNICOS");
//			System.out.println("--------------------------------------");
//			Tecnico[] tecnicos= Fachada.getInstance().listarTecnicos();
//			for (int i = 0; i < tecnicos.length; i++) {
//				Tecnico tecnico = tecnicos[i];
//				if ( tecnico != null )
//					System.out.println(tecnico);
//			}
//			
//			// Busca o tecnico pelo codigo 
//			System.out.println();
//			System.out.print("Busca tecnico codigo 10 =>");
//			System.out.println(Fachada.getInstance().buscarTecnico(10));
//			System.out.print("Busca tecnico codigo 20 =>");
//			System.out.println(Fachada.getInstance().buscarTecnico(20));			
//			
//			// Listar Selecoes e jogadores
//			System.out.println();
//			System.out.println("--------------------------------------");
//			System.out.println("  LISTA SELECOES E SEUS JOGADORES");
//			System.out.println("--------------------------------------");			
//			Selecao[] selecoes= Fachada.getInstance().listarSelecoes();
//			for (int i = 0; i < selecoes.length; i++) {
//				Selecao selecao = selecoes[i];
//				if ( selecao != null ) {
//					System.out.println("Selecao: "+ selecao.getId()
//					+ "- " + selecao.getNome() );
//					// Lista jogadores
//					for( Jogador jogador: selecao.getJogadores() ) {
//						System.out.println("   -> "+ jogador.getPosicao()
//								+": "+ jogador.getId()
//								+"- "+ jogador.getNome() 
//								+"- "+ jogador.getNivel() );
//					}		
//				}
//			}
//			
//			// Cadastro das rodadas
//			System.out.println();
//			System.out.println("--------------------------------------");
//			System.out.println("  CADASTRO DAS RODADAS ");
//			System.out.println("--------------------------------------");			
//			Fachada.getInstance().carregarRodadas();
//			
//			// Listar Rodadas
//			System.out.println();
//			System.out.println("--------------------------------------");
//			System.out.println("  LISTA RODADAS");
//			System.out.println("--------------------------------------");			
//			Rodada[] rodadas= Fachada.getInstance().listarRodadas();
//			for (int i = 0; i < rodadas.length; i++) {
//				Rodada rodadaArray = rodadas[i];
//				if ( rodadaArray != null ) {
//					System.out.println("Rodada: "+ rodadaArray.getNumero()
//					+ "- "+ rodadaArray.getDescricao());
//					
//					for( Partida partida: rodadaArray.getPartidas() ) {
//						System.out.println(
//								"   "+ partida.getMandante().getSelecao().getNome() 
//								+ " X "+ 
//								partida.getVisitante().getSelecao().getNome() 
//								+" ("+ partida.getEstadio().getNome() +") "
//						);						
//					}
//				}
//			}
//			
//		} catch (NumberFormatException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (RegistroNaoEncontradoException e) {
//			e.printStackTrace();
//		} catch (ArquivoNaoEncontradoException e) {
//			e.printStackTrace();
//		}

	}
}