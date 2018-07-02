package com.g2t.footline.negocio.entidades;

public class Clube extends Tecnico{

		private int id;
		private String nome;
		private int nivel;
		private String acronomo;
		private String nomeEstadio;
		private String nomeArquivo;
		private int capacidade;
		private double valorCaixa;
		
		
		public Clube() {
			super();
		}

		public Clube(int id, String nome, int nivel) {
			super(id, nome, nivel);
		}

		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		
		public int getNivel() {
			return nivel;
		}
		public void setNivel(int nivel) {
			this.nivel = nivel;
		}
		
		public String getAcronomo() {
			return acronomo;
		}
		public void setAcronomo(String acronomo) {
			this.acronomo = acronomo;
		}
		
		
		public String getNomeEstadio() {
			return nomeEstadio;
		}
		public void setNomeEstadio(String nomeEstadio) {
			this.nomeEstadio = nomeEstadio;
		}

		public String getNomeArquivo() {
			return nomeArquivo;
		}
		public void setNomeArquivo(String nomeArquivo) {
			this.nomeArquivo = nomeArquivo;
		}
		
		public int getCapacidade() {
			return capacidade;
		}
		public void setCapacidade(int capacidade) {
			this.capacidade = capacidade;
		}
		
		public double getValorCaixa() {
			return valorCaixa;
		}
		public void setValorCaixa(double valorCaixa) {
			this.valorCaixa = valorCaixa;
		}
		
		@Override
		public String toString() {
			return "Tecnico [getId()=" + getId() + ", getNome()=" + getNome() + "]";
		}

	}