package com.g2t.footline.negocio.entidades;

import java.util.ArrayList;
import java.util.List;

public class Escalacao{
	
	private Selecao selecao;
	private Tatica tatica;
	// Titular
	private List<Jogador> titulares = new ArrayList<Jogador>();
	// Reservas
	private List<Jogador> reservas = new ArrayList<Jogador>();

	public Escalacao() {
	}
	
	public Escalacao(Selecao selecao, Tatica tatica, 
			List<Jogador> titulares, List<Jogador> reservas) {
		super();
		this.selecao = selecao;
		this.tatica = tatica;
		this.titulares = titulares;
		this.reservas = reservas;
	}

	public Selecao getSelecao() {
		return selecao;
	}
	public void setSelecao(Selecao selecao) {
		this.selecao = selecao;
	}
	
	public Tatica getTatica() {
		return tatica;
	}
	public void setTatica(Tatica tatica) {
		this.tatica = tatica;
	}
	
	public List<Jogador> getTitulares() {
		return titulares;
	}
	public void setTitulares(List<Jogador> titulares) {
		this.titulares = titulares;
	}
	
	public List<Jogador> getReservas() {
		return reservas;
	}
	public void setReservas(List<Jogador> reservas) {
		this.reservas = reservas;
	}

	@Override
	public String toString() {
		return "Escalacao [selecao=" + selecao + ", tatica=" + tatica + ", titulares=" + titulares + ", reservas="
				+ reservas + "]";
	}

}