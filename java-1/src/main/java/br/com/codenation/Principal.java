package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Principal {

    public static void main(String[] args) {
        //LocalDate dataTime =

        DesafioMeuTimeApplication d = new DesafioMeuTimeApplication();
        d.incluirTime(4l, "Sao Paulo", LocalDate.of(1918, 4, 1), "Branco", "Vermelho");
        d.incluirTime(2l, "Palmeiras", LocalDate.of(1920, 4, 1), "Verde", "Branco");
        d.incluirTime(3l, "Flamengo", LocalDate.of(1902, 4, 1), "Branco", "Vermelho");

        d.incluirJogador(7l, 4l, "Rogerio ceni", LocalDate.of(1990, 12, 1), 80, BigDecimal.valueOf(100000.00));
        d.incluirJogador(2l, 4l, "Mineiro", LocalDate.of(1970, 12, 1), 70, BigDecimal.valueOf(400000.00));
        d.incluirJogador(3l, 4l, "Rai", LocalDate.of(1970, 12, 1), 50, BigDecimal.valueOf(400000.00));
        d.incluirJogador(4l, 4l, "Keirrison", LocalDate.of(1970, 12, 1), 75, BigDecimal.valueOf(400000.00));
        d.incluirJogador(5l, 3l, "Diego Alves", LocalDate.of(1984, 12, 1), 80, BigDecimal.valueOf(600000.00));
        d.incluirJogador(6l, 3l, "Filipe Luis", LocalDate.of(1990, 12, 1), 90, BigDecimal.valueOf(500000.00));

        //System.out.println(d.buscarNomeTime(1l));
        d.definirCapitao(7l);
        //d.definirCapitao(6l);
        //System.out.println(d.buscarJogadorMaisVelho(3l));
        //System.out.println(d.buscarJogadorMaiorSalario(4l));
        System.out.println(d.buscarCapitaoDoTime(3l));
        //System.out.println(d.buscarCapitaoDoTime(3l));
        //System.out.println(d.buscarNomeJogador(3l));
        //System.out.println(d.buscarJogadoresDoTime(3l));
        //System.out.println(d.buscarMelhorJogadorDoTime(4l));
        //System.out.println(d.buscarJogadorMaisVelho(4l));
        //System.out.println(d.buscarJogadorMaiorSalario(2l));
        //System.out.println(d.buscarTimes());
        //System.out.println(d.buscarTopJogadores(3));
        //System.out.println(d.buscarCorCamisaTimeDeFora(4l, 3l));
    }

}
