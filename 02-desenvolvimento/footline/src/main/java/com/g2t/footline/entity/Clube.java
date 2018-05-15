package com.g2t.footline.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Clube extends BaseEntity implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4420078087855186814L;

	private String acronomo;
	private String tecnico;
	private String nomeEstadio;
	private String nomeArquivo;
	private int nivel;
	private List<Jogador> goleiro = new ArrayList<Jogador>();
	private List<Jogador> defesa = new ArrayList<Jogador>();
	private List<Jogador> meioCampo = new ArrayList<Jogador>();
	private List<Jogador> ataque = new ArrayList<Jogador>();

	public String getAcronomo() {
		return acronomo;
	}
	public void setAcronomo(String acronomo) {
		this.acronomo = acronomo;
	}

	public String getTecnico() {
		return tecnico;
	}
	public void setTecnico(String tecnico) {
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
	
	public List<Jogador> getGoleiro() {
		return goleiro;
	}
	public void setGoleiro(List<Jogador> goleiro) {
		this.goleiro = goleiro;
	}

	public List<Jogador> getDefesa() {
		return defesa;
	}
	public void setDefesa(List<Jogador> defesa) {
		this.defesa = defesa;
	}

	public List<Jogador> getMeioCampo() {
		return meioCampo;
	}
	public void setMeioCampo(List<Jogador> meioCampo) {
		this.meioCampo = meioCampo;
	}

	public List<Jogador> getAtaque() {
		return ataque;
	}
	public void setAtaque(List<Jogador> ataque) {
		this.ataque = ataque;
	}

}
