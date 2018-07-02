package com.g2t.footline.negocio.entidades;

import java.util.ArrayList;
import java.util.List;

public class Selecao  {

	private String id;
	private String nome;
	private Tecnico tecnico;
	private int nivel;
	private String grupo;
	private List<Jogador> jogadores = new ArrayList<Jogador>();
	
	public Selecao() {
		super();
	}

	public Selecao(String id, String nome, Tecnico tecnico,  
			int nivel, String grupo) {
		super();
		this.id = id;
		this.nome = nome;
		this.tecnico = tecnico;
		this.grupo = grupo;
		this.nivel = nivel;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public Tecnico getTecnico() {
		return tecnico;
	}
	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}
	
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	public List<Jogador> getJogadores() {
		return jogadores;
	}
	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

	@Override
	public String toString() {
		return "Selecao [id=" + id + ", nome=" + nome + ", tecnico=" + tecnico + ", nivel=" + nivel + ", grupo=" + grupo
				+ ", jogadores=" + jogadores + "]";
	}
	
}
