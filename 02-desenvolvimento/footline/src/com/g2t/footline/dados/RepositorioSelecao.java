package com.g2t.footline.dados;

import com.g2t.footline.negocio.entidades.Selecao;

public interface RepositorioSelecao {

	public Selecao buscar(int id);
	public void inserir(Selecao selecao);
	public Selecao[] listar();
	
}
