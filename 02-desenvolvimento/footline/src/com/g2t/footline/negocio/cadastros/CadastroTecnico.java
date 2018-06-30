package com.g2t.footline.negocio.cadastros;

import com.g2t.footline.dados.RepositorioTecnico;
import com.g2t.footline.dados.RepositorioTecnicoArray;
import com.g2t.footline.exception.RegistroNaoEncontradoException;
import com.g2t.footline.negocio.entidades.Tecnico;

public class CadastroTecnico {
	private RepositorioTecnico repositorio;
	private static CadastroTecnico instance;
	
	private CadastroTecnico() {
		repositorio= new RepositorioTecnicoArray();
	}
	
	public static CadastroTecnico getInstance() {
		if ( instance == null )
			instance= new CadastroTecnico();
		return instance;
	}
	
	/**
	 * Lista todos contidos no array de selecoes
	 * 
	 * return Tecnico[]
	 */
	public Tecnico[] listar() {
		return repositorio.listar();
	}
	
	/**
	 * Adiciona um tecnico no array
	 * 
	 * @param Tecnico
	 */
	public void inserir(Tecnico tecnico) {
		repositorio.inserir(tecnico);
	}
	
	/**
	 * Busca um determinado tecnico pelo codigo
	 * 
	 * return Tecnico tecnico
	 * @throws RegistroNaoEncontradoException 
	 */
	public Tecnico buscar(int id) throws RegistroNaoEncontradoException {
		return repositorio.buscar(id);
	}
}
