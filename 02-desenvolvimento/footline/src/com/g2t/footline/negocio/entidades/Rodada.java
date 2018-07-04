package com.g2t.footline.negocio.entidades;

import java.util.Calendar;
import java.util.List;

public class Rodada {

	private int numero;
	private String descricao;
	private List<Partida> partidas;
	private boolean finalizada;
		
	public Rodada() {
	}
	
	public Rodada(int numero, String descricao, boolean finalizada) {
		super();
		this.numero = numero;
		this.finalizada = finalizada;
		this.descricao = descricao;
	}
	
	public Rodada(int numero, String descricao, List<Partida> partidas, boolean finalizada) {
		super();
		this.numero = numero;
		this.partidas = partidas;
		this.finalizada = finalizada;
		this.descricao = descricao;
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}

	public List<Partida> getPartidas() {
		return partidas;
	}
	public void setPartidas(List<Partida> partidas) {
		this.partidas = partidas;
	}

	public boolean isFinalizada() {
		return finalizada;
	}
	public void setFinalizada(boolean finalizada) {
		this.finalizada = finalizada;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Rodada " + numero + "- " + descricao +"["+ finalizada 
				+ "] ";
	}
	
}
