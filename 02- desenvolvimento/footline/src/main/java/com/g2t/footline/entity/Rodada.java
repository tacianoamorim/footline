package com.g2t.footline.entity;

import java.io.Serializable;
import java.util.List;


public class Rodada implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 2314058539780934141L;

	private int numero;
	private List<Partida> partidas;

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

}
