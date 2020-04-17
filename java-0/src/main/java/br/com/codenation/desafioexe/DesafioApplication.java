package br.com.codenation.desafioexe;

import java.util.List;
import java.util.ArrayList;

public class DesafioApplication {



	public static List<Integer> fibonacci() {
		List<Integer> lista = new ArrayList<Integer>();
		lista.add(0);
		lista.add(1);
		int i = 1;
		while (lista.get(i) < 350) {
			lista.add(lista.get(i)+lista.get(i-1));
			i++;
		}
		//lista.add(n1);
		//System.out.println("Tamanho da lista: "+lista.size());
		return lista;
	}

	public static Boolean isFibonacci(Integer a) {
		List<Integer> lista = new ArrayList<Integer>();
		lista = fibonacci();
		for(int i=0; i<lista.size(); i++) {
			if(a == Integer.parseInt(lista.get(i).toString())) {
				return true;
			}
		}
		return false;
	}

	public void mostraLista() {
		List<Integer> lista = new ArrayList<Integer>();
		lista = fibonacci();
		for(int i=0; i<lista.size(); i++) {
			System.out.println("Item "+lista.get(i));
		}
	}

}