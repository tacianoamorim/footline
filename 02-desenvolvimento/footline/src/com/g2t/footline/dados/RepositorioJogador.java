package com.g2t.footline.dados;

import java.util.List;

import com.g2t.footline.exception.RegistroNaoEncontradoException;
import com.g2t.footline.negocio.entidades.Jogador;
import com.g2t.footline.negocio.entidades.Selecao;

public interface RepositorioJogador {
	
	public Jogador buscar(int id) throws RegistroNaoEncontradoException;
	public Jogador buscarPorNome(String nome) throws RegistroNaoEncontradoException;
	public List<Jogador> listar(Selecao selecao);
	public void inserir(Jogador jogador);
	public void alterar(Jogador jogador) throws RegistroNaoEncontradoException;
	
}
