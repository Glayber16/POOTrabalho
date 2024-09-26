package br.ufc.dc.poo.Instrumentos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.ufc.dc.poo.Clientes.Cliente;

public class Instrumentos extends InstrumentosAbstrato{
	private static List<String> estadosPermitidos;
	static {
		estadosPermitidos = new ArrayList<>();
		estadosPermitidos.add("Recebido");
		estadosPermitidos.add("Em Conserto");
		estadosPermitidos.add("Em Manutenção");
		estadosPermitidos.add("Pronto");
		estadosPermitidos.add("Em Fabricação");
	}
	
	public Instrumentos(String nome, String marca, String modelo, Cliente dono) {
		super(nome, marca, modelo, dono);
		
	}
	public void trocaEstado() throws SVException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Qual o estado do instrumento ? Recebido, Em Conserto, Em Manutenção, Pronto ou Em Fabricação");
		String resposta = scanner.nextLine();
		if(estadosPermitidos.contains(resposta)) {
			this.estado = resposta;
			System.out.println("Estado alterado!!");
		}
		else {
			throw new SVException(resposta);
		}
		
		
	}
	
	public static List<String> getEstadosPermitidos() {
		return estadosPermitidos;
	}
	public static void setEstadosPermitidos(List<String> estadosPermitidos) {
		Instrumentos.estadosPermitidos = estadosPermitidos;
	}
	
}
