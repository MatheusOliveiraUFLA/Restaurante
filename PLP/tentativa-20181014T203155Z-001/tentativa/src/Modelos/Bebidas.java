package Modelos;

import java.util.Map;

public class Bebidas implements Menu {
	int qtdItens;
	
	public  Bebidas (){
		 qtdItens = 0;
		
	}
	
	@Override
	public int getQtdItens(Map<Integer, Item> menu) {
		
		for (Integer chave : menu.keySet()) {
			 TipoPrato tipo = menu.get(chave).getTipo();
			 if(tipo == TipoPrato.B) {
				 qtdItens++;
			 }
		}
		return qtdItens;
		
    }

}
