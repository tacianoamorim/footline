package com.g2t.footline.negocio;

import com.g2t.footline.negocio.cadastros.CadastroArbitro;

public class Fachada {

	private Fachada instance;
	private CadastroArbitro cadastroArbitro;

	private Fachada() {
		cadastroArbitro= new CadastroArbitro();
	}
	
	public Fachada getInstance() {
		if ( instance == null ) {
			instance= new Fachada();
		}
		return instance;
	}
	
}
