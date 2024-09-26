package br.ufc.dc.poo.Luthier;

import java.util.ArrayList;
import java.util.List;

public class NotificacaoList implements INotificacao{
	private List<Notificacao> notificacoes;

	
	public NotificacaoList() {
		notificacoes = new ArrayList<>();
	}
	
	public void cadastrar(Notificacao notificacao) throws EQNException, ONFException {
		boolean mudancas = true;
		for(int i = 0; i<notificacoes.size(); i++) {
			if(notificacoes.get(i).getOrdem().getInstrumento().equals(notificacao.getOrdem().getInstrumento())) {
				if(notificacoes.get(i).getOrdem().getInstrumento().getEstado().equals(notificacao.getOrdem().getInstrumento().getEstado()) && notificacoes.get(i).getOrdem().getEntrega().equals(notificacao.getOrdem().getEntrega())) {
					mudancas = false;
					throw new EQNException(notificacao.getOrdem().getInstrumento().getEstado(), notificacao.getOrdem().getEntrega());					
				}
				else {
					remover(notificacoes.get(i).getOrdem().getNumero());
					notificacoes.add(notificacao);
					break;
				}
			}
		}
		if(mudancas == true) {
			notificacoes.add(notificacao);
		}
		
		
	}

	@Override
	public void remover(String numero) throws ONFException {
		boolean achou = false;
		for(int i = 0; i<notificacoes.size(); i++) {
			if(notificacoes.get(i).getOrdem().getNumero().equals(numero)) {
				achou = true;
				notificacoes.remove(i);
				break;
			}
		}
		
		if(achou == false) {
			throw new ONFException(numero);
		}
	}

	@Override
	public Notificacao procurar(String numero) throws ONFException {
		for(Notificacao noti : notificacoes) {
			if(noti.getOrdem().getNumero().equals(numero)) {
				return noti;
			}
		}
			throw new ONFException(numero);
		
	}
		

	@Override
	public List<Notificacao> listar() {
		// TODO Auto-generated method stub
		return notificacoes;
	}

}
