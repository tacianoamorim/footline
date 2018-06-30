package com.g2t.footline.negocio.entidades;

public class Tecnico extends Pessoa {

	public Tecnico() {
		super();
	}

	public Tecnico(int id, String nome,int nivel) {
		super(id, nome,nivel);
	}

	@Override
	public String toString() {
		return "Tecnico id:" + getId() + "- " + getNome();
	}

}
