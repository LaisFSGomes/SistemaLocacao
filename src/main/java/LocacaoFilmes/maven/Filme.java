package LocacaoFilmes.maven;

public class Filme {
	protected String nome;
	protected int id;
	protected double valorCompra;
	protected Genero genero;
	
	public Filme(String nome, Genero genero) {
		this.nome = nome;
		this.genero = genero;
	}

}
