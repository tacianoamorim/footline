package com.g2t.footline.negocio.cadastros;

import com.g2t.footline.dados.RepositorioArbitro;
import com.g2t.footline.dados.RepositorioArbitroArray;

public class CadastroArbitro {
	private RepositorioArbitro repositorioArbitro;
	private static CadastroArbitro instance;
	
	private CadastroArbitro() {
		repositorioArbitro= new RepositorioArbitroArray();
	}
	
	public static CadastroArbitro getInstance() {
		if ( instance == null )
			instance= new CadastroArbitro();
		return instance;
	}
	
	
	
}
