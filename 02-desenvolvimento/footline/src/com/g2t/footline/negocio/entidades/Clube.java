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

		@Override
		public String toString() {
			return "Tecnico [getId()=" + getId() + ", getNome()=" + getNome() + "]";
		}

	}