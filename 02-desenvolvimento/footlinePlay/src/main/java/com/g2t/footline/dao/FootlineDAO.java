package com.g2t.footline.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.g2t.footline.entisade.Footline;
import com.g2t.footline.util.Constantes;

public class FootlineDAO {

	/**
	 * Salva os dados do jogo
	 * 
	 * @param String nomeArquivo
	 * @param Footline gerente
	 * @throws IOException
	 */
	public void salvar(String nomeArquivo, Footline gerente) throws IOException {
		System.out.println(Constantes.PATH_APP + " / " 
				+ nomeArquivo + Constantes.EXTENSAO_ARQUIVO);
		File file = new File(Constantes.PATH_APP, 
				nomeArquivo + Constantes.EXTENSAO_ARQUIVO);
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(gerente);
		oos.close();
		fos.close();
	}

	/**
	 * Carrega os dados de um jogo salvo
	 * 
	 * @param String nomeArquivo
	 * @return Footline
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings("resource")
	public Footline carregar(String nomeArquivo) throws IOException, ClassNotFoundException {
		File file = new File(Constantes.PATH_APP, 
				nomeArquivo + Constantes.EXTENSAO_ARQUIVO);
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Footline result = (Footline) ois.readObject();
		return result;
	}

	/**
	 * Retorna uma lista com os nomes dos arquivos salvos
	 * @return List<String> 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public List<String> listaArquivos() throws IOException, ClassNotFoundException {
		List<String> retorno = new ArrayList<String>();
		File file = new File(Constantes.PATH_APP);
		File afile[] = file.listFiles();
		int i = 0;
		for (int j = afile.length; i < j; i++) {
			if (afile[i].getName().endsWith("fl")) {
				
				String nomeArquivo= afile[i].getName().replaceAll(".fl", "");
				retorno.add( nomeArquivo );
			}
			File arquivos = afile[i];
			System.out.println(arquivos.getName());
		}
		return retorno;
	}

}
