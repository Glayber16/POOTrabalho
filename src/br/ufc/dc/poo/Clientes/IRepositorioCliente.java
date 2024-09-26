package br.ufc.dc.poo.Clientes;

import java.util.List;

public interface IRepositorioCliente {
	public void cadastrar(Cliente cliente) throws ACCException;
	public void remover(String CPF) throws CNFException;
	public Cliente procurar(String CPF) throws CNFException;
	public List<Cliente> listar();
}
