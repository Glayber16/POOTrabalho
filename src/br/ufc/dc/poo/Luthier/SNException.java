package br.ufc.dc.poo.Luthier;

public class SNException extends Exception {
	private String numero;
	public SNException (String numero) {
		super ("Duas ordens com mesmo numero não é possivel");
		this.numero = numero;
	}
	
	public String numeroOrdem() {
		return numero;
	}
}
