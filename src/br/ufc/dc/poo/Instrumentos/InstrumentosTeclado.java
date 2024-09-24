package br.ufc.dc.poo.Instrumentos;

import br.ufc.dc.poo.Clientes.Cliente;

public class InstrumentosTeclado extends Instrumentos {

	public InstrumentosTeclado(String nome, String marca, String modelo, Cliente dono) {
		super(nome, marca, modelo, dono);
		this.tipo = "Teclado";
	}

}
