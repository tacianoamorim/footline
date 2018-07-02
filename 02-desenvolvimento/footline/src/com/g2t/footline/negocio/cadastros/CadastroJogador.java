package com.g2t.footline.negocio.cadastros;

import com.g2t.footline.dados.RepositorioJogador;
import com.g2t.footline.dados.RepositorioJogadorArray;
import com.g2t.footline.exception.RegistroNaoEncontradoException;
import com.g2t.footline.negocio.entidades.Jogador;

public class CadastroJogador {
	private RepositorioJogador repositorio;
	private static CadastroJogador instance;
	
	private CadastroJogador() {
		repositorio= new RepositorioJogadorArray();
	}
	
	public static CadastroJogador getInstance() {
		if ( instance == null )
			instance= new CadastroJogador();
		return instance;
	}
	
	public Jogador buscar(int id) throws RegistroNaoEncontradoException {
		return repositorio.buscar(id);
	}
	
	public Jogador[] listar() {
		return repositorio.listar();
	}
	
	public void inserir(Jogador jogador) {
		repositorio.inserir(jogador);
	}
	
	public void alterar(Jogador jogador) throws RegistroNaoEncontradoException {
		repositorio.alterar(jogador);
	}
	
}
