package br.ufc.dc.poo.Instrumentos;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;



public class InstrumentosJson implements IRepositorioInstrumentos {
	private File diretorio;
    private File arquivo;
    private Gson gson;
    private List<Instrumentos> instrumento;
    
    public InstrumentosJson() {
    	 gson = new Gson();
         instrumento = new ArrayList<>();
         this.diretorio = new File("C:\\Users\\Documentos\\Desktop\\Instrumentos");
         if (!diretorio.exists()) {
             diretorio.mkdir();
         }
         this.arquivo = new File(diretorio, "Instrumentos.json");
         try {
             if (!arquivo.exists()) {
                 arquivo.createNewFile();
             }
         } 
         catch (IOException e) {
             e.printStackTrace();
         }
     }
    
    public void cadastrar(Instrumentos instrumento) {
        List<Instrumentos> instrumentos = listar();
        boolean instrumentoExiste = false;

        for (int i = 0; i < instrumentos.size(); i++) {
            if (instrumentos.get(i).getNome().equals(instrumento.getNome())) {
                instrumentos.set(i, instrumento);
                instrumentoExiste = true;
                break;
            }
        }

        if (!instrumentoExiste) {
            instrumentos.add(instrumento);
        }

       
        try (FileWriter writer = new FileWriter(arquivo)) {
            gson.toJson(instrumento, writer);
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public List<Instrumentos> listar() {
    	List<Instrumentos> listaInstrumentos = new ArrayList<>();
        try {
        	FileReader leitor = new FileReader(arquivo);
            Type tipo = new TypeToken<ArrayList<Instrumentos>>(){}.getType();
            listaInstrumentos = gson.fromJson(leitor, tipo);  
            if (listaInstrumentos == null) {
                listaInstrumentos = new ArrayList<>();
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
            
        }
        return listaInstrumentos;
    }
    
    public void remover(String nome) throws SNIException  {
		List<Instrumentos> listaInstrumentos = listar();
		boolean achou = false;
		for (int i = 0; i < listaInstrumentos.size(); i++) {
	        if (listaInstrumentos.get(i).getNome().equals(nome)) {
	        	achou = true;
	            listaInstrumentos.remove(i);
	            break;
            }
        }
		 
        try (FileWriter writer = new FileWriter(arquivo)) {
            gson.toJson(listaInstrumentos, writer);
            writer.flush();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
        
        if(achou == false) {
			throw new SNIException(nome);
		}
	}
	@Override
	public Instrumentos procurar(String nome) throws SNIException {
		List<Instrumentos> listaInstrumentos = listar();
		for(Instrumentos instrumento : listaInstrumentos) {
			if(instrumento.getNome().equals(nome)) {
				return instrumento;
			}
		}
	      
		throw new SNIException(nome);
	}



    
}
