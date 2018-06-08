package com.g2t.footline.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Taciano
 *
 */
public class Clube extends BaseEntity implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4420078087855186814L;

	private String acronomo;
	private String tecnico;
	private String nomeEstadio;
	private String nomeArquivo;
	private int nivel;
	private int capacidade;
	private List<Jogador> listaGoleiro = new ArrayList<Jogador>();
	private List<Jogador> listaDefesa = new ArrayList<Jogador>();
	private List<Jogador> listaMeioCampo = new ArrayList<Jogador>();
	private List<Jogador> listaAtaque = new ArrayList<Jogador>();
	private double valorCaixa;
		
	public String getAcronomo() {
		return acronomo;
	}
	public void setAcronomo(String acronomo) {
		this.acronomo = acronomo;
	}

	public String getTecnico() {
		return tecnico;
	}
	public void setTecnico(String tecnico) {
		this.tecnico = tecnico;
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
	
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	
	public List<Jogador> getListaGoleiro() {
		return listaGoleiro;
	}
	public void setListaGoleiro(List<Jogador> listaGoleiro) {
		this.listaGoleiro = listaGoleiro;
	}
	
	public List<Jogador> getListaDefesa() {
		return listaDefesa;
	}
	public void setListaDefesa(List<Jogador> listaDefesa) {
		this.listaDefesa = listaDefesa;
	}
	
	public List<Jogador> getListaMeioCampo() {
		return listaMeioCampo;
	}
	public void setListaMeioCampo(List<Jogador> listaMeioCampo) {
		this.listaMeioCampo = listaMeioCampo;
	}
	
	public List<Jogador> getListaAtaque() {
		return listaAtaque;
	}
	public void setListaAtaque(List<Jogador> listaAtaque) {
		this.listaAtaque = listaAtaque;
	}
	
	public double getValorCaixa() {
		return valorCaixa;
	}
	public void setValorCaixa(double valorCaixa) {
		this.valorCaixa = valorCaixa;
	}
	
	@Override
	public String toString() {
		return "Clube [id=" + getId() + ", nome=" + getNome() + ", acronomo=" + acronomo + ", tecnico=" + tecnico + ", nomeEstadio=" + nomeEstadio
				+ ", nomeArquivo=" + nomeArquivo + ", nivel=" + nivel + ", valorCaixa=" + valorCaixa + "]";
	}
	
}
