package com.g2t.footline.util;

import java.text.Normalizer;

public class Biblioteca {

	/**
	 * Remove caracter especiais, espaços, acentos e etc.
	 * 
	 * @param String str
	 * @return String
	 */
	public static String removerAcentosEspacos(String str) {
		String texto= "";
		if (str != null) {
			texto= Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
			texto= texto.replaceAll(" ", "");
			texto= texto.toLowerCase();
		}
	    return texto;
	}
	
}
