package br.ufc.dc.poo.Instrumentos;

import br.ufc.dc.poo.Clientes.Cliente;

public class InstrumentosCorda extends Instrumentos {

	

	public InstrumentosCorda(String nome, String marca, String modelo, Cliente dono) {
		super(nome, marca, modelo, dono);
		this.tipo = "Corda";
		
	}
	
}
