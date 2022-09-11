package LocacaoFilmes.maven;

public class Desconto {
	protected Genero genero;
	protected double porcentagem;
	
	public Desconto(Genero genero, double porcentagem) {
		this.genero = genero;
		this.porcentagem = porcentagem;
	}
}
