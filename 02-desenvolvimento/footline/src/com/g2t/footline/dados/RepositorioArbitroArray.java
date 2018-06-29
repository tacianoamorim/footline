package com.g2t.footline.dados;

import java.io.File;

import com.g2t.footline.negocio.Constantes;
import com.g2t.footline.negocio.entidades.Arbitro;

public class RepositorioArbitroArray implements RepositorioArbitro {

	private Arbitro[] arrayDados= new Arbitro[36];
	private int idx= 0;
	
	@Override
	public void carregarDados() {
		// Carregar os dados dos clubes
		// Carrega o path de armazenamento dos arquivos
		File file = new File(Constantes.FILE_PATH);
		File afile[] = file.listFiles();
		
		// Carregar os dados dos clubes
		for (int i=0; i < afile.length; i++) {
			if (afile[i].getName().endsWith("foot")) {
				arrayDados[idx++]= new Arbitro(1, "Fahad Al Mirdasi", 45);
				System.out.println(afile[i].getName());
			}
		}
	}

	/**
	 * Busca um determinado arbitro pelo codigo
	 * 
	 * return Arbitro arbitro
	 */
	@Override
	public Arbitro buscar(int id) {
		Arbitro retorno= new Arbitro();
		for (int i = 0; i < arrayDados.length; i++) {
			Arbitro arbitro = arrayDados[i];
			if ( id == arbitro.getId() ) {
				retorno= arbitro;
				break;
			}
		}
		return retorno;
	}

}
