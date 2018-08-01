package com.g2t.footline.negocio.entidades;

import java.util.ArrayList;
import java.util.List;

public class Partida  {

	private int id;
	private Escalacao mandante;
	private Escalacao visitante;
	
	private List<Jogador> golsMandante = new ArrayList<Jogador>();
	private List<Jogador> golsVisitante = new ArrayList<Jogador>();
	private List<Jogador> listaCartaoAmarelo = new ArrayList<Jogador>();
	private List<Jogador> listaCartaoVermelho = new ArrayList<Jogador>();
	
	private float publico;
	private Arbitro arbitro;
	private Estadio estadio;
	private String grupo;
	
	private int mandantePosicao;
	private String mandanteGrupo;
	private int visitantePosicao;
	private String visitanteGrupo;	

	public Partida(int id, Escalacao mandante, Escalacao visitante, 
			Arbitro arbitro, Estadio estadio) {
		super();
		this.id= id;
		this.mandante = mandante;
		this.visitante = visitante;
		this.arbitro= arbitro;
		this.estadio= estadio;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Escalacao getMandante() {
		return mandante;
	}
	public void setMandante(Escalacao mandante) {
		this.mandante = mandante;
	}

	public Escalacao getVisitante() {
		return visitante;
	}
	public void setVisitante(Escalacao visitante) {
		this.visitante = visitante;
	}
	
	public List<Jogador> getGolsMandante() {
		return golsMandante;
	}
	public void setGolsMandante(List<Jogador> golsMandante) {
		this.golsMandante = golsMandante;
	}
	
	public List<Jogador> getGolsVisitante() {
		return golsVisitante;
	}
	public void setGolsVisitante(List<Jogador> golsVisitante) {
		this.golsVisitante = golsVisitante;
	}
	
	public float getPublico() {
		return publico;
	}
	public void setPublico(float publico) {
		this.publico = publico;
	}

	public Arbitro getArbitro() {
		return arbitro;
	}
	public void setArbitro(Arbitro arbitro) {
		this.arbitro = arbitro;
	}

	public Estadio getEstadio() {
		return estadio;
	}
	public void setEstadio(Estadio estadio) {
		this.estadio = estadio;
	}

	public int getMandantePosicao() {
		return mandantePosicao;
	}
	public void setMandantePosicao(int mandantePosicao) {
		this.mandantePosicao = mandantePosicao;
	}

	public String getMandanteGrupo() {
		return mandanteGrupo;
	}
	public void setMandanteGrupo(String mandanteGrupo) {
		this.mandanteGrupo = mandanteGrupo;
	}

	public int getVisitantePosicao() {
		return visitantePosicao;
	}
	public void setVisitantePosicao(int visitantePosicao) {
		this.visitantePosicao = visitantePosicao;
	}

	public String getVisitanteGrupo() {
		return visitanteGrupo;
	}
	public void setVisitanteGrupo(String visitanteGrupo) {
		this.visitanteGrupo = visitanteGrupo;
	}
	
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public List<Jogador> getListaCartaoAmarelo() {
		return listaCartaoAmarelo;
	}
	public void setListaCartaoAmarelo(List<Jogador> listaCartaoAmarelo) {
		this.listaCartaoAmarelo = listaCartaoAmarelo;
	}

	public List<Jogador> getListaCartaoVermelho() {
		return listaCartaoVermelho;
	}
	public void setListaCartaoVermelho(List<Jogador> listaCartaoVermelho) {
		this.listaCartaoVermelho = listaCartaoVermelho;
	}

	@Override
	public String toString() {
		return "Partida [mandante=" + mandante + ", grupo=" + grupo +  ", visitante=" + visitante + ", golsMandante=" + golsMandante
				+ ", golsvisitante=" + golsVisitante + ", publico=" + publico + ", arbitro=" + arbitro + "]";
	}
	
}
