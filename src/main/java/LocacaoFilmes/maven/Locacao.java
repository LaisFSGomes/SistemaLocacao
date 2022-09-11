package LocacaoFilmes.maven;

public class Locacao {
	protected Cliente cliente;
	protected Filme filme;
	protected double valorAluguel;
	protected String dataLocacao;
	protected String horaLocacao;
	protected boolean deuCerto;
	
	public void alugar(Cliente c, Filme f) {
		if (c.ativo == true) {
			this.cliente = c;
			this.filme = f;
			this.deuCerto = true;
		} else {
			this.cliente = null;
			this.filme = null;
			this.deuCerto = false;
		}
	}
	public void setValorAluguel(double valorAluguel, Desconto desconto) {
		if(desconto.genero == this.filme.genero) {
			this.valorAluguel = valorAluguel - (valorAluguel*desconto.porcentagem);
		} else {			
			this.valorAluguel=valorAluguel;
		}
	}
	public void setDataLocacao(String data) {
		this.dataLocacao = data;
	}
	public void setHoraLocacao(String hora) {
		this.horaLocacao = hora;
	}

}
