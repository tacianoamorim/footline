package com.g2t.footline.negocio.entidades;

public class Tecnico extends Pessoa {

	public Tecnico() {
		super();
	}

	public Tecnico(int id, String nome) {
		super(id, nome);
	}

	@Override
	public String toString() {
		return "Tecnico [getId()=" + getId() + ", getNome()=" + getNome() + "]";
	}

}
