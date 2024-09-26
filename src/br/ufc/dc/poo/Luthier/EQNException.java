package br.ufc.dc.poo.Luthier;

public class EQNException extends Exception{
	private String estado;
	private String entrega;
	
	public EQNException(String estado, String entrega) {
		super("Uma nova notificacao não pode ser gerada sem alteração");
		this.estado = estado;
		this.entrega = entrega;
	}

}
