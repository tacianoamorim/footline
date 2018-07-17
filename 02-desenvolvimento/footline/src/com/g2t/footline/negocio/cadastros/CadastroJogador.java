package com.g2t.footline.negocio.cadastros;

import java.util.List;

import com.g2t.footline.dados.RepositorioJogador;
import com.g2t.footline.dados.RepositorioJogadorLista;
import com.g2t.footline.exception.RegistroNaoEncontradoException;
import com.g2t.footline.negocio.entidades.Jogador;
import com.g2t.footline.negocio.entidades.Selecao;

public class CadastroJogador {
	private RepositorioJogador repositorio;
	private static CadastroJogador instance;
	
	private CadastroJogador() {
		repositorio= new RepositorioJogadorLista();
	}
	
	public static CadastroJogador getInstance() {
		if ( instance == null )
			instance= new CadastroJogador();
		return instance;
	}
	
	public Jogador buscar(int id) throws RegistroNaoEncontradoException {
		return repositorio.buscar(id);
	}
	
	public List<Jogador> listar() {
		return repositorio.listar(null);
	}
	
	public void inserir(Jogador jogador) {
		repositorio.inserir(jogador);
	}
	
	public void alterar(Jogador jogador) throws RegistroNaoEncontradoException {
		repositorio.alterar(jogador);
	}
	
	public List<Jogador> listar(Selecao selecao) {
		return repositorio.listar(selecao);
	}	
	
}
