package com.g2t.footline.entisade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Escalacao implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3007054268103393445L;

	private Clube clube;
	private Tatica tatica;

	// Titular
	private List<Jogador> titulares = new ArrayList<Jogador>();

	// Reservas
	private List<Jogador> reservas = new ArrayList<Jogador>();

	// Andamento Partida
	private List<Jogador> listaCartaoAmarelo = new ArrayList<Jogador>();
	private List<Jogador> listaCartaoVermelho = new ArrayList<Jogador>();
	private List<Jogador> listaLesionado = new ArrayList<Jogador>();
	
	public Escalacao() {
		super();
	}

	public Escalacao(Clube clube, Tatica tatica, List<Jogador> titulares, List<Jogador> reservas) {
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

}