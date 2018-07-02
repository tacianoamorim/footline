package com.g2t.footline.negocio.cadastros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.g2t.footline.dados.RepositorioRodada;
import com.g2t.footline.dados.RepositorioRodadaArray;
import com.g2t.footline.exception.ArquivoNaoEncontradoException;
import com.g2t.footline.exception.RegistroNaoEncontradoException;
import com.g2t.footline.negocio.entidades.Rodada;
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

}
