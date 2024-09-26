package br.ufc.dc.poo.Instrumentos;

public class SVException extends Exception {
	private String estado;
	
	
	public SVException(String estado) {
		super("Estado invalido: tente novamente" + Instrumentos.getEstadosPermitidos());
		this.estado = estado;

	}
	
	public String estadoIns() {
		return estado;
	}
}
