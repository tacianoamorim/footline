package com.g2t.footline.dados;

import java.util.List;

import com.g2t.footline.exception.RegistroNaoEncontradoException;
import com.g2t.footline.negocio.entidades.Arbitro;

public interface RepositorioArbitro {
	
	public Arbitro buscar(int id) throws RegistroNaoEncontradoException;
	public List<Arbitro> listar();
	public void inserir(Arbitro arbitro);
	
}
