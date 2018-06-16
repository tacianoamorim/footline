package com.g2t.footline.entity;

import java.util.List;

/**
 * @author tlamo
 *
 */
public class Footline {

	private String usuario;
	private Clube clubeGerenciado;
	private List<Rodada> rodadas;
	private String nomeJogoSalvo;
	
	public Footline() {
		super();
	}

	public Footline(String usuario, Clube clubeGerenciado, List<Rodada> rodadas, String nomeJogoSalvo) {
		super();
		this.usuario = usuario;
		this.clubeGerenciado = clubeGerenciado;
		this.rodadas = rodadas;
		this.nomeJogoSalvo = nomeJogoSalvo;
	}
	
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

	@Override
	public String toString() {
		return "Footline [usuario=" + usuario + ", clubeGerenciado=" + clubeGerenciado + ", rodadas=" + rodadas
				+ ", nomeJogoSalvo=" + nomeJogoSalvo + "]";
	}
	
}
