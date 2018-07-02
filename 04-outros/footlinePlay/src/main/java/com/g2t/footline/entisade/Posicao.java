package com.g2t.footline.entisade;

/**
 * Enum representando as possiveis posicoes
 * 	de um jogador no campo de futebol.
 * G - goleiro
 * D - Defesa
 * M - Meio-Campo
 * A - Atacante
 * 
 * @author Taciano
 */
public enum Posicao {
	G(1), D(2), M(3), A(4);
    
    private final int valor;
    
    Posicao(int valorOpcao){
        valor = valorOpcao;
    }
    
    public int getValor(){
        return valor;
    }
}
