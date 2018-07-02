package com.g2t.footline.negocio.entidades;

public class Arbitro extends Pessoa {

	private String nacionalidade;
	
	public Arbitro() {
		super();
	}

	public Arbitro(String nome, String nacionalidade) {
		super(0, nome);
		this.nacionalidade= nacionalidade;
	}
	
	public Arbitro(int id, String nome, String nacionalidade) {
		super(id, nome);
		this.nacionalidade= nacionalidade;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	@Override
	public String toString() {
		return "Arbitro " + getId() + " - " + getNome() + 
				" (" + nacionalidade + ")";
	}

}
