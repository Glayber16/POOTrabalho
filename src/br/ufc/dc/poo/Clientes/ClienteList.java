package br.ufc.dc.poo.Clientes;

import java.util.ArrayList;
import java.util.List;

import br.ufc.dc.poo.Instrumentos.Instrumentos;
import br.ufc.dc.poo.Instrumentos.InstrumentosAbstrato;

public class ClienteList implements IRepositorioCliente {
	private List<Cliente> clientes;
	
	public ClienteList() {
		clientes = new ArrayList<>();
	}

	@Override
	public void cadastrar(Cliente cliente) {
		clientes.add(cliente);
	}

	public void remover(String CPF) {
		 for (int i = 0; i < clientes.size(); i++) {
		        if (clientes.get(i).getCPF().equals(CPF)) {
		            clientes.remove(i);
		            break;
	            }
	        }
		
	}
	
	public List<Cliente> listar() {
		return clientes;
	}
	
	public Cliente procurar(String CPF) {
		for(Cliente cliente : clientes) {
			if(cliente.getCPF().equals(CPF)) {
				return cliente;
			}
		}
		return null;
	}
}
