package br.ufc.dc.poo.Luthier;

import java.util.ArrayList;
import java.util.List;

public class OrdemDeServicoList implements IRepositorioOrdens {
	private List<OrdemDeServico> ordens;
	
	public OrdemDeServicoList (){
		ordens = new ArrayList<>();
	}
	
	public void cadastrar(OrdemDeServico ordem) {
		ordens.add(ordem);
	}
	
	public void remover(String numero) {
		 for (int i = 0; i < ordens.size(); i++) {
		        if (ordens.get(i).getNumero().equals(numero)) {
		            ordens.remove(i);
		            break;
	            }
	        }
		
	}
	
	public OrdemDeServico procurar(String numero) {
		for(OrdemDeServico ordem : ordens) {
			if(ordem.getNumero().equals(numero)) {
				return ordem;
			}
		}
		return null;
	}
	
	public List<OrdemDeServico> listar(){
		return ordens;
	}

	
	
}
