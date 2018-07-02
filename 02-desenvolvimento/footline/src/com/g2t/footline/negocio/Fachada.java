package com.g2t.footline.negocio;

import java.io.IOException;

import com.g2t.footline.exception.ArquivoNaoEncontradoException;
import com.g2t.footline.exception.RegistroNaoEncontradoException;
import com.g2t.footline.negocio.cadastros.CadastroArbitro;
import com.g2t.footline.negocio.cadastros.CadastroSelecao;
import com.g2t.footline.negocio.cadastros.CadastroTecnico;
import com.g2t.footline.negocio.entidades.Arbitro;
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
	 * 
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public void carregarSelecaoJogador() 
			throws NumberFormatException, IOException {
		CadastroSelecao.getInstance().carregarDados();
	}
	
	/**
	 * Retorna a lista de selecoes cadastradas
	 * 
	 * @return Selecao[]
	 */
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
	
	/**
	 * Insere um novo tecnico
	 * @param Tecnico tecnico
	 */
	public void inserir(Tecnico tecnico) {
		CadastroTecnico.getInstance().inserir(tecnico);
	}
	
	/**
	 * Insere uma nova selecao
	 * @param Selecao selecao
	 */
	public void inserir(Selecao selecao) {
		CadastroSelecao.getInstance().inserir(selecao);
	}	
	
	/**
	 * Le o arquivo estadios e carrega o array.
	 * 
	 * @throws ArquivoNaoEncontradoException 
	 */
	public void carregarArbitro() throws ArquivoNaoEncontradoException {
		CadastroArbitro.getInstance().carregarArbitro();		
	}

	/**
	 * Insere um novo arbitro
	 * 
	 * @param Arbitro arbitro
	 */
	public void inserir(Arbitro arbitro) {
		CadastroArbitro.getInstance().inserir(arbitro);
	}
	
	/**
	 * Lista todos os arbitros cadastrados
	 * 
	 * @return Arbitro[]
	 */
	public Arbitro[] listarArbitro() {
		return CadastroArbitro.getInstance().listar();
	}

	/**
	 * Busca um determinado arbitro pelo codigo
	 * 
	 * return Arbitro arbitro
	 * @throws RegistroNaoEncontradoException 
	 */
	public Arbitro buscarArbitro(int id) throws RegistroNaoEncontradoException {
		return CadastroArbitro.getInstance().buscar(id);
	}
}
