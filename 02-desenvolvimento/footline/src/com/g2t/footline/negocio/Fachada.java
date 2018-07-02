package com.g2t.footline.negocio;

import java.io.IOException;

import com.g2t.footline.exception.ArquivoNaoEncontradoException;
import com.g2t.footline.exception.RegistroNaoEncontradoException;
import com.g2t.footline.negocio.cadastros.CadastroArbitro;
import com.g2t.footline.negocio.cadastros.CadastroEstadio;
import com.g2t.footline.negocio.cadastros.CadastroRodada;
import com.g2t.footline.negocio.cadastros.CadastroSelecao;
import com.g2t.footline.negocio.cadastros.CadastroTecnico;
import com.g2t.footline.negocio.entidades.Arbitro;
import com.g2t.footline.negocio.entidades.Estadio;
import com.g2t.footline.negocio.entidades.Rodada;
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
		CadastroSelecao.getInstance().carregar();
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
	 * Busca uma determinada selecao pelo codigo
	 * 
	 * return Selecao selecao
	 * @throws RegistroNaoEncontradoException 
	 */
	public Selecao buscarSelecao(String id) throws RegistroNaoEncontradoException {
		return CadastroSelecao.getInstance().buscar(id);
	}	
	
	/**
	 * Le o arquivo arbitros e carrega o array.
	 * 
	 * @throws ArquivoNaoEncontradoException 
	 */
	public void carregarArbitro() throws ArquivoNaoEncontradoException {
		CadastroArbitro.getInstance().carregar();		
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
	
	/**
	 * Le o arquivo estadios e carrega o array.
	 * 
	 * @throws ArquivoNaoEncontradoException 
	 */
	public void carregarEstadio() throws ArquivoNaoEncontradoException {
		CadastroEstadio.getInstance().carregar();		
	}

	/**
	 * Insere um novo estadio
	 * 
	 * @param Estadio estadio
	 */
	public void inserir(Estadio estadio) {
		CadastroEstadio.getInstance().inserir(estadio);
	}
	
	/**
	 * Lista todos os estadios cadastrados
	 * 
	 * @return Estadio[]
	 */
	public Estadio[] listarEstadio() {
		return CadastroEstadio.getInstance().listar();
	}

	/**
	 * Busca um determinado estadio pelo codigo
	 * 
	 * return Estadio estadio
	 * @throws RegistroNaoEncontradoException 
	 */
	public Estadio buscarEstadio(String id) throws RegistroNaoEncontradoException {
		return CadastroEstadio.getInstance().buscar(id);
	}

	/**
	 * Lista todas as rodadas cadastradas
	 * 
	 * @return Rodada[]
	 */
	public Rodada[] listarRodadas() {
		return CadastroRodada.getInstance().listar();
	}

	/**
	 * Insere uma nova rodada
	 * 
	 * @param Rodada rodada
	 */
	public void inserir(Rodada rodada) {
		CadastroRodada.getInstance().inserir(rodada);
	}	
}
