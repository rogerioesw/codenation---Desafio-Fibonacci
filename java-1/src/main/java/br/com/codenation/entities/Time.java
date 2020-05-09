package br.com.codenation.entities;

import java.time.LocalDate;

public class Time extends Entidade {

    private String corUniformePrincipal;
    private String corUniformeSecundario;
    private Long idCapitao;

    public Time(Long id, String nome, LocalDate data, String corUniformePrincipal, String corUniformeSecundario) {
        super(id, nome, data);
        this.corUniformePrincipal = corUniformePrincipal;
        this.corUniformeSecundario = corUniformeSecundario;
        //this.idCapitao = idCapitao;
    }

//    public boolean checkParametros(Long id, String nome, LocalDate data, String corUniformePrincipal, String corUniformeSecundario) {
//        return setId(id)&&setNome(nome)&&setData(data)&&setCorUniformePrincipal(corUniformePrincipal)&&setCorUniformeSecundario(corUniformeSecundario);
//    }

    public String getCorUniformePrincipal() {
        return corUniformePrincipal;
    }

    public String setCorUniformePrincipal(String corUniformePrincipal) {
        if(!corUniformePrincipal.isEmpty() && corUniformePrincipal!=null) {
            return this.corUniformePrincipal = corUniformePrincipal;
        }
        return corUniformePrincipal;
    }

    public String getCorUniformeSecundario() {
        return corUniformeSecundario;
    }

    public String setCorUniformeSecundario(String corUniformeSecundario) {
        if(!corUniformeSecundario.isEmpty() && corUniformeSecundario!=null) {
            return this.corUniformeSecundario = corUniformeSecundario;
        }
        return corUniformeSecundario;
    }

    public Long getIdCapitao() {
        return idCapitao;
    }

    public void setIdCapitao(Long idCapitao) {
        this.idCapitao = idCapitao;
    }
}
