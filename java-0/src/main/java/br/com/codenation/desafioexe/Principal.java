package br.com.codenation.desafioexe;

import java.util.List;
import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) {
        DesafioApplication de = new DesafioApplication();
        List<Integer> listaFibo = new ArrayList<Integer>();

        listaFibo = de.fibonacci();
        //System.out.println("Tamanho da lista: "+listaFibo.size());
        de.mostraLista();
        if(de.isFibonacci(20)) {
            System.out.println("Estou no fibonacci");
        }
        else {
            System.out.println("Não estou no fibonacci");
        }
    }

}