package br.ufc.dc.poo.Clientes;

public class OWException extends Exception{
	private String CPF;
	public OWException (String CPF) {
		super("Instrumento ja tem dono");
		this.CPF = CPF;
	}
	
	public String cpfDono() {
		return CPF;
	}
}
