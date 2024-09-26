package br.ufc.dc.poo.Main;

import br.ufc.dc.poo.Clientes.Cliente;

import br.ufc.dc.poo.Instrumentos.InstrumentosCorda;
import br.ufc.dc.poo.Instrumentos.InstrumentosSopro;
import br.ufc.dc.poo.Instrumentos.SVException;
import br.ufc.dc.poo.Luthier.EQNException;
import br.ufc.dc.poo.Luthier.IRepositorioOrdens;
import br.ufc.dc.poo.Luthier.Notificacao;
import br.ufc.dc.poo.Luthier.NotificacaoJson;
import br.ufc.dc.poo.Luthier.NotificacaoList;
import br.ufc.dc.poo.Luthier.ONException;
import br.ufc.dc.poo.Luthier.ONFException;
import br.ufc.dc.poo.Luthier.OrdemDeServico;
import br.ufc.dc.poo.Luthier.OrdemDeServicoJson;
import br.ufc.dc.poo.Luthier.Pecas;
import br.ufc.dc.poo.Luthier.SOWException;
import br.ufc.dc.poo.Luthier.Servicos;




public class Main {

	public static void main(String[] args) throws SOWException, SVException, EQNException, ONFException, ONException {
		
		Cliente cliente = new Cliente("Glayber", "085", "8599164803");
		Cliente cliente2 = new Cliente("Bosco", "099", "999");
		InstrumentosCorda instrumento = new InstrumentosCorda("Guitarra", "Yamaha", "Fender Americana Vintage", cliente);
		InstrumentosSopro instrumento1 = new InstrumentosSopro("Saxofone", "Yamaha", "Americano", cliente2);
		System.out.println(cliente.getCPF());
		System.out.println(cliente.getTelefone());
		System.out.println(cliente.getNome());
		
		System.out.println(instrumento.getNome());
		System.out.println(instrumento.getModelo());
		System.out.println(instrumento.getMarca());
		System.out.println(instrumento.getTipo());
		
		Pecas peca = new Pecas("Corda", "Famosa", 200);
		Servicos servico = new Servicos("Desempenar", 200);

		OrdemDeServico ordem = new OrdemDeServico(instrumento, cliente, "23004395", "30/09/2024", peca, servico);
		System.out.println(ordem.getEntrega());
		OrdemDeServicoJson ordens = new OrdemDeServicoJson();
		
		
		
		OrdemDeServico ordem2 = new OrdemDeServico(instrumento1, instrumento1.getDono(), "23004397" , "26/09/2024", peca, servico);
		Notificacao notificacao = new Notificacao(ordem);
		
		notificacao.notificar();
		NotificacaoJson Jnoti = new NotificacaoJson();
		
		
		System.out.println(Jnoti.procurar("23004395"));
		System.out.println(Jnoti.listar());
	}

}
