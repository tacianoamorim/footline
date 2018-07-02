package com.g2t.footline.negocio.cadastros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.g2t.footline.dados.RepositorioArbitro;
import com.g2t.footline.dados.RepositorioArbitroArray;
import com.g2t.footline.exception.ArquivoNaoEncontradoException;
import com.g2t.footline.exception.RegistroNaoEncontradoException;
import com.g2t.footline.negocio.entidades.Arbitro;
import com.g2t.footline.util.Constantes;

public class CadastroArbitro {
	private RepositorioArbitro repositorio;
	private static CadastroArbitro instance;
	
	private CadastroArbitro() {
		repositorio= new RepositorioArbitroArray();
	}
	
	public static CadastroArbitro getInstance() {
		if ( instance == null )
			instance= new CadastroArbitro();
		return instance;
	}
	
	/**
	 * Busca um determinado arbitro pelo codigo
	 * 
	 * return Arbitro arbitro
	 * @throws RegistroNaoEncontradoException 
	 */
	public Arbitro buscar(int id) throws RegistroNaoEncontradoException {
		return repositorio.buscar(id);
	}
	
	
	/**
	 * Lista todos contidos no array
	 * 
	 * return Arbitro[]
	 */
	public Arbitro[] listar() {
		return repositorio.listar();
	}	
	
	/**
	 * Adiciona um tecnico no array
	 * 
	 * @param Tecnico
	 */
	public void inserir(Arbitro arbitro) {
		repositorio.inserir(arbitro);
	}

	/**
	 * Le o arquivo estadios e carrega o array.
	 * 
	 * @throws IOException 
	 * @throws ArquivoNaoEncontradoException 
	 */
	public void carregarArbitro() throws ArquivoNaoEncontradoException {
		try {
			// Carrega o arquivo de arbitros
			File file = new File(Constantes.FILE_PATH + 
					File.separator + "arbitros.foot");
			
			// le os dados de um arquivo
			BufferedReader br = new BufferedReader(new FileReader(file));
			while(br.ready()){
			   String linha = br.readLine();
			   
			   // Monta um array da linha
			   String[] arrayLinha= linha.split(","); 
			   String nome= arrayLinha[0];
			   String nacionalidade= arrayLinha[1];
			   
			   Arbitro arbitro= new Arbitro(nome, nacionalidade);
			   repositorio.inserir(arbitro);

			}
			br.close();
		} catch (IOException e) {
			throw new ArquivoNaoEncontradoException("Não foi localizado o "
					+ "arquivo arbitros.foot");
		}
			
	}	
	
}
