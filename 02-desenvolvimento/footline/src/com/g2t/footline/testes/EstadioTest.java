/**
 * Executa os testes de estadio
 */
package com.g2t.footline.testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.g2t.footline.exception.RegistroNaoEncontradoException;
import com.g2t.footline.negocio.Fachada;
import com.g2t.footline.negocio.entidades.Estadio;

/**
 * @author Taciano Amorim
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EstadioTest {

	private Estadio estadio;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		estadio= new Estadio();
		estadio.setId("NY");
		estadio.setNome("Estadio 1");
		estadio.setCapacidade(6000);
	}

	@Test
	public void testCadastro() {
		try {
			Fachada.getInstance().inserir(estadio);
		} catch (Exception e) {
			fail(e.getCause().toString());
		}
		
	}
	
	@Test
	public void testConsulta() {
		Estadio estadioConsultado = new Estadio();
		try {
			estadioConsultado= Fachada.getInstance()
					.buscarEstadio(estadio.getId());
		} catch (RegistroNaoEncontradoException e) {
			fail(e.getMensagem());
		}
		assertEquals(estadioConsultado.getNome(), estadio.getNome());
	}

	@Test
	public void testListar() {
		List<Estadio> lista = new ArrayList<Estadio>();
		try {
			Fachada.getInstance().inserir(estadio);
			lista= Fachada.getInstance().listarEstadio();
		} catch (Exception e) {
			fail(e.getCause().toString());
		}
		assertEquals(lista.size(), 2);
	}	
}
