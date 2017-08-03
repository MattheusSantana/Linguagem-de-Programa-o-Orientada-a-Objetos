package entidades;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class main {

	public static void main(String[] args)  {
			
			ArrayList<Peca> lista = new ArrayList<Peca>();
			// Criando map para o relatório 2
			Map<String,NumeroPeso> relatorio2 = new HashMap<String,NumeroPeso>();
			
			String dados ;
			String regiao = "" ;
			String peso = "";
			String cidade_origem ;
			String estado_origem ;
			String fazenda ;
			
			try{
				BufferedReader bf =	new BufferedReader(new FileReader(new File("entrada")));
				try {
					while(bf.ready() != false){
						 dados = bf.readLine();
						 regiao = dados.split(",")[0];
						 peso = dados.split(",")[1];
						 cidade_origem = dados.split(",")[2];
						 estado_origem = dados.split(",")[3];
						 fazenda = dados.split(",")[4];
						Peca peca = new Peca(regiao, Double.parseDouble(peso), cidade_origem, estado_origem, fazenda);
						lista.add(peca);

						
						//Instânciando objeto para guardar os atributos numero e peso.
						
						
						//Verificando se já existe a chave.
						if(relatorio2.get(regiao) == null)
							relatorio2.put(regiao, new NumeroPeso(1, Double.parseDouble(peso)));
						
						/*Caso já tenha, incremente o peso e a quantidade*/
						else{
						    	NumeroPeso np = relatorio2.get(regiao);
								np.setPeso(np.getPeso() + Double.parseDouble(peso));
								np.setQuantidade(np.getQuantidade() + 1);
							}
						
						}
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//Relatório 1:
				//Collections.sort(lista);
				//System.out.println(lista);
				
				
			
				
				
			//Navegando pelo hashmap	
			for(String chave : relatorio2.keySet()){
				System.out.println(chave + "->" + relatorio2.get(chave));
			}
				
			} catch(FileNotFoundException e){
				System.out.println("Arquivo não encontrado!");
				System.out.println("Tchau!");
				System.exit(1);
			}



		}

}
