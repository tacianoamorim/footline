package com.g2t.footline.negocio.entidades;

public class Pessoa {

	private int id;
	private String nome;
	private int nivel;

	public Pessoa() {
		super();
	}
	
	public Pessoa(int id, String nome,int nivel) {
		super();
		this.id = id;
		this.nome = nome;
		this.nivel = nivel;
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

	public int getNivel() {
		return nivel;
	}
	public void setNivel(int Nivel) {
		this.nivel = nivel;
	}
}
