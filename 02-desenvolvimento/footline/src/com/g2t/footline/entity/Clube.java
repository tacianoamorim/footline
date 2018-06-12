package com.g2t.footline.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Taciano
 *
 */
public class Clube implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4420078087855186814L;

	private int id;
	private String nome;
	private String acronomo;
	private Tecnico tecnico;
	private String nomeEstadio;
	private String nomeArquivo;
	private int nivel;
	private int capacidade;
	private List<Jogador> jogadores = new ArrayList<Jogador>();
	private double valorCaixa;

	
	public Clube() {
		super();
	}

	public Clube(int id, String nome, String acronomo, Tecnico tecnico, String nomeEstadio, String nomeArquivo,
			int nivel, int capacidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.acronomo = acronomo;
		this.tecnico = tecnico;
		this.nomeEstadio = nomeEstadio;
		this.nomeArquivo = nomeArquivo;
		this.nivel = nivel;
		this.capacidade = capacidade;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getAcronomo() {
		return acronomo;
	}
	public void setAcronomo(String acronomo) {
		this.acronomo = acronomo;
	}

	public Tecnico getTecnico() {
		return tecnico;
	}
	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}
	
	public String getNomeEstadio() {
		return nomeEstadio;
	}
	public void setNomeEstadio(String nomeEstadio) {
		this.nomeEstadio = nomeEstadio;
	}
	
	public String getNomeArquivo() {
		return nomeArquivo;
	}
	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}
	
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	
	public List<Jogador> getJogadores() {
		return jogadores;
	}
	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}
	
	public double getValorCaixa() {
		return valorCaixa;
	}
	public void setValorCaixa(double valorCaixa) {
		this.valorCaixa = valorCaixa;
	}
	
	@Override
	public String toString() {
		return "Clube [id=" + id + ", nome=" + nome + ", acronomo=" + acronomo 
				+ ", tecnico=" + tecnico + ", nomeEstadio=" + nomeEstadio
				+ ", nomeArquivo=" + nomeArquivo + ", nivel=" + nivel 
				+ ", jogadores=" + jogadores
				+ ", valorCaixa=" + valorCaixa + "]";
	}
	
}
