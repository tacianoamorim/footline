package com.g2t.footline.entity;

import java.io.Serializable;

public class Jogador extends BaseEntity implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3846494530435558253L;
	
	private String posicao;
	private float salario;
	private int cartaoAmarelo;
	private boolean cartaoVermelho;
	private int rodadasLesionado;

	public String getPosicao() {
		return posicao;
	}
	public void setPosicao(String posicao) {
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
}
