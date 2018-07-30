package com.g2t.footline.util;

import java.text.Normalizer;
import java.util.Random;

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
	
	/**
	 * Calcula um valor aleatorio entre dois valores
	 * 
	 * @param float valorInicial
	 * @param float valorFinal
	 * @return float
	 */
	public static float geraValorAleatorio(float valorInicial,
			float valorFinal) {
		Random random = new Random();
		float valor= valorInicial + random.nextFloat() 
						* (valorFinal - valorInicial);
	    return valor;
	}	
	
	/**
	 * Calcula um valor aleatorio entre dois valores
	 * 
	 * @param int valorInicial
	 * @param int valorFinal
	 * @return int
	 */
	public static int geraValorAleatorio(int valorInicial,
			int valorFinal) {
		Random random = new Random();
		int valor= random.nextInt((valorFinal - valorInicial) + 1) 
									+ valorInicial;
	    return valor;
	}	
	
	/**
	 * Calcula um valor aleatorio
	 * 
	 * @param int valorInicial
	 * @param int valorFinal
	 * @return int
	 */
	public static int geraValorAleatorio() {
	    return (new Random()).nextInt();
	}
	
	/**
	 * Retorna um boolean aleatorio
	 * 
	 * @return boolean
	 */
	public static boolean geraBooleanAleatorio() {
		return (new Random()).nextBoolean();
	}
}
