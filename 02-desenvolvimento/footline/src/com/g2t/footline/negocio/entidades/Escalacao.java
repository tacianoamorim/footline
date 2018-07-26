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

	// Andamento Partida
	private List<Jogador> listaCartaoAmarelo = new ArrayList<Jogador>();
	private List<Jogador> listaCartaoVermelho = new ArrayList<Jogador>();
	private List<Jogador> listaLesionado = new ArrayList<Jogador>();
	
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
		return "Escalacao [selecao=" + selecao + ", tatica=" + tatica + ", titulares=" + titulares + ", reservas="
				+ reservas + ", listaCartaoAmarelo=" + listaCartaoAmarelo + ", listaCartaoVermelho="
				+ listaCartaoVermelho + ", listaLesionado=" + listaLesionado + "]";
	}

}