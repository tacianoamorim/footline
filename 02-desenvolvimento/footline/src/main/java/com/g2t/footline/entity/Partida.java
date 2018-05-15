package com.g2t.footline.entity;

import java.io.Serializable;

public class Partida implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3435984760301390299L;

	private int id;
	private Clube mandante;
	private Clube visitante;
	private float publico;
	private double renda;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Clube getMandante() {
		return mandante;
	}
	public void setMandante(Clube mandante) {
		this.mandante = mandante;
	}

	public Clube getVisitante() {
		return visitante;
	}
	public void setVisitante(Clube visitante) {
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
