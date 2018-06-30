package com.g2t.footline.util;

import java.io.File;

public interface Constantes {

	public static final String FILE_PATH= System.getProperty("user.dir")+
			File.separator + "bin" + File.separator;
	
	public static final char FILE_DADOS_SELECAO 		= 'S';
	public static final char FILE_DADOS_JOGADOR_GOLEIRO	= 'G';
	public static final char FILE_DADOS_JOGADOR_DEFESA 	= 'Z';
	public static final char FILE_DADOS_JOGADOR_MEIA 	= 'M';
	public static final char FILE_DADOS_JOGADOR_ATAQUE 	= 'A';
	
}
