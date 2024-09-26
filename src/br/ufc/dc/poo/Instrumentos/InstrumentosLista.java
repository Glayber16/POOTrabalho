package br.ufc.dc.poo.Instrumentos;

import java.util.ArrayList;
import java.util.List;

public class InstrumentosLista implements IRepositorioInstrumentos{
	private List<Instrumentos> instrumentos;

	public InstrumentosLista() {
		instrumentos = new ArrayList<>();
	}	

	@Override
	public void cadastrar(Instrumentos instrumento) {
		instrumentos.add(instrumento);
		
	}

	@Override
	public void remover(String nome) throws SNIException {
		 boolean achou = false;
		for (int i = 0; i < instrumentos.size(); i++) {
	        if (instrumentos.get(i).getNome().equals(nome)) {
	        	achou = true;
	            instrumentos.remove(i);
	            break;
            }
        }
		if(achou == false) {
			throw new SNIException(nome);
		}
		
		
		
	}

	@Override
	public Instrumentos procurar(String nome) throws SNIException {
		for(Instrumentos instrumento : instrumentos) {
			if(instrumento.getNome().equals(nome)) {
				return instrumento;
			}
				
		}
		throw new SNIException(nome);
	}

	@Override
	public List<Instrumentos> listar() {
		return instrumentos;
	}
	
	
}
