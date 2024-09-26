package br.ufc.dc.poo.Luthier;

import java.util.List;

public interface INotificacao {
	public void cadastrar(Notificacao notificacao) throws EQNException, ONFException;
	public void remover (String numero) throws ONFException;
	public Notificacao procurar(String numero) throws ONFException;
	public List<Notificacao> listar();
}
