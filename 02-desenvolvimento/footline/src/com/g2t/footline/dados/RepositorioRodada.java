package com.g2t.footline.dados;

import com.g2t.footline.exception.RegistroNaoEncontradoException;
import com.g2t.footline.negocio.entidades.Rodada;

public interface RepositorioRodada {
	
	public Rodada buscar(int numero) throws RegistroNaoEncontradoException;
	public Rodada[] listar();
	public void inserir(Rodada rodada);
	
}
