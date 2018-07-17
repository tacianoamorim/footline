package com.g2t.footline.dados;

import java.util.List;

import com.g2t.footline.exception.RegistroNaoEncontradoException;
import com.g2t.footline.negocio.entidades.Tecnico;

public interface RepositorioTecnico {
	
	public Tecnico buscar(int id) throws RegistroNaoEncontradoException;
	public List<Tecnico> listar();
	public void inserir(Tecnico tecnico);
	
}
