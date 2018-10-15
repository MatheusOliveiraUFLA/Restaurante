package Modelos;

import java.util.HashMap;
import java.util.Map;
import Modelos.TipoPrato;

public class PratosPrincipais implements Menu{
		int qtdItens;
	
		public  PratosPrincipais (){
			 qtdItens = 0;
			
		}
		
		@Override
		public int getQtdItens(Map<Integer, Item> menu) {
			
			for (Integer chave : menu.keySet()) {
				 TipoPrato tipo = menu.get(chave).getTipo();
				 if(tipo == TipoPrato.P) {
					 qtdItens++;
				 }
			}
			return qtdItens;
			
	    }

		
}
