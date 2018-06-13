package com.g2t.footline.entity;

public class Tecnico extends Pessoa {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 8007507090130395905L;

	public Tecnico() {
		super();
	}

	public Tecnico(int id, String nome) {
		super(id, nome);
	}

	@Override
	public String toString() {
		return "Tecnico [getId()=" + getId() + ", getNome()=" + getNome() + 
				", getNivel()=" + getNivel() + "]";
	}

}
