package com.g2t.footline.service;

import com.g2t.footline.entity.Jogador;

public class JogadorService {

	private static JogadorService uniqueInstance;

	private JogadorService() { 
	}

	public static synchronized JogadorService getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new JogadorService();
		return uniqueInstance;
	}
	
	/**
	 * Gera os seguintes dados iniciais para os jogadores:
	 *  - Valor do salario
	 *  - Valor do passe
	 *  - Nivel do jogador
	 * @param jogador
	 */
	public void gerarDadosComplementares(int nivelClube, Jogador jogador) {
		// TODO: 002 - Complementar metodo
	
		/*
		 *  O nivel do jogador deve ser calculado levando em consideracao o nivel do clube, onde terá um
		 *  	valor entre 25% a 40% do valor de referencia.
		 */
		int percentualAplicado= 25 + (int)(Math.random() * (40 - 25));
		jogador.setNivel( ( nivelClube * percentualAplicado ) /100 );

		/*
		 *  O salario deve seguir a seguinte regra:
		 *  - nivel do jogador de  0 a 10: valor aleatorio entre  500 e 2000
		 *  - nivel do jogador de 11 a 20: valor aleatorio entre 2000 e 3000
		 *  - nivel do jogador de 21 a 30: valor aleatorio entre 3001 e 4000
		 *  - nivel do jogador de 31 a 40: valor aleatorio entre 4001 e 5000
		 *  - nivel do jogador de 41 a 50: valor aleatorio entre 5001 e 7000
		 *  - nivel do jogador de 51 a 60: valor aleatorio entre 7001 e 9000
		 */		
		float salario= 0f;
		
		if ( jogador.getNivel() <= 10) {
			salario = 500 + (int)(Math.random() * (2000 - 500));
		} else if ( jogador.getNivel() <= 20) {
			salario = 2000 + (int)(Math.random() * (3000 - 2000));
		} else if ( jogador.getNivel() <= 30) {
			salario = 3001 + (int)(Math.random() * (4000 - 3001));
		} else if ( jogador.getNivel() <= 40) {
			salario = 4001 + (int)(Math.random() * (5000 - 4001));
		} else if ( jogador.getNivel() <= 50) {
			salario = 5001 + (int)(Math.random() * (7000 - 5001));
		} else {
			salario = 7000 + (int)(Math.random() * (9000 - 7000));
		}
		jogador.setSalario(salario);
		
		
		/*
		 *  O valor do passe deve seguir a seguinte regra:
		 *  - goleiro   : vale 10 * o salario, mais um acrescimento de 20% do valor gerado 
		 *  - defesa    : vale 10 * o salario, mais um acrescimento de 10% do valor gerado
		 *  - meioCampo : vale 10 * o salario, mais um acrescimento de 15% do valor gerado
		 *  - ataque    : vale 10 * o salario, mais um acrescimento de 30% do valor gerado
		 */			
		jogador.setValorPasse(10000.00);
	
	}
	
}