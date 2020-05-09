package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

import br.com.codenation.desafio.annotation.Desafio;
import br.com.codenation.desafio.app.MeuTimeInterface;
import br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.desafio.exceptions.TimeNaoEncontradoException;
import br.com.codenation.entities.Jogador;
import br.com.codenation.entities.Time;

public class DesafioMeuTimeApplication implements MeuTimeInterface {

    private HashMap<Long, Jogador> jogadores = new HashMap<>();
    private HashMap<Long, Time> times = new HashMap<>();


    private Time buscaTime(Long id) {
    	if(times.get(id) == null) {
			throw new TimeNaoEncontradoException();
		}
		return times.get(id);
    }

    private Jogador buscaJogador(Long id) {

    	if(jogadores.get(id) == null) {
			throw new JogadorNaoEncontradoException();
		}
    	return jogadores.get(id);
	}

	@Desafio("incluirTime")
	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {

    	if(times.containsKey(id)) {
    		throw new IdentificadorUtilizadoException();
		}

    	Time t = new Time(id,nome, dataCriacao, corUniformePrincipal, corUniformeSecundario);
    	times.put(id, t);

    }

	@Desafio("incluirJogador")
	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {

    	buscaTime(idTime);
    	if(jogadores.containsKey(id)) {
			throw new IdentificadorUtilizadoException();
		}

    	Jogador j = new Jogador(id, nome, dataNascimento, idTime, nivelHabilidade, salario);
    	jogadores.put(id, j);

	}

	@Desafio("definirCapitao")
	public void definirCapitao(Long idJogador) {
    	buscaJogador(idJogador);
    	buscaTime(jogadores.get(idJogador).getIdTime());
    	times.get(jogadores.get(idJogador).getIdTime()).setIdCapitao(jogadores.get(idJogador).getId());
	}

	@Desafio("buscarCapitaoDoTime")
	public Long buscarCapitaoDoTime(Long idTime) {
    	buscaTime(idTime);
    	if(times.get(idTime).getIdCapitao() == null) {
    		throw new CapitaoNaoInformadoException();
		}
    	return times.get(idTime).getIdCapitao();
	}

	@Desafio("buscarNomeJogador")
	public String buscarNomeJogador(Long idJogador) {
    	buscaJogador(idJogador);
    	return jogadores.get(idJogador).getNome();
	}

	@Desafio("buscarNomeTime")
	public String buscarNomeTime(Long idTime) {
    	buscaTime(idTime);
    	return times.get(idTime).getNome();
	}

	@Desafio("buscarJogadoresDoTime")
	public List<Long> buscarJogadoresDoTime(Long idTime) {
    	buscaTime(idTime);
    	return jogadores.values().stream()
				.filter(jogador -> jogador.getIdTime().equals(idTime))
				.map(Jogador::getId).sorted().collect(Collectors.toList());
	}

	@Desafio("buscarMelhorJogadorDoTime")
	public Long buscarMelhorJogadorDoTime(Long idTime) {
    	buscaTime(idTime);

    	return jogadores.values().stream()
				.filter(jogador -> jogador.getIdTime().equals(idTime))
				.sorted(Comparator.comparing(Jogador::getNivelHabilidade).reversed())
				.collect(Collectors.toList())
				.get(0).getId();
	}

	@Desafio("buscarJogadorMaisVelho")
	public Long buscarJogadorMaisVelho(Long idTime) {
		buscaTime(idTime);

		return jogadores.values().stream()
				.filter(jogador -> jogador.getIdTime().equals(idTime))
				.sorted(Comparator.comparing(Jogador::getData))
				.collect(Collectors.toList())
				.get(0).getId();
	}


	@Desafio("buscarTimes")
	public List<Long> buscarTimes() {
    	return times.keySet().stream().sorted().collect(Collectors.toList());
	}

	@Desafio("buscarJogadorMaiorSalario")
	public Long buscarJogadorMaiorSalario(Long idTime) {
		buscaTime(idTime);

		return Collections.max(jogadores.values().stream()
		.filter(jogador -> jogador.getIdTime().equals(idTime))
		.collect(Collectors.toList()), Comparator.comparing(Jogador::getSalario)).getId();

	}

	@Desafio("buscarSalarioDoJogador")
	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
    	buscaJogador(idJogador);

    	return jogadores.get(idJogador).getSalario();
	}

	@Desafio("buscarTopJogadores")
	public List<Long> buscarTopJogadores(Integer top) {
		List<Long> listaJogadores = new ArrayList<Long>();
    	if(!jogadores.isEmpty()) {
    		listaJogadores = jogadores.values().stream()
							.sorted(Comparator.comparing(Jogador::getNivelHabilidade).reversed())
							.map(Jogador::getId).collect(Collectors.toList())
							.subList(0, top);
    		return listaJogadores;
		} else {
    		return listaJogadores;
		}
	}

	@Desafio("buscarCorCamisaTimeDeFora")
	public String buscarCorCamisaTimeDeFora(Long timeDaCasa, Long timeDeFora) {
    	buscaTime(timeDaCasa);
    	buscaTime(timeDeFora);

    	Time timecasa = times.get(timeDaCasa);
    	Time timefora = times.get(timeDeFora);

    	if(timecasa.getCorUniformePrincipal().equals(timefora.getCorUniformePrincipal())) {
    		return timefora.getCorUniformeSecundario();
		} else {
    		return timefora.getCorUniformePrincipal();
		}

	}

}
