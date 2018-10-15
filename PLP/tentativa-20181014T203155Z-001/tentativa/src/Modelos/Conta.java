package Modelos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Conta {
	private int valorTotal;
	public int mesa;
	private ArrayList<Item> vetor;
	public boolean aberta;

	public Conta() {
		this.mesa = -1;
		this.valorTotal = 0;
		vetor = new ArrayList<>();
		aberta = false;
	}

	public void insere(int nPedido, Map<Integer, Item> cardapio) {
		Item item = new Item();
		Item existe = cardapio.getOrDefault(nPedido, item);
		
		if (existe.getCodigo() != item.getCodigo()) {
			aberta = true;
			vetor.add(existe);
			valorTotal += existe.getPreco();
		}
	}

	public int fechaConta() {
		int tam = vetor.size();
		valorTotal = 0;
		for (int i = 0; i < tam; i++) {
			valorTotal += vetor.get(i).getPreco();
		}
		return valorTotal;
	}

	public void destroiConta() {
		this.mesa = -1;
		this.valorTotal = 0;
		vetor.clear();
		aberta = false;
	}

	public int imprimeValorTotal() {
		valorTotal = fechaConta();
		return valorTotal;
	}

	public ArrayList<Item> getVetor() {
		return vetor;
	}


}
