package com.g2t.footline.dados;

import java.util.List;

import com.g2t.footline.exception.RegistroNaoEncontradoException;
import com.g2t.footline.negocio.entidades.Selecao;

public interface RepositorioSelecao {

	public Selecao buscar(String id) throws RegistroNaoEncontradoException;
	public Selecao buscarPorNome(String nome) throws RegistroNaoEncontradoException;
	public void inserir(Selecao selecao);
	public List<Selecao> listar();
	public void alterar(Selecao selecao) throws RegistroNaoEncontradoException;
	
}
