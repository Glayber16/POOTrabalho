package br.ufc.dc.poo.Instrumentos;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class InstrumentosJson {
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
    
}
