package br.ufc.dc.poo.Luthier;

import java.util.List;

import br.ufc.dc.poo.Clientes.Cliente;
import br.ufc.dc.poo.Clientes.IRepositorioCliente;

public class OrdemDeServicoIndependente{
	private IRepositorioCliente clientes;
	
	public OrdemDeServicoIndependente(IRepositorioCliente clientes) {
		this.clientes = clientes;
	}
	
	public void cadastrar(Cliente cliente) {
		clientes.cadastrar(cliente);
		
	}

	
	public void remover(String CPF) {
		clientes.remover(CPF);
		
	}

	
	public OrdemDeServico procurar(String numero) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<OrdemDeServico> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
