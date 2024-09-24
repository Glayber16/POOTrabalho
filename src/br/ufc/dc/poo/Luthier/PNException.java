package br.ufc.dc.poo.Luthier;

public class PNException extends Exception{
	private Pecas peca;
	public PNException(Pecas peca) {
		super("não necessitou de material/peças.");
		this.peca = peca;
	}
	
	// ideia: na interface grafica quando não tiver pecas numa checkbox retornar isso//
}
