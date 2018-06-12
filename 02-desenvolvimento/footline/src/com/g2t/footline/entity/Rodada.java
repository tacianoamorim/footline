package com.g2t.footline.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;


public class Rodada implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 2314058539780934141L;

	private int numero;
	private List<Partida> partidas;
	private boolean finalizada;
	private Calendar data;
		
	public Rodada(int numero, List<Partida> partidas, boolean finalizada, Calendar data) {
		super();
		this.numero = numero;
		this.partidas = partidas;
		this.finalizada = finalizada;
		this.data = data;
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
	
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	
}
