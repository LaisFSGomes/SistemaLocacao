package LocacaoFilmes.maven;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ClienteTest {

	Cliente cliente1;
	Cliente cliente2;
	
	@Before
	public void setUp() throws Exception {
		cliente1 = new Cliente("Joao", 1);
		cliente1.clienteAtivo();
		cliente2 = new Cliente("Andrea", 2);
		cliente2.clienteInativo();
	}

	@Test
	public void clienteAtivoTest() {
		assertEquals(true, cliente1.ativo);
	}
	
	@Test
	public void clienteInativoTest() {
		assertEquals(false, cliente2.ativo);
	}

}
