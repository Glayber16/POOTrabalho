package br.ufc.dc.poo.Luthier;

public class ONFException extends Exception{
	private String numero;
	
	public ONFException(String numero) {
		super("Notificação não encontrada");
		this.numero = numero;
	}
}
