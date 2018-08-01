package com.g2t.footline.util;

import java.io.File;

public interface Constantes {

	public static final String FILE_PATH= System.getProperty("user.dir")+
			File.separator + "bin" + File.separator;
	public static final String PATH_APP= System.getProperty("java.io.tmpdir");
	
	public static final char FILE_DADOS_SELECAO 		= 'S';
	public static final char FILE_DADOS_JOGADOR_GOLEIRO	= 'G';
	public static final char FILE_DADOS_JOGADOR_DEFESA 	= 'Z';
	public static final char FILE_DADOS_JOGADOR_MEIA 	= 'M';
	public static final char FILE_DADOS_JOGADOR_ATAQUE 	= 'A';
	
	public static final char TIPO_DADO_RODADA 			= 'R';	
	public static final char TIPO_DADO_PARTIDA_FG	 	= 'P';	
	public static final char TIPO_DADO_PARTIDA_OF	 	= '8';	
	public static final char TIPO_DADO_PARTIDA_QF	 	= '4';
	public static final char TIPO_DADO_PARTIDA_SF	 	= '2';
	public static final char TIPO_DADO_PARTIDA_3L	 	= '1';
	public static final char TIPO_DADO_PARTIDA_PF	 	= '0';
	
	public static final int RODADA_OITAVA_FINAL 		= 4;	
	public static final int RODADA_QUARTA_FINAL 		= 5;
	public static final int RODADA_SEMI_FINAL 			= 6;
	public static final int RODADA_TERCEIRO_LUGAR 		= 7;
	public static final int RODADA_FINAL 				= 8;

}
