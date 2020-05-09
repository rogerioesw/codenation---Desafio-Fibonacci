package br.com.codenation.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Jogador extends Entidade {

    private Long idTime;
    private Integer nivelHabilidade;
    private BigDecimal salario;

    public Jogador(Long id, String nome, LocalDate data, Long idTime, Integer nivelHabilidade, BigDecimal salario) {
        super(id, nome, data);
        this.idTime = idTime;
        this.nivelHabilidade = nivelHabilidade;
        this.salario = salario;
    }

//    public boolean checkParametros(Long id, String nome, LocalDate data, Long idTime, Integer nivelHabilidade, BigDecimal salario) {
//        return setId(id)&&setNome(nome)&&setData(data)&&setIdTime(idTime)&&setNivelHabilidade(nivelHabilidade)&&setSalario(salario);
//    }

    public Long getIdTime() {
        return idTime;
    }

    public Long setIdTime(Long idTime) {
        if(idTime.doubleValue()>0 && idTime!=null) {
            return this.idTime = idTime;
        }
        return idTime;
    }

    public Integer getNivelHabilidade() {
        return nivelHabilidade;
    }

    public Integer setNivelHabilidade(Integer nivelHabilidade) {
        if(nivelHabilidade>=0 && nivelHabilidade<=100 &&nivelHabilidade!=null) {
            return this.nivelHabilidade = nivelHabilidade;
        }
        return nivelHabilidade;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public BigDecimal setSalario(BigDecimal salario) {
        if(salario.doubleValue()>0 && salario!=null) {
            return this.salario = salario;
        }
        return salario;
    }
}
