package com.g2t.footline.negocio.cadastros;

import com.g2t.footline.dados.RepositorioArbitro;
import com.g2t.footline.dados.RepositorioArbitroArray;
import com.g2t.footline.exception.RegistroNaoEncontradoException;
import com.g2t.footline.negocio.entidades.Arbitro;

public class CadastroArbitro {
	private RepositorioArbitro repositorio;
	private static CadastroArbitro instance;
	
	private CadastroArbitro() {
		repositorio= new RepositorioArbitroArray();
	}
	
	public static CadastroArbitro getInstance() {
		if ( instance == null )
			instance= new CadastroArbitro();
		return instance;
	}
	
	/**
	 * Busca um determinado arbitro pelo codigo
	 * 
	 * return Arbitro arbitro
	 * @throws RegistroNaoEncontradoException 
	 */
	public Arbitro buscar(int id) throws RegistroNaoEncontradoException {
		return repositorio.buscar(id);
	}
	
	
	/**
	 * Lista todos contidos no array
	 * 
	 * return Arbitro[]
	 */
	public Arbitro[] listar() {
		return repositorio.listar();
	}	
	
}
