package com.g2t.footline.entity;

import java.util.ArrayList;
import java.util.List;

public class Escalacao{
	
	static final int _4_4_2	= 1;
	static final int _4_2_4	= 2;
	static final int _4_5_1	= 3;
	static final int _4_3_3	= 4;	
	static final int _5_4_1	= 5;	
	static final int _5_3_2	= 6;

	private Clube clube;
	private int tatica;

	// Titular
	private List<Jogador> titulares = new ArrayList<Jogador>();

	// Reservas
	private List<Jogador> reservas = new ArrayList<Jogador>();

	// Andamento Partida
	private List<Jogador> listaCartaoAmarelo = new ArrayList<Jogador>();
	private List<Jogador> listaCartaoVermelho = new ArrayList<Jogador>();
	private List<Jogador> listaLesionado = new ArrayList<Jogador>();
	
	public Escalacao(Clube clube, int tatica, List<Jogador> titulares, List<Jogador> reservas) {
		super();
		this.clube = clube;
		this.tatica = tatica;
		this.titulares = titulares;
		this.reservas = reservas;
	}


	public Clube getClube() {
		return clube;
	}
	public void setClube(Clube clube) {
		this.clube = clube;
	}
	
	public int getTatica() {
		return tatica;
	}
	public void setTatica(int tatica) {
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
	
	public List<Jogador> getListaCartaoAmarelo() {
		return listaCartaoAmarelo;
	}
	public void setListaCartaoAmarelo(List<Jogador> listaCartaoAmarelo) {
		this.listaCartaoAmarelo = listaCartaoAmarelo;
	}
	
	public List<Jogador> getListaCartaoVermelho() {
		return listaCartaoVermelho;
	}
	public void setListaCartaoVermelho(List<Jogador> listaCartaoVermelho) {
		this.listaCartaoVermelho = listaCartaoVermelho;
	}
	
	public List<Jogador> getListaLesionado() {
		return listaLesionado;
	}
	public void setListaLesionado(List<Jogador> listaLesionado) {
		this.listaLesionado = listaLesionado;
	}


	@Override
	public String toString() {
		return "Escalacao [clube=" + clube + ", tatica=" + tatica + ", titulares=" + titulares + ", reservas="
				+ reservas + ", listaCartaoAmarelo=" + listaCartaoAmarelo + ", listaCartaoVermelho="
				+ listaCartaoVermelho + ", listaLesionado=" + listaLesionado + "]";
	}

}