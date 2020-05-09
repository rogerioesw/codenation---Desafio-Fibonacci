package br.com.codenation.entities;

import java.time.LocalDate;

public class Entidade {

    private Long id;
    private String nome;
    private LocalDate data;

    public Entidade(Long id, String nome, LocalDate data) {
        this.id = id;
        this.nome = nome;
        this.data = data;
    }

//    public boolean checkParametros(Long id, String nome, LocalDate data) {
//        return setId(id)&&setNome(nome)&&setData(data);
//    }

    public LocalDate getData() {
        return data;
    }

    public LocalDate setData(LocalDate data) {
        if(data!=null) {
            return this.data = data;
        }
        return data;
    }

    public Long getId() {
        return id;
    }

    public Long setId(Long id) {
        if((id.doubleValue()>0) && id!=null) {
            return this.id = id;
        }
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String setNome(String nome) {
        if(!nome.isEmpty()) {
            return this.nome = nome;
        }
        return nome;
    }
}
