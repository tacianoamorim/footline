package com.g2t.footline.entity;

import java.io.Serializable;
import java.util.List;

public class Jogo implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1386193044234485161L;

	private String usuario;
	private List<Rodada> rodadas;
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public List<Rodada> getRodadas() {
		return rodadas;
	}
	public void setRodadas(List<Rodada> rodadas) {
		this.rodadas = rodadas;
	}

}
