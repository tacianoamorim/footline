package com.g2t.footline.negocio;

import java.io.IOException;

import com.g2t.footline.negocio.cadastros.CadastroSelecao;

public class Fachada {

	private Fachada instance;

	private Fachada() {
	}
	
	public Fachada getInstance() {
		if ( instance == null ) {
			instance= new Fachada();
		}
		return instance;
	}
	
	/**
	 * Le os arquivos de selecoes e carrega os dados 
	 * 	tecnicos, selecoes e jogadores.
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public void carregarDadosIniciais() throws NumberFormatException, IOException {
		CadastroSelecao.getInstance().carregarDados();
	}
	
}
