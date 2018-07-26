package com.g2t.footline.negocio.entidades;

/**
 * Enum representando as possiveis taticas
 * 	de uma equipe de futebol.
 * 
 * @author Taciano
 */
public enum Tatica {
	_3_5_2(352), _3_4_3(343), 
	_4_4_2(442), _4_3_3(433), _4_5_1(451), _4_2_4(424),
	_5_3_2(532), _5_2_3(523);

    private final int valor;

    Tatica(int valorOpcao){
        valor = valorOpcao;
    }

    public int getValor(){
        return valor;
    }
}
