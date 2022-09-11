package LocacaoFilmes.maven;

import java.util.ArrayList;

public class FilmesFavoritos {
	protected ArrayList<Filme> filmes;
	
	public FilmesFavoritos() {
		filmes = new ArrayList<Filme>();
	}
	
	public void addFilme(Filme f) {
		this.filmes.add(f);
	}
	
	public Filme buscaFilmeId(int id) {
		for (Filme filme : filmes) {
			if(filme.id == id) {
				return filme;
			}
		}
		return null;
	}
	public Filme buscaFilmeNome(String nome) {
		for (Filme filme : filmes) {
			if(filme.nome.equalsIgnoreCase(nome)) {
				return filme;
			}
		}
		return null;
	}
	
}
