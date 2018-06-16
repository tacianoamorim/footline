package com.g2t.footline.entity;

public class Jogador extends Pessoa {
	
	static final int GOLEIRO	= 1;
	static final int DEFEZA		= 2;
	static final int MEIO_CAMPO	= 3;
	static final int ATAQUE		= 4;
	
	private int posicao;
	private float salario;
	private int cartaoAmarelo;
	private boolean cartaoVermelho;
	private int rodadasLesionado;
	private double valorPasse;
	private int quantidadeGols;
	
	public Jogador() {
		super();
	}
	
	public Jogador(int id, String nome, int posicao) {
		super(id, nome);
		this.posicao = posicao;
	}
	
	public Jogador(int id, String nome, int posicao, float salario, int cartaoAmarelo, boolean cartaoVermelho,
			int rodadasLesionado, double valorPasse, int quantidadeGols) {
		super(id, nome);
		this.posicao = posicao;
		this.salario = salario;
		this.cartaoAmarelo = cartaoAmarelo;
		this.cartaoVermelho = cartaoVermelho;
		this.rodadasLesionado = rodadasLesionado;
		this.valorPasse = valorPasse;
		this.quantidadeGols = quantidadeGols;
	}

	public int getPosicao() {
		return posicao;
	}
	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}
	
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
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
		return "Jogador [id=" + getId() + ", nome=" + getNome() + ", posicao=" + posicao + ", salario=" + salario + ", nivel=" + getNivel()
				+ ", cartaoAmarelo=" + cartaoAmarelo + ", cartaoVermelho=" + cartaoVermelho + ", rodadasLesionado="
				+ rodadasLesionado + ", valorPasse=" + valorPasse + ", quantidadeGols=" + quantidadeGols + "]";
	}
	
}
