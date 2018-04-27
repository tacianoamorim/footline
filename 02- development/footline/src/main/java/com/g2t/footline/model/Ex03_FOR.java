package com.g2t.footline.model;

/*

Em um campeonato de futebol 5 times est�o na disputa e cada time possui onze jogadores.

Fa�a um programa que receba o nome de cada time e em seguida a idade, o peso e altura de

cada um dos seus 11 jogadores. Calcular e imprimir:

a) A m�dia de idade dos jogadores de cada time.

B) Peso m�dio dos jogadores que est�o disputando o campeonato.

*/

import javax.swing.JOptionPane;

class Ex03_FOR

{

	static public void main(String[] args)

	{

		String nomeTime;

		double altura, peso, somaPesos = 0, mediaIdade, mediaPesos;

		int idade, time, jogadores, somaIdades;

		for (time = 0; time < 2; time++)

		{

			somaIdades = 0;

			nomeTime = JOptionPane.showInputDialog(null, "Nome do time: ");

			for (jogadores = 0; jogadores < 3; jogadores++)

			{

				altura = Double.parseDouble(JOptionPane.showInputDialog(null, "Entre com a altura jogador: ",
						"Dados do " + (jogadores + 1) + "� Jogador", JOptionPane.QUESTION_MESSAGE));

				peso = Double.parseDouble(JOptionPane.showInputDialog(null, "Entre com o peso do jogador: ",
						"Dados do " + (jogadores + 1) + "� Jogador", JOptionPane.QUESTION_MESSAGE));

				idade = Integer.parseInt(JOptionPane.showInputDialog(null, "Entre com a idade do jogador: ",
						"Dados do " + (jogadores + 1) + "� Jogador", JOptionPane.QUESTION_MESSAGE));

				somaIdades += idade;

				somaPesos += peso;

			}

			mediaIdade = somaIdades / 3;

			JOptionPane.showMessageDialog(null, "M�dia de idade dos jogadores do " + nomeTime + ": " + mediaIdade);

		}

		mediaPesos = somaPesos / 6;

		JOptionPane.showMessageDialog(null, "M�dia geral dos pesos de todos os jogadores: " + mediaPesos);

	}

}