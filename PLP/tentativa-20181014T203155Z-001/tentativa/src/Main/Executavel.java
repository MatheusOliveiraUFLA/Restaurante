package Main;

import java.util.Scanner;

import Modelos.TipoPrato;

public class Executavel {
	
	private static ControladorRestaurante controlador;
	
	

	public static void insere() {
		System.out.println("Digite o numero da mesa : \n");
		Scanner scanner = new Scanner(System.in);
		int nMesa = scanner.nextInt();
		System.out.println("Digite o numero do pedido: \n");
		int nPedido = scanner.nextInt(); // tenho numero da mesa
		 //carrega e mostra Lista de Pratos
		
		controlador.insere(nMesa,nPedido, TipoPrato.PD);
	}

	public static void imprime(){
		controlador.imprime();
	}
	
	public static void finaliza() {
		controlador.finaliza();
	}
	
	public static void fechaConta() {
		System.out.println("Digite o numero da mesa que deseja fechar a conta: \n");
		Scanner scanner = new Scanner(System.in);
		int i = scanner.nextInt();
		// carrega e mostra Lista de Pratos
		controlador.remove(i);
		System.out.println("\n Conta encerrada com Sucesso \n");
	}
	
	public static void atualizaMenu() {
		Scanner scanner = new Scanner(System.in);
		Scanner frase = new Scanner(System.in);
		System.out.println("Digite o codigo do prato : \n");
		int cod = scanner.nextInt();
		System.out.println("Digite o nome do prato : \n");
		String nome = frase.nextLine();
		System.out.println("Digite o valor do prato : \n");
		int valor = scanner.nextInt();
		TipoPrato tipo = null;
		System.out.println("Digite o tipo do prato : \n");
		System.out.println("1 para PRATOS PRINCIPAIS : \n");
		System.out.println("2 para SOBREMESA : \n");
		System.out.println("3 para BEBIDA : \n");
		
		int op = scanner.nextInt();

		switch(op) {
			case(1):
				tipo = TipoPrato.P;
				break;
			case(2):
				tipo = TipoPrato.S;
				break;
			case(3):
				tipo = TipoPrato.B;
				break;
		}

		
		
		controlador.atualizaMenuLista(cod,nome,valor,tipo);
	}
	
	public static void qtdPratos() {
		System.out.println("Digite a opcao desejada:");
		System.out.println("1- Pratos Principais");
		System.out.println("2- Sobremesas");
		System.out.println("3- Bebidas");
		Scanner scanner = new Scanner(System.in);
		int opcao = scanner.nextInt();
		
		int qtd = controlador.qtdItens(opcao);
		System.out.println( "A quantidade de pratos deste menu e : " + qtd);
	}
	
	public static void main(String[] args) {
		controlador = new ControladorRestaurante();
		controlador.inicia();
		int op = 0;
		Scanner scanner = new Scanner(System.in);
		while (op != 9) {
			System.out.println("\n Bem Vindo ao Restaurante do Hudson! \n");
			System.out.println("Digite a opcao desejada:");
			System.out.println("1- Inserir um novo pedido");
			System.out.println("2- Listar as contas atuais:");
			System.out.println("3- Fechar um conta existente");
			System.out.println("4- Atualizar Menu");
			System.out.println("5- Menu");
			System.out.println("9- Encerrar Programa \n");
			

			op = scanner.nextInt();

			switch(op) {
				case(1):
					controlador.imprimeAux();
					System.out.println("Digite a quantidade de pedidos que deseja fazer: \n");
					int qtdPedidos = scanner.nextInt();
					for (int i = 0; i < qtdPedidos; i++) {
						insere();
					}
					break;
				case(2):
					imprime();
					break;
				case(3):
					fechaConta();
					break;
				case(4):
					atualizaMenu();
					break;
				case(5):
					qtdPratos();
					break;
				
			}
		}
		finaliza();
		System.out.println("Volte Sempre! \n");
	}

}