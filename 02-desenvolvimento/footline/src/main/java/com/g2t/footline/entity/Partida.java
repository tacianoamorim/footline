package com.g2t.footline.entity;

import java.io.Serializable;

public class Partida implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3435984760301390299L;

	private Escalacao mandante;
	private Escalacao visitante;
	private float publico;
	private double renda;

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

}
