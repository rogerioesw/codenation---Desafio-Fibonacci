package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface MeuTimeInterface {

    void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario);

    void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario);

    void definirCapitao(Long idJogador);

    Long buscarCapitaoDoTime(Long idTime);

    String buscarNomeJogador(Long idJogador);

    String buscarNomeTime(Long idTime);

    List<Long> buscarJogadoresDoTime(Long idTime);

    Long buscarMelhorJogadorDoTime(Long idTime);

    Long buscarJogadorMaisVelho(Long idTime);

    List<Long> buscarTimes();

    Long buscarJogadorMaiorSalario(Long idTime);

    BigDecimal buscarSalarioDoJogador(Long idJogador);

    List<Long> buscarTopJogadores(Integer top);

    String buscarCorCamisaTimeDeFora(Long timeDaCasa, Long timeDeFora);

}
