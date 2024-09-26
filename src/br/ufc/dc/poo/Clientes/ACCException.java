package br.ufc.dc.poo.Clientes;

public class ACCException extends Exception{
	private String CPF;
	
	public ACCException(String CPF) {
		super("Cliente ja cadastrado");
		this.CPF = CPF;
	}
}
