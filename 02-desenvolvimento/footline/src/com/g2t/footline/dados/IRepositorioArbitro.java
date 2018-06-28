package com.g2t.footline.dados;

import com.g2t.footline.negocio.entidades.Arbitro;

public interface IRepositorioArbitro {
	
	void carregarDados();
	Arbitro buscar(int id);
	
}
