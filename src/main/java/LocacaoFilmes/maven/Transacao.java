package LocacaoFilmes.maven;

import java.util.ArrayList;

public class Transacao {
	protected ArrayList<Locacao> alugueis;
	
	public Transacao() {
		alugueis = new ArrayList<Locacao>();
	}
	
	public void addLocacao(Locacao l) {
		if (l.deuCerto) {
			this.alugueis.add(l);
		}
	}
	
	public double valorLocacaoTotal() {
	    double valor=0;
		for (Locacao locacao : alugueis) {
			if(locacao.deuCerto) {
				valor +=locacao.filme.valorCompra;
			}
		}
		return valor;
	}
	
	public Cliente buscaCliente(int id) {
		for (Locacao locacao : alugueis) {
				if(locacao.cliente.id==id) {
					return locacao.cliente;
			}
		}
		return null;
	}
	public double calculoLucro(int filmeId) {
		double valor=0;
		Filme aux = null;
		for (Locacao locacao : alugueis) {
			if (locacao.deuCerto) {
				if(locacao.filme.id==filmeId) {
					valor += locacao.valorAluguel;
					aux = locacao.filme;
				}
			}
		}
		return (valor*100)/aux.valorCompra;
	}
	
	public Genero generoMaisAlugado() {
		int drama = 0; int comedia = 0; int acao = 0; int policial = 0; int animacao = 0;
		for (Locacao locacao : alugueis) {
			switch(locacao.filme.genero){
				case DRAMA: 
					drama = drama+1;
					break;
				case COMEDIA:
					comedia = comedia+1;
					break;
				case ACAO:
					acao = acao+1;
					break;
				case POLICIAL:
					policial = policial+1;
					break;
				case ANIMACAO:
					animacao = animacao+1;
					break;
			}	
		}
		
		
		if((drama>comedia) && (drama>acao) && (drama>policial) && (drama>animacao)) {
			return Genero.DRAMA;
		} else if((comedia>drama) && (comedia>acao) && (comedia>policial) && (comedia>animacao)) {
			return Genero.COMEDIA;
		} else if((acao>comedia) && (acao>drama) && (acao>policial) && (acao>animacao)){
			return Genero.ACAO;
		}  else if((policial>comedia) && (policial>drama) && (policial>acao) && (policial>animacao)){
			return Genero.POLICIAL;
		}  else if((animacao>comedia) && (animacao>drama) && (animacao>acao) && (animacao>policial)){
			return Genero.ANIMACAO;
		}
		return null;
	}
}
