package com.g2t.footline.dados;

import com.g2t.footline.exception.RegistroNaoEncontradoException;
import com.g2t.footline.negocio.entidades.Arbitro;

public interface RepositorioArbitro {
	
	public void carregarDados();
	public Arbitro buscar(int id) throws RegistroNaoEncontradoException;
	public Arbitro[] listar();
	
}
