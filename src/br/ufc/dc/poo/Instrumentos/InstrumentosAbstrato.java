package br.ufc.dc.poo.Instrumentos;

import java.util.Scanner;

public abstract class InstrumentosAbstrato {
	private String nome;
	private String marca;
	private String modelo;
	protected String tipo;
	public String estado;
	
	
	public InstrumentosAbstrato(String nome, String marca, String modelo) {
		this.nome = nome;
		this.marca = marca;
		this.modelo = modelo;
		//Scanner scanner = new Scanner(System.in);
		//scanner.reset();
		//System.out.print("Digite o nome do Instrumento: ");
		//this.nome = scanner.nextLine();
		
		//System.out.print("Digite a marca: ");
		//this.marca = scanner.nextLine();
		
		//System.out.print("Digite o modelo: ");
		//this.modelo = scanner.nextLine();
		
		//System.out.print("Digite o tipo: ");
		//this.tipo = scanner.nextLine();
		this.estado = "Recebido";
		
	}
	
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}

	
}
