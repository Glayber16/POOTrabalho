package br.ufc.dc.poo.Clientes;

public class CNFException extends Exception {
	private String CPF;
	
	public CNFException(String CPF) {
		super("Cliente não encontrado");
		this.CPF = CPF;
	}
}
