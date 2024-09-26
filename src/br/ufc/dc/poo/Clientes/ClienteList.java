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
	public void cadastrar(Cliente cliente) throws ACCException {
		
		List<Cliente> clientes = listar();
        boolean clienteExiste = false;

        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getCPF().equals(cliente.getCPF())) {
                clientes.set(i, cliente);
                clienteExiste = true;
                throw new ACCException(cliente.getCPF());
            }
        }

        if (!clienteExiste) {
            clientes.add(cliente);
        }

	}

	public void remover(String CPF) throws CNFException {
		boolean achou = false;
		 for (int i = 0; i < clientes.size(); i++) {
		        if (clientes.get(i).getCPF().equals(CPF)) {
		        	achou = true;
		            clientes.remove(i);
		            break;
	            }
	        }
		 if(achou == false) {
			 throw new CNFException(CPF);
		 }
		
	}
	
	public List<Cliente> listar() {
		return clientes;
	}
	
	public Cliente procurar(String CPF) throws CNFException {
		for(Cliente cliente : clientes) {
			if(cliente.getCPF().equals(CPF)) {
				return cliente;
			}
		}
		throw new CNFException(CPF);
	}
}
