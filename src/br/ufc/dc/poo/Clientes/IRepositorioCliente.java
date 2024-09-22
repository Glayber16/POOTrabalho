package br.ufc.dc.poo.Clientes;

public interface IRepositorioCliente {
	public void cadastrar(Cliente cliente);
	public void remover(String CPF);
	public Cliente procurar(String CPF);
}
