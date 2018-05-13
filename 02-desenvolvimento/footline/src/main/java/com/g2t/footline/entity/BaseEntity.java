package com.g2t.footline.entity;

import java.io.Serializable;

public class BaseEntity implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3351665897713126735L;

	private int id;
	private String nome;

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
