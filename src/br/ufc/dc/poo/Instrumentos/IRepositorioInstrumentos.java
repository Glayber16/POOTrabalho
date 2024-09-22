package br.ufc.dc.poo.Instrumentos;

import java.util.List;

public interface IRepositorioInstrumentos {
	public void cadastrar(Instrumentos instrumento);
	public void remover(String modelo);
	public Instrumentos procurar(String nome);
	public List<Instrumentos> listar();
}
