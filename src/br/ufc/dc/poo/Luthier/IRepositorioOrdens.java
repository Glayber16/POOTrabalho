package br.ufc.dc.poo.Luthier;

import java.util.List;

import br.ufc.dc.poo.Clientes.Cliente;

import br.ufc.dc.poo.Instrumentos.InstrumentosAbstrato;

public interface IRepositorioOrdens {
	public void cadastrar(OrdemDeServico ordem);
	public void remover(String numero);
	public OrdemDeServico procurar(String numero);
	public List<OrdemDeServico> listar();
}
