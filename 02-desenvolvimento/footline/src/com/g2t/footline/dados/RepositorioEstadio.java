package com.g2t.footline.dados;

import java.util.List;

import com.g2t.footline.exception.RegistroNaoEncontradoException;
import com.g2t.footline.negocio.entidades.Estadio;

public interface RepositorioEstadio {
	
	public Estadio buscar(String id) throws RegistroNaoEncontradoException;
	public List<Estadio> listar();
	public void inserir(Estadio estadio);
	
}
