package com.g2t.footline.negocio.cadastros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.g2t.footline.dados.RepositorioEstadio;
import com.g2t.footline.dados.RepositorioEstadioLista;
import com.g2t.footline.exception.ArquivoNaoEncontradoException;
import com.g2t.footline.exception.RegistroNaoEncontradoException;
import com.g2t.footline.negocio.entidades.Estadio;
import com.g2t.footline.util.Constantes;

public class CadastroEstadio {
	private RepositorioEstadio repositorio;
	private static CadastroEstadio instance;
	
	private CadastroEstadio() {
		repositorio= new RepositorioEstadioLista();
	}
	
	public static CadastroEstadio getInstance() {
		if ( instance == null )
			instance= new CadastroEstadio();
		return instance;
	}
	
	/**
	 * Busca um determinado estadio pelo codigo
	 * 
	 * return Estadio estadio
	 * @throws RegistroNaoEncontradoException 
	 */
	public Estadio buscar(String id) throws RegistroNaoEncontradoException {
		return repositorio.buscar(id);
	}
	
	
	/**
	 * Lista todos contidos na lista
	 * 
	 * return List<Estadio>
	 */
	public List<Estadio> listar() {
		return repositorio.listar();
	}	
	
	/**
	 * Adiciona um tecnico na lista
	 * 
	 * @param Tecnico
	 */
	public void inserir(Estadio estadio) {
		repositorio.inserir(estadio);
	}

	/**
	 * Le o arquivo estadios e carrega a litsa.
	 * 
	 * @throws IOException 
	 * @throws ArquivoNaoEncontradoException 
	 */
	public void carregar() throws ArquivoNaoEncontradoException {
		try {
			// Carrega o arquivo de estadios
			File file = new File(Constantes.FILE_PATH + 
					File.separator + "estadios.foot");
			
			// le os dados de um arquivo
			BufferedReader br = new BufferedReader(new FileReader(file));
			while(br.ready()){
			   String linha = br.readLine();
			   
			   // Monta um array da linha
			   String[] arrayLinha= linha.split(","); 
			   String idx= arrayLinha[0];
			   String nome= arrayLinha[1];
			   int capacidade= Integer.parseInt( arrayLinha[2] );
			   
			   Estadio estadio= new Estadio(idx, nome, capacidade);
			   repositorio.inserir(estadio);

			}
			br.close();
		} catch (IOException e) {
			throw new ArquivoNaoEncontradoException("Não foi localizado o "
					+ "arquivo estadios.foot");
		}
			
	}	
	
}
