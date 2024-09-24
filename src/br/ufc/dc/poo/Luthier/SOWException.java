package br.ufc.dc.poo.Luthier;

public class SOWException extends Exception{
	private OrdemDeServico ordem;
	public SOWException(OrdemDeServico ordem) {
		super("Um instrumento não pode ter dois donos");
		this.ordem = ordem;
	}
	
	public OrdemDeServico donos() {
		return ordem;
	}
}
