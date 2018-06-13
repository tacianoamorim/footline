package com.g2t.footline.entisade;

import java.io.Serializable;

public class Pessoa implements Serializable {

	/** 
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3351665897713126735L;

	private int id;
	private String nome;
	private int nivel;

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

	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

}
