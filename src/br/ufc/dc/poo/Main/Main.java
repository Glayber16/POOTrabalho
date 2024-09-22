package br.ufc.dc.poo.Main;

import br.ufc.dc.poo.Clientes.Cliente;
import br.ufc.dc.poo.Clientes.ClienteJson;
import br.ufc.dc.poo.Clientes.ClienteList;
import br.ufc.dc.poo.Instrumentos.InstrumentosCorda;
import br.ufc.dc.poo.Luthier.OrdemDeServico;
import br.ufc.dc.poo.Luthier.OrdemDeServicoJson;

public class Main {

	public static void main(String[] args) {
		InstrumentosCorda instrumento = new InstrumentosCorda("Guitarra", "Yamaha", "Fender Americana Vintage");
		Cliente cliente = new Cliente("Glayber", "085", "8599164803");
		Cliente cliente2 = new Cliente("Bosco", "099", "999");
		System.out.println(cliente.getCPF());
		System.out.println(cliente.getTelefone());
		System.out.println(cliente.getNome());
		
		System.out.println(instrumento.getNome());
		System.out.println(instrumento.getModelo());
		System.out.println(instrumento.getMarca());
		System.out.println(instrumento.getTipo());
		cliente.adicionarInstrumento(instrumento);
		System.out.println(cliente.listar());;

		ClienteList lista = new ClienteList();
		lista.cadastrar(cliente);
		System.out.println(lista.listar());;
		lista.remover("085");
		System.out.println(lista.listar());;
		ClienteJson jcliente = new ClienteJson();
		jcliente.cadastrar(cliente);
		jcliente.cadastrar(cliente2);
		jcliente.remover("099");
		System.out.println(jcliente.procurar("085"));
		OrdemDeServico ordem = new OrdemDeServico(instrumento, cliente, "23004395", "30/09/2024", "não", "desempenar");
		System.out.println(ordem.getEntrega());
		OrdemDeServicoJson ordens = new OrdemDeServicoJson();
		
		instrumento.trocaEstado();
		ordens.cadastrar(ordem);
		ordem.getInstrumento().trocaEstado();
	}

}
