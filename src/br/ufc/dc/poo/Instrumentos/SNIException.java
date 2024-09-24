package br.ufc.dc.poo.Instrumentos;

public class SNIException extends Exception{
	public String nome;
	public SNIException(String nome) {
		super("Instrumento não encontrado");
		this.nome = nome;
	}
	
	public String nomeIns() {
		return nome;
	}
}
