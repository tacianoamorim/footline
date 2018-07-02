package com.g2t.footline.negocio.entidades;

/**
 * @author Taciano
 *
 */
public class Estadio {
	private String id;
	private int capacidade;
	private String nome;
	
	public Estadio() {
	}
	
	public Estadio(String id, String nome, int capacidade) {
		super();
		this.id = id;
		this.capacidade = capacidade;
		this.nome = nome;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Estadio " + id + " - " + nome + " (" + capacidade + ")";
	}
	
	
	
}
