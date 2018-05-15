package com.g2t.footline.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.g2t.footline.entity.Jogo;
import com.g2t.footline.util.Constantes;

public class JogoDAO {

	public void salvar(String nomeArquivo, Jogo jogo) throws IOException {
		System.out.println(Constantes.PATH_APP + " / " + nomeArquivo + ".fl");
		File file = new File(System.getProperty("java.io.tmpdir"), nomeArquivo + ".fl");
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(jogo);
		oos.close();
		fos.close();
	}

	public Jogo carregar(String nomeArquivo, Jogo jogo) throws IOException, ClassNotFoundException {
		File file = new File(Constantes.PATH_APP, nomeArquivo + ".fl");
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Jogo result = (Jogo) ois.readObject();
		return result;
	}

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
