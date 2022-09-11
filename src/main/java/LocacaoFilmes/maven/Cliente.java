package LocacaoFilmes.maven;

public class Cliente {
	protected String nome;
	protected int id;
	protected boolean ativo = true;
	
	public Cliente(String nome, int id) {	
		this.nome= nome;
		this.id= id;
	}
	
	public void clienteAtivo() {
		this.ativo = true;
	}
	
	public void clienteInativo() {
		this.ativo = false;
	}
}
