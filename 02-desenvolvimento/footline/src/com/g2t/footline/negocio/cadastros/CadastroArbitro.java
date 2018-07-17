package com.g2t.footline.negocio.cadastros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.g2t.footline.dados.RepositorioArbitro;
import com.g2t.footline.dados.RepositorioArbitroLista;
import com.g2t.footline.exception.ArquivoNaoEncontradoException;
import com.g2t.footline.exception.RegistroNaoEncontradoException;
import com.g2t.footline.negocio.entidades.Arbitro;
import com.g2t.footline.util.Constantes;

public class CadastroArbitro {
	private RepositorioArbitro repositorio;
	private static CadastroArbitro instance;
	
	private CadastroArbitro() {
		repositorio= new RepositorioArbitroLista();
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
	 * Lista todos contidos na lista
	 * 
	 * return List<Arbitro>
	 */
	public List<Arbitro> listar() {
		return repositorio.listar();
	}	
	
	/**
	 * Adiciona um arbitro na lista
	 * 
	 * @param Arbitro
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
	public void carregar() throws ArquivoNaoEncontradoException {
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
