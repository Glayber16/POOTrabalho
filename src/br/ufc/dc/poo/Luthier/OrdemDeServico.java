package br.ufc.dc.poo.Luthier;

import java.time.LocalDate;
import java.util.Date;

import br.ufc.dc.poo.Clientes.Cliente;
import br.ufc.dc.poo.Instrumentos.Instrumentos;

public class OrdemDeServico {
	private Instrumentos instrumento;
	private Cliente cliente;
	private String numero;
	private Date inicio;
	private String entrega;
	private Pecas pecas;
	private Servicos servico;
	
	public OrdemDeServico(Instrumentos instrumento, Cliente cliente, String numero, String entrega, Pecas pecas, Servicos servico) {
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

	public Pecas getPecas() {
		return pecas;
	}

	public void setPecas(Pecas pecas) {
		this.pecas = pecas;
	}

	public Servicos getServico() {
		return servico;
	}

	public void setServico(Servicos servico) {
		this.servico = servico;
	}
	
	public void notificacao() {
		System.out.println("O instrumento " + instrumento.getNome() + " " + instrumento.getModelo() + " em nome do cliente " +
				cliente.getNome() + " está em " + instrumento.getEstado() + " para " + servico.getNome() + " e tem previsão de ser entregue dia " + 
				getEntrega() + ", segundo a ordem de serviço numero " + getNumero() + ", " + pecas.getNome() + " " + pecas.getMarca()
				);
	}
	

	
	
}
