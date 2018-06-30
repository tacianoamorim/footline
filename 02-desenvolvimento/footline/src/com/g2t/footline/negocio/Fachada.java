package com.g2t.footline.negocio;

import java.io.IOException;

import com.g2t.footline.exception.RegistroNaoEncontradoException;
import com.g2t.footline.negocio.cadastros.CadastroSelecao;
import com.g2t.footline.negocio.cadastros.CadastroTecnico;
import com.g2t.footline.negocio.entidades.Selecao;
import com.g2t.footline.negocio.entidades.Tecnico;

public class Fachada {

	private static Fachada instance;

	private Fachada() {
	}
	
	public static Fachada getInstance() {
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
	public void carregarSelecaoJogador() 
			throws NumberFormatException, IOException {
		CadastroSelecao.getInstance().carregarDados();
	}
	
	public Selecao[] listarSelecoes() {
		return CadastroSelecao.getInstance().listar();
	}

	/**
	 * Lista todos os tecnicos cadastrados
	 * 
	 * @return Tecnico[]
	 */
	public Tecnico[] listarTecnicos() {
		return CadastroTecnico.getInstance().listar();
	}
	
	/**
	 * Busca um determinado tecnico pelo codigo
	 * 
	 * return Tecnico tecnico
	 * @throws RegistroNaoEncontradoException 
	 */
	public Tecnico buscarTecnico(int id) throws RegistroNaoEncontradoException {
		return CadastroTecnico.getInstance().buscar(id);
	}
}
