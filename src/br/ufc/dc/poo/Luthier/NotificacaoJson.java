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

public class NotificacaoJson implements INotificacao {
	private File diretorio;
    private File arquivo;
    private Gson gson;
    private List<Notificacao> notificacoes;
    
    public NotificacaoJson() {
    	 this.gson = new Gson();
    	 notificacoes = new ArrayList<>();
    	 this.diretorio = new File("C:\\Users\\Documentos\\Desktop\\Notificacoes");
         if (!diretorio.exists()) {
             diretorio.mkdir();
         }
         this.arquivo = new File(diretorio, "Notificacoes.json");
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
	public void cadastrar(Notificacao notificacao) throws EQNException, ONFException {
		List<Notificacao> notificacoes = listar();
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
		try (FileWriter writer = new FileWriter(arquivo)) {
            gson.toJson(notificacoes, writer);
            writer.flush();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
	}

	@Override
	public void remover(String numero) throws ONFException {
		List<Notificacao> notificacoes = listar();
		boolean achou = false;
		for(int i = 0; i<notificacoes.size(); i++) {
			if(notificacoes.get(i).getOrdem().getNumero().equals(numero)) {
				achou = true;
				notificacoes.remove(i);
				break;
			}
		}
		
		try (FileWriter writer = new FileWriter(arquivo)) {
            gson.toJson(notificacoes, writer);
            writer.flush();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
		
		if(achou == false) {
			throw new ONFException(numero);
		}
		
	}

	@Override
	public Notificacao procurar(String numero) throws ONFException {
		List<Notificacao> notificacoes = listar();
		for(Notificacao noti : notificacoes) {
			if(noti.getOrdem().getNumero().equals(numero)) {
				return noti;
			}
		}
			throw new ONFException(numero);
		
	}
	

	@Override
	public List<Notificacao> listar() {
		
			List<Notificacao> listaNotificacoes = new ArrayList<>();
	        try {
	        	FileReader leitor = new FileReader(arquivo);
	            Type tipo = new TypeToken<ArrayList<Notificacao>>(){}.getType();
	            listaNotificacoes = gson.fromJson(leitor, tipo);  
	            if (listaNotificacoes == null) {
	            	listaNotificacoes = new ArrayList<>();
	            }
	        } 
	        catch (IOException e) {
	            e.printStackTrace();
	            
	        }
	        return listaNotificacoes;
	    
	
	}

}
