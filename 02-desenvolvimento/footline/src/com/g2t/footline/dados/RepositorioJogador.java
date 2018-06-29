package com.g2t.footline.dados;

import com.g2t.footline.negocio.entidades.Jogador;

public interface RepositorioJogador {
	
	public Jogador buscar(int id);
	public Jogador[] listar();
	public void inserir(Jogador jogador);
	
}
