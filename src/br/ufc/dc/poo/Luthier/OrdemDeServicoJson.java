package br.ufc.dc.poo.Luthier;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;



public class OrdemDeServicoJson implements IRepositorioOrdens{
	private File diretorio;
    private File arquivo;
    private Gson gson;
    private List<OrdemDeServico> ordens;
    
	public OrdemDeServicoJson() {
		 this.gson = new Gson();
    	 ordens = new ArrayList<>();
    	 this.diretorio = new File("C:\\Users\\Documentos\\Desktop\\Ordens");
         if (!diretorio.exists()) {
             diretorio.mkdir();
         }
         this.arquivo = new File(diretorio, "Ordens.json");
         try {
             if (!arquivo.exists()) {
                 arquivo.createNewFile();
             }
         } 
         catch (IOException e) {
             e.printStackTrace();
         }
     }
	
	
	@Override
	public void cadastrar(OrdemDeServico ordem) throws SOWException {
		List<OrdemDeServico> ordens = listar();
        boolean OrdemExiste = false;
        if(ordem.getCliente().getCPF().equals(ordem.getInstrumento().getDono().getCPF())) {
	        for (int i = 0; i < ordens.size(); i++) {
	            if (ordens.get(i).getNumero().equals(ordem.getNumero())) {
	                ordens.set(i, ordem);
	                OrdemExiste = true;
	                break;
	            }
	        }
	
	        if (!OrdemExiste) {
	            ordens.add(ordem);
	        }
	
	       
	        try (FileWriter writer = new FileWriter(arquivo)) {
	            gson.toJson(ordens, writer);
	            writer.flush();
	        } 
	        catch (IOException e) {
	            e.printStackTrace();
	        }
        }
        else {
        	throw new SOWException(ordem);
        }
	}

	@Override
	public void remover(String numero) throws ONException {
		List<OrdemDeServico> ordens = listar();
		boolean achou = false;

		for (int i = 0; i < ordens.size(); i++) {
	        if (ordens.get(i).getNumero().equals(numero)) {
	        	achou = true;
	            ordens.remove(i);
	            break;
            }
        }
		
		 
        try (FileWriter writer = new FileWriter(arquivo)) {
            gson.toJson(ordens, writer);
            writer.flush();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
        if(achou == false) {
			throw new ONException(numero);
		}
		
	}

	@Override
	public OrdemDeServico procurar(String numero) throws ONException {
		
		List<OrdemDeServico> ordens = listar();
			for(OrdemDeServico ordem : ordens) {
				if(ordem.getNumero().equals(numero)) {
					return ordem;
				}
			}
			
			throw new ONException(numero);
		
	}

	@Override
	public List<OrdemDeServico> listar() {
		List<OrdemDeServico> listaOrdens = new ArrayList<>();
        try {
        	FileReader leitor = new FileReader(arquivo);
            Type tipo = new TypeToken<ArrayList<OrdemDeServico>>(){}.getType();
            listaOrdens = gson.fromJson(leitor, tipo);  
            if (listaOrdens == null) {
            	listaOrdens = new ArrayList<>();
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
            
        }
        return listaOrdens;
    }
	

}
