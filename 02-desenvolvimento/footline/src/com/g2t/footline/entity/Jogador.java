package com.g2t.footline.entity;

import java.io.Serializable;

public class Jogador extends Pessoa implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3846494530435558253L;
	
	private Posicao posicao;
	private float salario;
	private int nivel;
	private int cartaoAmarelo;
	private boolean cartaoVermelho;
	private int rodadasLesionado;
	private double valorPasse;
	private int quantidadeGols;
	
	public Jogador() {
		super();
	}
	
	public Jogador(int id, String nome, Posicao posicao) {
		super(id, nome);
		this.posicao = posicao;
	}

	public Posicao getPosicao() {
		return posicao;
	}
	public void setPosicao(Posicao posicao) {
		this.posicao = posicao;
	}
	
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	public int getCartaoAmarelo() {
		return cartaoAmarelo;
	}
	public void setCartaoAmarelo(int cartaoAmarelo) {
		this.cartaoAmarelo = cartaoAmarelo;
	}
	
	public boolean isCartaoVermelho() {
		return cartaoVermelho;
	}
	public void setCartaoVermelho(boolean cartaoVermelho) {
		this.cartaoVermelho = cartaoVermelho;
	}
	
	public int getRodadasLesionado() {
		return rodadasLesionado;
	}
	public void setRodadasLesionado(int rodadasLesionado) {
		this.rodadasLesionado = rodadasLesionado;
	}
	
	public double getValorPasse() {
		return valorPasse;
	}
	public void setValorPasse(double valorPasse) {
		this.valorPasse = valorPasse;
	}
	
	public int getQuantidadeGols() {
		return quantidadeGols;
	}
	public void setQuantidadeGols(int quantidadeGols) {
		this.quantidadeGols = quantidadeGols;
	}
	
	@Override
	public String toString() {
		return "Jogador [id=" + getId() + ", nome=" + getNome() + ", posicao=" + posicao + ", salario=" + salario + ", nivel=" + nivel
				+ ", cartaoAmarelo=" + cartaoAmarelo + ", cartaoVermelho=" + cartaoVermelho + ", rodadasLesionado="
				+ rodadasLesionado + ", valorPasse=" + valorPasse + ", quantidadeGols=" + quantidadeGols + "]";
	}
	
}
