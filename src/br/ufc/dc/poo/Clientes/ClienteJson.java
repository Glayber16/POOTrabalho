package br.ufc.dc.poo.Clientes;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;








public class ClienteJson implements IRepositorioCliente {
	private File diretorio;
    private File arquivo;
    private Gson gson;
    private List<Cliente> clientes;
    
    public ClienteJson() {
    	 gson = new Gson();
    	 clientes = new ArrayList<>();
    	 this.diretorio = new File("C:\\Users\\Documentos\\Desktop\\Clientes");
         if (!diretorio.exists()) {
             diretorio.mkdir();
         }
         this.arquivo = new File(diretorio, "Clientes.json");
         try {
             if (!arquivo.exists()) {
                 arquivo.createNewFile();
             }
         } 
         catch (IOException e) {
             e.printStackTrace();
         }
     }
    public void cadastrar(Cliente cliente) throws ACCException {
        List<Cliente> clientes = listar();
        boolean clienteExiste = false;

        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getCPF().equals(cliente.getCPF())) {
                clientes.set(i, cliente);
                clienteExiste = true;
                throw new ACCException(cliente.getCPF());
            }
        }

        if (!clienteExiste) {
            clientes.add(cliente);
        }

       
        try (FileWriter writer = new FileWriter(arquivo)) {
            gson.toJson(clientes, writer);
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public List<Cliente> listar() {
    	List<Cliente> listaClientes = new ArrayList<>();
        try {
        	FileReader leitor = new FileReader(arquivo);
            Type tipo = new TypeToken<ArrayList<Cliente>>(){}.getType();
            listaClientes = gson.fromJson(leitor, tipo);  
            if (listaClientes == null) {
                listaClientes = new ArrayList<>();
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
            
        }
        return listaClientes;
    }
	@Override
	public void remover(String CPF) throws CNFException {
		List<Cliente> clientes = listar();
		boolean achou = false;
		for (int i = 0; i < clientes.size(); i++) {
	        if (clientes.get(i).getCPF().equals(CPF)) {
	        	achou = true;
	            clientes.remove(i);
	            break;
            }
        }
		 
        try (FileWriter writer = new FileWriter(arquivo)) {
            gson.toJson(clientes, writer);
            writer.flush();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
        if(achou == false) {
        	throw new CNFException(CPF);
        }
	}
	@Override
	public Cliente procurar(String CPF) throws CNFException {
		List<Cliente> clientes = listar();
		for(Cliente cliente : clientes) {
			if(cliente.getCPF().equals(CPF)) {
				return cliente;
			}
		}
	      
		throw new CNFException(CPF);
	}

}
