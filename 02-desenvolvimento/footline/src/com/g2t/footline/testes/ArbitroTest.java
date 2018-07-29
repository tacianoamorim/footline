/**
 * Executa os testes de arbitro
 */
package com.g2t.footline.testes;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.g2t.footline.negocio.Fachada;
import com.g2t.footline.negocio.entidades.Arbitro;

/**
 * @author Taciano Amorim
 *
 */
public class ArbitroTest {

	private Arbitro arbitro;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		arbitro= new Arbitro("Arbitro Teste", "Brasil");
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testArbito() {
		Fachada.getInstance().inserir(arbitro);
		assertTrue(true);
	}

}
