package Main;

import Modelos.Conta;
import Modelos.Item;
import Modelos.TipoPrato;
import Modelos.PratosPrincipais;
import Modelos.Bebidas;
import Modelos.Sobremesas;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

import java.io.*;

import java.util.Map;
import java.awt.Menu;
import java.util.ArrayList;
import java.util.Arrays;

public class ControladorRestaurante {
	public static Map<Integer, Conta> contas;
	public static Map<Integer, Item> menu;
	public ControladorRestaurante() {
		ControladorRestaurante.contas = new HashMap<Integer, Conta>();
		ControladorRestaurante.menu = new HashMap<Integer, Item>();
	}

	public static void insere(int nMesa, int nPedido, TipoPrato tipo) {
		Conta atual = new Conta();
		Conta existe = contas.getOrDefault(nMesa, atual);
		existe.insere(nPedido, menu);

		if (existe.aberta) {
			if (existe.mesa == -1) {// mesa vazia
				System.out.println("Foi criada uma nova conta para esta mesa. \n");
				existe.mesa = nMesa;
			}
			contas.put(nMesa, existe);
			System.out.println("\n Pedido realizado com Sucesso");
		} else {
			System.out.println("O Item do pedido não existe no nosso Menu! \n");
		}
	}

	public void imprime() {
		Set<Integer> mesas = contas.keySet();
		boolean vazia = true;

		for (Integer mesa : mesas) {
			if (contas.get(mesa).aberta)
				vazia = false;
		}

		if (!vazia) {
			for (Integer numeroMesa : mesas) {// enhaced for
				if (contas.get(numeroMesa).aberta) {
					System.out.println(" -----------------");
					System.out.println("|" + "Numero da Mesa: " + contas.get(numeroMesa).mesa + "|");
					System.out.println(" -----------------");
					System.out.println("Valor Total: R$" + contas.get(numeroMesa).imprimeValorTotal());
					ArrayList<Item> temp = contas.get(numeroMesa).getVetor();//lista temporaria
					System.out.println("\nItens Consumidos:\n");
					for (Item item : temp) {
						System.out.println("-" + item.getNome());
					}
				}
				System.out.println("__________________");
			}
		} else
			System.out.println("Nenhum pedido feito ate o momento. \n");
	}

	public void remove(int nMesa) {
		Conta atual = new Conta();

		if (contas.getOrDefault(nMesa, atual).mesa == -1) {// mesa vazia
			System.out.println("A conta desta mesa ainda não está aberta. \n");
		} else {
			Conta nova = contas.get(nMesa);// ainda tem que fazer a função pra retornar o valor total
			System.out.println("Valor da Conta: " + nova.fechaConta());
			nova.destroiConta();

		}
	}

	public void atualizaMenuLista(int cod,String nome, int valor, TipoPrato tipo) {
		Item itens = new Item();
		itens.insere(nome, valor, cod, tipo);// aqui vai o itens.altera, insere é só para teste
		menu.put(cod, itens);
	}
	
	public void imprimeAux(){
		imprimePratosPrin(menu);
		imprimeSobremesas(menu);
		imprimeBebidas(menu);
	}
	public void imprimePratosPrin(Map<Integer, Item> menu){
		 System.out.println("PRATOS PRINCIPAIS \n");
		 
		 for (Integer chave : menu.keySet()) {
			 TipoPrato tipo = menu.get(chave).getTipo();
			 if(tipo == TipoPrato.P) {
	             String nome = menu.get(chave).getNome();
	             Integer codigo = menu.get(chave).getCodigo();
	             Integer valor = menu.get(chave).getPreco();
	             int tamanho = nome.length();
	             if(chave < 10) {
	            	 int cont = 0;
	            	 System.out.print(" "+ codigo + " " );
	            	 System.out.print(nome + "                              ");
	            	 while(cont < 30-tamanho){
	            		 System.out.print(" ");
	            		 cont++;
	            	 }
	            	 System.out.println("R$ " + valor + ".00");
	            	 
	             }
	             else {
	                	 int cont = 0;
	                	 System.out.print(codigo + " " );
	                	 System.out.print(nome + "                              ");
	                	 while(cont < 30-tamanho){
	                		 System.out.print(" ");
	                		 cont++;
	                	 }
	                	 System.out.println("R$ " + valor + ".00");
	            	 
	             }
		
			 }
		 }
		 System.out.println("\n");
	}
	public void imprimeSobremesas(Map<Integer, Item> menu) {
		 System.out.println("SOBREMESAS \n");
		 for (Integer chave : menu.keySet()) {
			 TipoPrato tipo = menu.get(chave).getTipo();
			 if(tipo == TipoPrato.S) {
	             String nome = menu.get(chave).getNome();
	             Integer codigo = menu.get(chave).getCodigo();
	             Integer valor = menu.get(chave).getPreco();
	             int tamanho = nome.length();
	             if(chave < 10) {
	            	 int cont = 0;
	            	 System.out.print(" "+ codigo + " " );
	            	 System.out.print(nome + "                              ");
	            	 while(cont < 30-tamanho){
	            		 System.out.print(" ");
	            		 cont++;
	            	 }
	            	 System.out.println("R$ " + valor + ".00");
	            	 
	             }
	             else {
	                	 int cont = 0;
	                	 System.out.print(codigo + " " );
	                	 System.out.print(nome + "                              ");
	                	 while(cont < 30-tamanho){
	                		 System.out.print(" ");
	                		 cont++;
	                	 }
	                	 System.out.println("R$ " + valor + ".00");
	            	 
	             }
		
			 }
		 }
	}
	
	public void imprimeBebidas(Map<Integer, Item> menu) {
		 System.out.println("\n");
		 System.out.println("BEBIDAS \n");
		 for (Integer chave : menu.keySet()) {
			 TipoPrato tipo = menu.get(chave).getTipo();
			 if(tipo == TipoPrato.B) {
	             String nome = menu.get(chave).getNome();
	             Integer codigo = menu.get(chave).getCodigo();
	             Integer valor = menu.get(chave).getPreco();
	             int tamanho = nome.length();
	             if(chave < 10) {
	            	 int cont = 0;
	            	 System.out.print(" "+ codigo + " " );
	            	 System.out.print(nome + "                              ");
	            	 while(cont < 30-tamanho){
	            		 System.out.print(" ");
	            		 cont++;
	            	 }
	            	 System.out.println("R$ " + valor + ".00");
	            	 
	             }
	             else {
	                	 int cont = 0;
	                	 System.out.print(codigo + " " );
	                	 System.out.print(nome + "                              ");
	                	 while(cont < 30-tamanho){
	                		 System.out.print(" ");
	                		 cont++;
	                	 }
	                	 System.out.println("R$ " + valor + ".00");
	            	 
	             }
		
			 }
		 }
	}
	
	public void finaliza() {
		geraXML(menu,contas);
	}
	
	public void inicia(){
		buscaArquivo();
		
	}
	
	public int qtdItens(int opcao) {
		int qtdOpcao = 0;
		if(opcao == 1) {
			PratosPrincipais pratos = new PratosPrincipais();
			imprimePratosPrin(menu);
			qtdOpcao = pratos.getQtdItens(menu);
		}else if(opcao == 2) {
			Sobremesas pratos = new Sobremesas();
			imprimeSobremesas(menu);
			qtdOpcao = pratos.getQtdItens(menu);
		}else if (opcao == 3 ){
			Bebidas drink = new Bebidas();
			imprimeBebidas(menu);
			qtdOpcao = drink.getQtdItens(menu);
		}
		return qtdOpcao;
		
	}
	
	public void geraXML(Map<Integer, Item> menu,Map<Integer, Conta> contas) {
		XStream gerador = new XStream(new DomDriver());
		XStream.setupDefaultSecurity(gerador);
		gerador.addPermission(AnyTypePermission.ANY);
		String xml = gerador.toXML(menu);
		XStream geradorConta = new XStream(new DomDriver());
		String xmlConta = geradorConta.toXML(contas);
		geraArquivo(xml,xmlConta);
		
	}
	
	public void buscaArquivo(){
		try {
			FileReader ler =  new FileReader("menu.xml");
			XStream leitor = new XStream(new DomDriver());
			FileReader ler2 =  new FileReader("contas.xml");
			XStream leitor2 = new XStream(new DomDriver());
			
			XStream.setupDefaultSecurity(leitor);
			leitor.addPermission(AnyTypePermission.ANY);
			XStream.setupDefaultSecurity(leitor2);
			leitor2.addPermission(AnyTypePermission.ANY);
			menu = (Map<Integer, Item>)leitor.fromXML(ler);
			contas = (Map<Integer, Conta>)leitor2.fromXML(ler2);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch blok
			//e.printStackTrace();
		}
		
	}
	
	public void geraArquivo(String xml, String xmlConta) {
		PrintWriter print = null;
		PrintWriter print2 = null;
		try {
			File arqMenu = new File("menu.xml");
			File arqConta = new File("contas.xml");
			print = new PrintWriter(arqMenu);
			print2 = new PrintWriter(arqConta);
			
			print.write(xml);
			print.flush();
			print.close();
			print2.write(xmlConta);
			print2.flush();
			print2.close();
		}
		catch(FileNotFoundException ex) {
			//Logger.getLogger(ControladorRestaurante.class.getName()).log(Level.SEVERE, null, ex);
		}
		finally {
			print.close();
		}
	}
	


}
