package com.g2t.footline.dados;

import java.util.List;

import com.g2t.footline.exception.RegistroNaoEncontradoException;
import com.g2t.footline.negocio.entidades.Partida;
import com.g2t.footline.negocio.entidades.Rodada;

public interface RepositorioRodada {
	
	public Rodada buscar(int numero) throws RegistroNaoEncontradoException;
	public List<Rodada> listar(Integer numero);
	public List<Rodada> listar();
	public void inserir(Rodada rodada);
	public void atualizar(Rodada rodada);
	public Partida buscarPartida(int numero) throws RegistroNaoEncontradoException;
	
}
