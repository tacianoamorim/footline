package com.g2t.footline.entity;

import java.io.Serializable;
import java.util.List;

public class Jogo implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1386193044234485161L;

	private List<Rodada> rodadas;
	private String nome;

	public List<Rodada> getRodadas() {
		return rodadas;
	}

	public void setRodadas(List<Rodada> rodadas) {
		this.rodadas = rodadas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
