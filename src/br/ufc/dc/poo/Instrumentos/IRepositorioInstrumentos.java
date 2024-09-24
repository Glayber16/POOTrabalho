package br.ufc.dc.poo.Instrumentos;

import java.util.List;

public interface IRepositorioInstrumentos {
	public void cadastrar(Instrumentos instrumento);
	public void remover(String nome) throws SNIException;
	public Instrumentos procurar(String nome) throws SNIException;
	public List<Instrumentos> listar();
}
