package com.g2t.footline.entity;

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
