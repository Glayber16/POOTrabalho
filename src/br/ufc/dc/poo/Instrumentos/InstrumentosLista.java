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
	public void remover(String modelo) {
		for (int i = 0; i < instrumentos.size(); i++) {
	        if (instrumentos.get(i).getModelo().equals(modelo)) {
	            instrumentos.remove(i);
	            break;
            }
        }
		
	}

	@Override
	public Instrumentos procurar(String nome) {
		for(Instrumentos instrumento : instrumentos) {
			if(instrumento.getNome().equals(nome)) {
				return instrumento;
			}
				
		}
		return null;
	}

	@Override
	public List<Instrumentos> listar() {
		return instrumentos;
	}
	
	
}
