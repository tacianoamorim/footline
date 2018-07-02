package com.g2t.footline.exception;

public class ArquivoNaoEncontradoException extends Exception {

	private String mensagem;
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2841557052455201538L;
	
	public ArquivoNaoEncontradoException(String mensagem) {
		this.mensagem= mensagem;
	}

	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
