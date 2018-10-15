package Modelos;

import java.util.Map;

public class Sobremesas implements Menu {
	
	int qtdItens;
	
	public  Sobremesas (){
		 qtdItens = 0;
		
	}
	
	@Override
	public int getQtdItens(Map<Integer, Item> menu) {
		
		for (Integer chave : menu.keySet()) {
			 TipoPrato tipo = menu.get(chave).getTipo();
			 if(tipo == TipoPrato.S) {
				 qtdItens++;
			 }
		}
		return qtdItens;
		
    }
}
