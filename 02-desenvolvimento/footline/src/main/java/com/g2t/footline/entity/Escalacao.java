package com.g2t.footline.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Escalacao implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3007054268103393445L;

	private Clube time;

	// Titular
	private Jogador goleiro;
	private Tatica tatica;
	private List<Jogador> listaTitularDefesa = new ArrayList<Jogador>();
	private List<Jogador> listaTitularMeioCampo = new ArrayList<Jogador>();
	private List<Jogador> listaTitularAtaque = new ArrayList<Jogador>();

	// Reservas
	private List<Jogador> listaReservaGoleiro = new ArrayList<Jogador>();
	private List<Jogador> listaReservaDefesa = new ArrayList<Jogador>();
	private List<Jogador> listaReservaMeioCampo = new ArrayList<Jogador>();
	private List<Jogador> listaReservaAtaque = new ArrayList<Jogador>();

	// Andamento Partida
	private List<Jogador> listaCartaoAmarelo = new ArrayList<Jogador>();
	private List<Jogador> listaCartaoVermelho = new ArrayList<Jogador>();
	private List<Jogador> listaLesionado = new ArrayList<Jogador>();

	public Clube getTime() {
		return time;
	}
	public void setTime(Clube time) {
		this.time = time;
	}

	public Tatica getTatica() {
		return tatica;
	}
	public void setTatica(Tatica tatica) {
		this.tatica = tatica;
	}
	
	public Jogador getGoleiro() {
		return goleiro;
	}
	public void setGoleiro(Jogador goleiro) {
		this.goleiro = goleiro;
	}

	public List<Jogador> getListaTitularDefesa() {
		return listaTitularDefesa;
	}

	public void setListaTitularDefesa(List<Jogador> listaTitularDefesa) {
		this.listaTitularDefesa = listaTitularDefesa;
	}

	public List<Jogador> getListaTitularMeioCampo() {
		return listaTitularMeioCampo;
	}

	public void setListaTitularMeioCampo(List<Jogador> listaTitularMeioCampo) {
		this.listaTitularMeioCampo = listaTitularMeioCampo;
	}

	public List<Jogador> getListaTitularAtaque() {
		return listaTitularAtaque;
	}

	public void setListaTitularAtaque(List<Jogador> listaTitularAtaque) {
		this.listaTitularAtaque = listaTitularAtaque;
	}

	public List<Jogador> getListaReservaGoleiro() {
		return listaReservaGoleiro;
	}

	public void setListaReservaGoleiro(List<Jogador> listaReservaGoleiro) {
		this.listaReservaGoleiro = listaReservaGoleiro;
	}

	public List<Jogador> getListaReservaDefesa() {
		return listaReservaDefesa;
	}

	public void setListaReservaDefesa(List<Jogador> listaReservaDefesa) {
		this.listaReservaDefesa = listaReservaDefesa;
	}

	public List<Jogador> getListaReservaMeioCampo() {
		return listaReservaMeioCampo;
	}

	public void setListaReservaMeioCampo(List<Jogador> listaReservaMeioCampo) {
		this.listaReservaMeioCampo = listaReservaMeioCampo;
	}

	public List<Jogador> getListaReservaAtaque() {
		return listaReservaAtaque;
	}

	public void setListaReservaAtaque(List<Jogador> listaReservaAtaque) {
		this.listaReservaAtaque = listaReservaAtaque;
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