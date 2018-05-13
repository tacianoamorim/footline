package com.g2t.footline.entity;

import java.io.Serializable;

public class Partida implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3435984760301390299L;

	private int id;
	private Time mandante;
	private Time visitante;
	private float publico;
	private double renda;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Time getMandante() {
		return mandante;
	}
	public void setMandante(Time mandante) {
		this.mandante = mandante;
	}

	public Time getVisitante() {
		return visitante;
	}
	public void setVisitante(Time visitante) {
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
