package com.g2t.footline.negocio.entidades;

public class Partida  {

	private Escalacao mandante;
	private Escalacao visitante;
	private int golsMandante;
	private int golsvisitante;
	private float publico;
	private Arbitro arbitro;

	public Partida(Escalacao mandante, Escalacao visitante, Arbitro arbitro) {
		super();
		this.mandante = mandante;
		this.visitante = visitante;
		this.arbitro= arbitro;
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

	public Arbitro getArbitro() {
		return arbitro;
	}
	public void setArbitro(Arbitro arbitro) {
		this.arbitro = arbitro;
	}

	@Override
	public String toString() {
		return "Partida [mandante=" + mandante + ", visitante=" + visitante + ", golsMandante=" + golsMandante
				+ ", golsvisitante=" + golsvisitante + ", publico=" + publico + ", arbitro=" + arbitro + "]";
	}

	
}
