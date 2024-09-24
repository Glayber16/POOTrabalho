package br.ufc.dc.poo.Luthier;

public class ONException extends Exception{
	private String numero;
	public ONException(String numero) {
		super("Ordem não encontrada");
		this.numero = numero;
	}
	public String numeroOrdem() {
		return numero;
	}
}
