package com.g2t.footline.negocio.entidades;

public class Jogador extends Pessoa {
	
	public static final String GOLEIRO		= "G";
	public static final String DEFESA		= "D";
	public static final String MEIO_CAMPO	= "M";
	public static final String ATAQUE		= "A";
	
	private String posicao;
	private int cartaoAmarelo;
	private boolean cartaoVermelho;
	private int rodadasLesionado;
	private int quantidadeGols;
	private int nivel;
	private Selecao selecao;
	
	public Jogador() {
		super();
	}
	
	public Jogador(int id, String nome, String posicao) {
		super(id, nome);
		this.posicao = posicao;
	}
	
	public Jogador(int id, String nome, String posicao, int nivel, int cartaoAmarelo, boolean cartaoVermelho,
			int rodadasLesionado, int quantidadeGols) {
		super(id, nome);
		this.posicao = posicao;
		this.nivel = nivel;
		this.cartaoAmarelo = cartaoAmarelo;
		this.cartaoVermelho = cartaoVermelho;
		this.rodadasLesionado = rodadasLesionado;
		this.quantidadeGols = quantidadeGols;
	}

	public String getPosicao() {
		return posicao;
	}
	public void setPosicao(String posicao) {
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
	
	public Selecao getSelecao() {
		return selecao;
	}
	public void setSelecao(Selecao selecao) {
		this.selecao = selecao;
	}

	@Override
	public String toString() {
		return "Jogador [id=" + getId() + ", nome=" + getNome() + ", posicao=" + posicao + ", nivel=" + getNivel()
				+ ", cartaoAmarelo=" + cartaoAmarelo + ", cartaoVermelho=" + cartaoVermelho + ", rodadasLesionado="
				+ rodadasLesionado + ", nivel=" + nivel + ", quantidadeGols=" + quantidadeGols + "]";
	}
	
}
