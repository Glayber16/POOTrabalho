package br.ufc.dc.poo.Instrumentos;

import java.util.Scanner;

public class Instrumentos extends InstrumentosAbstrato{

	public Instrumentos(String nome, String marca, String modelo) {
		super(nome, marca, modelo);
	}
	public void trocaEstado() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Qual o estado do instrumento ? Recebido, Em Conserto, Em Manutenção, Pronto ou Em Fabricação");
		this.estado = scanner.nextLine();
	}
}
