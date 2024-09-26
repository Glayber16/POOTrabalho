package br.ufc.dc.poo.Luthier;

public class Notificacao {
	private OrdemDeServico ordem;

	public Notificacao(OrdemDeServico ordem) {
		this.ordem = ordem;
	}

	public OrdemDeServico getOrdem() {
		return ordem;
	}

	public void setOrdem(OrdemDeServico ordem) {
		this.ordem = ordem;
	}
	
	public void notificar() {
		System.out.println("O instrumento " + ordem.getInstrumento().getNome() + " " + ordem.getInstrumento().getModelo() + " em nome do cliente " +
				ordem.getCliente().getNome() + " está em " + ordem.getInstrumento().getEstado() + " para " + ordem.getServico().getNome() + " e tem previsão de ser entregue dia " + 
				ordem.getEntrega() + ", segundo a ordem de serviço numero " + ordem.getNumero() + ", " + ordem.getPecas().getNome() + " " + ordem.getPecas().getMarca()
				);
		
	}
}
