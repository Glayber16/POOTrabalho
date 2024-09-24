package br.ufc.dc.poo.Clientes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.ufc.dc.poo.Instrumentos.Instrumentos;
import br.ufc.dc.poo.Instrumentos.InstrumentosAbstrato;


public class Cliente {

	public String nome;
	public String CPF;
	public String telefone;
	public List <Instrumentos> instrumentos;
	
	public Cliente(String nome, String CPF, String telefone) {
		this.nome = nome;
		this.CPF = CPF;
		this.telefone = telefone;
		//Scanner scanner = new Scanner(System.in);
		//scanner.reset();
		//System.out.print("Digite o nome: ");
		//this.nome = scanner.nextLine();
		
		//System.out.print("Digite o seu CPF: ");
		//this.CPF = scanner.nextLine();
		
		//System.out.print("Digite o seu telefone: ");
		//this.telefone = scanner.nextLine();//
		
		instrumentos = new ArrayList<>();
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		nome = this.nome;
	}
	
	public String getCPF() {
		return CPF;
	}
	
	public void setCPF(String CPF) {
		CPF = this.CPF;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		telefone = this.telefone;
	}
	
	 public void adicionarInstrumento(Instrumentos instrumento) throws OWException {
		 if(instrumento.getDono().getCPF().equals(getCPF())) {
			 instrumentos.add(instrumento);
		 }
		 else {
			 throw new OWException(CPF);
		 }
	}
	
	public void removerInstrumento(String nome) throws NCException{
		for (int i = 0; i < instrumentos.size(); i++) {
	        if (instrumentos.get(i).getNome().equals(nome)) {
	            instrumentos.remove(i);
	            break;
            }
	        else {
	        	throw new NCException(nome);
	        }
        }
	
	}
	
	public List<Instrumentos> listar(){
		return instrumentos;
	}
	
	public Instrumentos procurar(String nome) throws NCException {
		for(Instrumentos instrumento : instrumentos) {
			if(instrumento.getNome().equals(nome)) {
				return instrumento;
			}
		}
		throw new NCException(nome);
		
	}
	
}
