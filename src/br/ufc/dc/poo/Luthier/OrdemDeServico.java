package br.ufc.dc.poo.Luthier;

import java.util.Date;

import br.ufc.dc.poo.Clientes.Cliente;
import br.ufc.dc.poo.Instrumentos.Instrumentos;

public class OrdemDeServico {
	private Instrumentos instrumento;
	private Cliente cliente;
	private String numero;
	private Date inicio;
	private String entrega;
	private String pecas;
	private String servico;
	
	public OrdemDeServico(Instrumentos instrumento, Cliente cliente, String numero, String entrega, String pecas, String servico) {
		this.instrumento = instrumento;
		this.cliente = cliente;
		this.numero = numero;
		this.inicio = new Date();
		this.entrega = entrega;
		this.pecas = pecas;
		this.servico = servico;
		
	}
	
	public void setInstrumento(Instrumentos instrumento) {
		this.instrumento = instrumento;
	}
	
	public Instrumentos getInstrumento() {
		return instrumento;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public Date getDate() {
		return inicio;
	}
	
	public void setEntrega(String entrega) {
		this.entrega = entrega;
	}
	
	public String getEntrega() {
		return entrega;
	}
	
	public void setPecas(String pecas) {
		this.pecas = pecas;
	}
	
	public String getPecas() {
		return pecas;
	}
	
	public void setServico(String servico) {
		this.servico = servico;
	}
	
	public String getServico() {
		return servico;
	}
}
