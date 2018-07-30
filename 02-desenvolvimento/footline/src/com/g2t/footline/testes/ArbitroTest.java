/**
 * Executa os testes de arbitro
 */
package com.g2t.footline.testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.g2t.footline.exception.RegistroNaoEncontradoException;
import com.g2t.footline.negocio.Fachada;
import com.g2t.footline.negocio.entidades.Arbitro;

/**
 * @author Taciano Amorim
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ArbitroTest {

	private Arbitro arbitro;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		arbitro= new Arbitro("Arbitro Teste", "Brasil");
	}

	@Test
	public void testCadastro() {
		try {
			Fachada.getInstance().inserir(arbitro);
		} catch (Exception e) {
			fail(e.getCause().toString());
		}
		
	}
	
	@Test
	public void testConsulta() {
		Arbitro arbitroCinsultado = new Arbitro();
		try {
			Fachada.getInstance().inserir(arbitro);
			arbitroCinsultado= Fachada.getInstance()
					.buscarArbitro(arbitro.getId());
		} catch (RegistroNaoEncontradoException e) {
			fail(e.getMensagem());
		}
		assertEquals(arbitroCinsultado.getNome(), arbitro.getNome());
	}

}
