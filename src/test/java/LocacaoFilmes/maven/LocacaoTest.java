package LocacaoFilmes.maven;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LocacaoTest {

	Locacao locacao1;
	Locacao locacao2;
	Filme filme1;
	Filme filme2;
	Cliente cliente1;
	Cliente cliente2;
	
	@Before
	public void setUp() throws Exception {
		locacao1 = new Locacao();
		locacao2 = new Locacao();
		
		filme1 = new Filme("300 Spartanus", Genero.ACAO);
		filme1.valorCompra = 100;
		filme1.id = 1;

		filme2 = new Filme("Procurando Nemo", Genero.ANIMACAO);
		filme2.valorCompra = 50;
		filme2.id=2;
		
		cliente1 = new Cliente("Joao", 1);
		cliente1.clienteAtivo();
		cliente2 = new Cliente("Andrea", 2);
		cliente2.clienteInativo();
		
		locacao1.alugar(cliente1, filme1);
		locacao1.setDataLocacao("01/09/2022");
		locacao1.setHoraLocacao("20:30");
		
		locacao2.alugar(cliente2, filme2);
		locacao2.setDataLocacao("30/07/2022");
		locacao2.setHoraLocacao("12:30");
		
	}

	@Test
	public void locacaoDeuCerto() {
		assertEquals(true, locacao1.deuCerto);
	}
	
	@Test
	public void locacaoNaoDeuCerto() {
		assertEquals(false, locacao2.deuCerto);
	}


}
