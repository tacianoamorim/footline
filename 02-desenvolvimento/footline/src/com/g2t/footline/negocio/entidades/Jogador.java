package com.g2t.footline.negocio.entidades;

public class Jogador extends Pessoa {
	
	public static final int GOLEIRO		= 1;
	public static final int DEFESA		= 2;
	public static final int MEIO_CAMPO	= 3;
	public static final int ATAQUE		= 4;
	
	private int posicao;
	private int cartaoAmarelo;
	private boolean cartaoVermelho;
	private int rodadasLesionado;
	private int quantidadeGols;
	private int nivel;
	
	public Jogador() {
		super();
	}
	
	public Jogador(int id, String nome, int posicao) {
		super(id, nome);
		this.posicao = posicao;
	}
	
	public Jogador(int id, String nome, int posicao, int nivel, int cartaoAmarelo, boolean cartaoVermelho,
			int rodadasLesionado, int quantidadeGols) {
		super(id, nome);
		this.posicao = posicao;
		this.nivel = nivel;
		this.cartaoAmarelo = cartaoAmarelo;
		this.cartaoVermelho = cartaoVermelho;
		this.rodadasLesionado = rodadasLesionado;
		this.quantidadeGols = quantidadeGols;
	}

	public int getPosicao() {
		return posicao;
	}
	public void setPosicao(int posicao) {
		this.posicao = posicao;
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
	
	public int getQuantidadeGols() {
		return quantidadeGols;
	}
	public void setQuantidadeGols(int quantidadeGols) {
		this.quantidadeGols = quantidadeGols;
	}
	
	@Override
	public String toString() {
		return "Jogador [id=" + getId() + ", nome=" + getNome() + ", posicao=" + posicao + ", nivel=" + getNivel()
				+ ", cartaoAmarelo=" + cartaoAmarelo + ", cartaoVermelho=" + cartaoVermelho + ", rodadasLesionado="
				+ rodadasLesionado + ", nivel=" + nivel + ", quantidadeGols=" + quantidadeGols + "]";
	}
	
}
