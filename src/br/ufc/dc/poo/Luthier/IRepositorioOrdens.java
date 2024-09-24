package br.ufc.dc.poo.Luthier;

import java.util.List;

import br.ufc.dc.poo.Clientes.Cliente;

import br.ufc.dc.poo.Instrumentos.InstrumentosAbstrato;

public interface IRepositorioOrdens {
	public void cadastrar(OrdemDeServico ordem) throws SOWException;
	public void remover(String numero) throws ONException;
	public OrdemDeServico procurar(String numero) throws ONException;
	public List<OrdemDeServico> listar();
}
