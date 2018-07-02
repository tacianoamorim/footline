package com.g2t.footline.entisade;

import java.io.Serializable;
import java.util.List;

public class Footline implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1386193044234485161L;

	private String usuario;
	private Clube clubeGerenciado;
	private List<Rodada> rodadas;
	private String nomeJogoSalvo;
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public Clube getClubeGerenciado() {
		return clubeGerenciado;
	}
	public void setClubeGerenciado(Clube clubeGerenciado) {
		this.clubeGerenciado = clubeGerenciado;
	}
	
	public List<Rodada> getRodadas() {
		return rodadas;
	}
	public void setRodadas(List<Rodada> rodadas) {
		this.rodadas = rodadas;
	}
	
	public String getNomeJogoSalvo() {
		return nomeJogoSalvo;
	}
	public void setNomeJogoSalvo(String nomeJogoSalvo) {
		this.nomeJogoSalvo = nomeJogoSalvo;
	}

}
