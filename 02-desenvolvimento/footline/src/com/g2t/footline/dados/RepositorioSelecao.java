package com.g2t.footline.dados;

import com.g2t.footline.exception.RegistroNaoEncontradoException;
import com.g2t.footline.negocio.entidades.Selecao;

public interface RepositorioSelecao {

	public Selecao buscar(int id) throws RegistroNaoEncontradoException;
	public void inserir(Selecao selecao);
	public Selecao[] listar();
	public void alterar(Selecao selecao) throws RegistroNaoEncontradoException;
	
}
