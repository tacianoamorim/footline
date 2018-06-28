package com.g2t.footline.negocio.entidades;

public class Arbitro extends Pessoa {

	private int experiencia;
	
	public Arbitro() {
		super();
	}

	public Arbitro(int id, String nome, int experiencia) {
		super(id, nome);
		this.experiencia= experiencia;
	}

	public int getExperiencia() {
		return experiencia;
	}
	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}

	@Override
	public String toString() {
		return "Tecnico [getId()=" + getId() + ", getNome()=" + getNome() + 
				", experiencia=" + experiencia + "]";
	}

}
