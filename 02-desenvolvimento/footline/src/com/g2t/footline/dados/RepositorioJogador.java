package com.g2t.footline.dados;

import com.g2t.footline.exception.RegistroNaoEncontradoException;
import com.g2t.footline.negocio.entidades.Jogador;

public interface RepositorioJogador {
	
	public Jogador buscar(int id) throws RegistroNaoEncontradoException;
	public Jogador[] listar();
	public void inserir(Jogador jogador);
	public void alterar(Jogador jogador) throws RegistroNaoEncontradoException;
	
}
