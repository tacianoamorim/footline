package com.g2t.footline.entity;

import java.io.Serializable;

public class Agremiacao implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4420078087855186814L;

	private int id;
	private String nome;
	private String acronomo;

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

}
