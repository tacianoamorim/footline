package com.g2t.footline.entisade;

import java.io.Serializable;

public class Partida implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3435984760301390299L;

	private Escalacao mandante;
	private Escalacao visitante;
	private int golsMandante;
	private int golsvisitante;
	private float publico;
	private double renda;

	public Partida(Escalacao mandante, Escalacao visitante) {
		super();
		this.mandante = mandante;
		this.visitante = visitante;
	}
	
	public Escalacao getMandante() {
		return mandante;
	}
	public void setMandante(Escalacao mandante) {
		this.mandante = mandante;
	}

	public Escalacao getVisitante() {
		return visitante;
	}
	public void setVisitante(Escalacao visitante) {
		this.visitante = visitante;
	}
	
	public int getGolsMandante() {
		return golsMandante;
	}
	public void setGolsMandante(int golsMandante) {
		this.golsMandante = golsMandante;
	}
	
	public int getGolsvisitante() {
		return golsvisitante;
	}
	public void setGolsvisitante(int golsvisitante) {
		this.golsvisitante = golsvisitante;
	}
	
	public float getPublico() {
		return publico;
	}
	public void setPublico(float publico) {
		this.publico = publico;
	}

	public double getRenda() {
		return renda;
	}
	public void setRenda(double renda) {
		this.renda = renda;
	}
	
	@Override
	public String toString() {
		return "Partida [mandante=" + mandante + ", visitante=" + visitante + ", golsMandante=" + golsMandante
				+ ", golsvisitante=" + golsvisitante + ", publico=" + publico + ", renda=" + renda + "]";
	}
	
}
