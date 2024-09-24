package br.ufc.dc.poo.Clientes;

public class NCException extends Exception{
	private String nome;
	public NCException(String nome) {
		super ("Instrumento não consta na lista");
		this.nome = nome;
	}
	public String nomeInstrumento() {
		return nome;
	}
}
