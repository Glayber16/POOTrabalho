package br.ufc.dc.poo.Luthier;

public class Servicos {
	public String nome;
	public double preco;
	
	public Servicos(String nome, double preco) {
		this.nome = nome;
		this.preco = preco;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public double getPreco() {
		return preco;
	}
}
