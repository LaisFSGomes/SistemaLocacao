package LocacaoFilmes.maven;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TransacaoTest {

	Transacao transacao;
	Transacao transacao2;
	Transacao transacao3;
	Transacao transacao4;
	Transacao transacao5;
	Transacao transacao6;
	Locacao locacao1;
	Locacao locacao2;
	Locacao locacao3;
	Locacao locacao4;
	Locacao locacao5;
	Locacao locacao6;
	Locacao locacao7;
	Locacao locacao8;
	Filme filme1;
	Filme filme2;
	Filme filme3;
	Filme filme4;
	Filme filme5;
	Cliente cliente_1;
	Cliente cliente_2;
	Cliente cliente_3;
	Cliente cliente4;
	Desconto descontoAcao;

	@Before
	public void setUp() throws Exception {
		locacao1 = new Locacao();
		locacao2 = new Locacao();
		locacao3 = new Locacao();
		locacao4 = new Locacao();
		locacao5 = new Locacao();
		locacao6 = new Locacao();
		locacao7 = new Locacao();
		locacao8 = new Locacao();
		
		filme1 = new Filme("300 Spartanus", Genero.ACAO);
		filme1.valorCompra = 100;
		filme1.id = 1;

		filme2 = new Filme("Procurando Nemo", Genero.ANIMACAO);
		filme2.valorCompra = 100;
		filme2.id = 2;
		
		filme3 = new Filme("O poderoso chefão", Genero.POLICIAL);
		filme3.valorCompra = 100;
		filme3.id = 3;
		
		filme4 = new Filme("Na pele em que habito", Genero.DRAMA);
		filme4.valorCompra = 100;
		filme4.id = 4;
		
		filme5 = new Filme("Se eu fosse você", Genero.COMEDIA);
		filme5.valorCompra = 100;
		filme5.id = 5;
		
		cliente_1 = new Cliente("Caio", 1);
		cliente_1.clienteAtivo();
		cliente_2 = new Cliente("Andrea", 2);
		cliente_2.clienteAtivo();
		cliente_3 = new Cliente("Lucas", 3);
		cliente_3.clienteInativo(); 		//cliente inativo
		
		locacao1.alugar(cliente_1, filme1);
		locacao1.setDataLocacao("01/09/2022");
		locacao1.setHoraLocacao("20:30");
		locacao1.valorAluguel = 50;
		
		locacao2.alugar(cliente_2, filme2);
		locacao2.setDataLocacao("30/07/2022");
		locacao2.setHoraLocacao("12:30");
		locacao2.valorAluguel = 50;
		
		locacao3.alugar(cliente_3, filme3); //esse não foi feito
		locacao3.setDataLocacao("30/07/2022");
		locacao3.setHoraLocacao("12:30");
		locacao3.valorAluguel = 50;
		
		locacao4.alugar(cliente_2, filme2);
		locacao4.setDataLocacao("30/07/2022");
		locacao4.setHoraLocacao("12:30");
		locacao4.valorAluguel = 50;
		
		locacao5.alugar(cliente_1, filme2);
		locacao5.setDataLocacao("01/09/2022");
		locacao5.setHoraLocacao("12:30");
		locacao5.valorAluguel = 50;
		
		locacao6.alugar(cliente_2, filme4);
		locacao6.setDataLocacao("09/09/2022");
		locacao6.setHoraLocacao("19:33");
		locacao6.valorAluguel = 50;
		
		locacao7.alugar(cliente_1, filme5);
		locacao7.setDataLocacao("10/09/2022");
		locacao7.setHoraLocacao("17:21");
		locacao7.valorAluguel = 50;
		
		locacao8.alugar(cliente_1, filme3);
		locacao8.setDataLocacao("10/09/2022");
		locacao8.setHoraLocacao("17:21");
		locacao8.valorAluguel = 50;
		
		transacao = new Transacao();
		transacao.addLocacao(locacao1);
		transacao.addLocacao(locacao2);
		transacao.addLocacao(locacao3);
		transacao.addLocacao(locacao4);
		transacao.addLocacao(locacao5);
		transacao.addLocacao(locacao6);
		transacao.addLocacao(locacao7);
		
		transacao2 = new Transacao();
		transacao2.addLocacao(locacao1);
		transacao2.addLocacao(locacao1);
		transacao2.addLocacao(locacao2);
		
		transacao3 = new Transacao();
		transacao3.addLocacao(locacao7);
		transacao3.addLocacao(locacao7);
		transacao3.addLocacao(locacao6);
		
		transacao4 = new Transacao();
		transacao4.addLocacao(locacao6);
		transacao4.addLocacao(locacao6);
		transacao4.addLocacao(locacao8);
		
		transacao5 = new Transacao();
		transacao5.addLocacao(locacao8);
		transacao5.addLocacao(locacao8);
		transacao5.addLocacao(locacao1);
		
		transacao6 = new Transacao();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void alugueisListTest() {
		
		assertEquals(transacao.alugueis.get(0).cliente.nome, "Caio");
		assertEquals(transacao.alugueis.get(1).cliente.nome, "Andrea");
		assertEquals(transacao.alugueis.size(), 6);

		assertTrue("Filme deveria ser selecionado corretamente",transacao.alugueis.get(1).filme.id==2);
	}
	@Test
	public void buscaCliente() {
		assertTrue(transacao.buscaCliente(1) == cliente_1);
		assertNull(transacao.buscaCliente(100));
	} 

	@Test
	public void valorLocacaoTotalTest() {
		assertEquals(600, transacao.valorLocacaoTotal(), 0.1);
	}

	@Test 
	public void calculoLucroTest() {
		assertEquals(150.0, transacao.calculoLucro(2), 0.1);
	}
	 
	@Test 
	public void filmeMaisAlugadoTest() {
		assertTrue(transacao.generoMaisAlugado() == Genero.ANIMACAO);
		assertTrue(transacao2.generoMaisAlugado() == Genero.ACAO);
		assertTrue(transacao3.generoMaisAlugado() == Genero.COMEDIA);
		assertTrue(transacao4.generoMaisAlugado() == Genero.DRAMA);
		assertTrue(transacao5.generoMaisAlugado() == Genero.POLICIAL);
		assertNull(transacao6.generoMaisAlugado());
	}
	
	@Test
	public void descontoTest() {
		descontoAcao = new Desconto(Genero.ACAO, 0.1);
		locacao1.setValorAluguel(50, descontoAcao);
		assertEquals(45, locacao1.valorAluguel,.1);
		
		locacao6.setValorAluguel(50, descontoAcao);
		assertEquals(50, locacao6.valorAluguel,.1);
	}
	
	@Test
	public void transacaoFilmesFavoristosTest() {
		FilmesFavoritos listaFilmes = new FilmesFavoritos();
		listaFilmes.addFilme(filme1);
		listaFilmes.addFilme(filme3);
		assertTrue(listaFilmes.buscaFilmeId(1).nome == filme1.nome);
		assertTrue(listaFilmes.buscaFilmeNome("O PODEROSO CHEFÃO").nome == filme3.nome);
		assertNull(listaFilmes.buscaFilmeId(100));
		assertNull(listaFilmes.buscaFilmeNome("Infelizmente não tem no Brasil"));
		
		Locacao locacao4 = new Locacao();
		locacao4.alugar(cliente_1, listaFilmes.buscaFilmeId(1));
		assertTrue(locacao4.filme.nome == filme1.nome);
		assertTrue(locacao4.cliente.nome == cliente_1.nome);
		
	}
	

}
