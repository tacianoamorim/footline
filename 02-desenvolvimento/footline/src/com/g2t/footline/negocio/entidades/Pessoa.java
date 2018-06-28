package com.g2t.footline.negocio.entidades;

public class Pessoa {

	private int id;
	private String nome;

	public Pessoa() {
		super();
	}
	
	public Pessoa(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
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

}
