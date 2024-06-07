package org.example.Entities;

public class Instituicao extends _BaseEntity{

    private String nome_instituicao;
    private Usuario postador_id;

    private String email_corporativo;
    private String cnpj;
    private String resumo;

    public Instituicao(){}

    public Instituicao(int id_entidade, String nome_instituicao, Usuario postador_id, String email_corporativo, String cnpj, String resumo) {
        super(id_entidade);
        this.nome_instituicao = nome_instituicao;
        this.postador_id = postador_id;
        this.email_corporativo = email_corporativo;
        this.cnpj = cnpj;
        this.resumo = resumo;
    }

    public String getNome_instituicao() {
        return nome_instituicao;
    }

    public void setNome_instituicao(String nome_instituicao) {
        this.nome_instituicao = nome_instituicao;
    }

    public Usuario getPostador_id() {
        return postador_id;
    }

    public void setPostador_id(Usuario postador_id) {
        this.postador_id = postador_id;
    }

    public String getEmail_corporativo() {
        return email_corporativo;
    }

    public void setEmail_corporativo(String email_corporativo) {
        this.email_corporativo = email_corporativo;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    @Override
    public String toString() {
        return "Instituicao{" +
                "nome_instituicao='" + nome_instituicao + '\'' +
                ", postador_id=" + postador_id +
                '}';
    }
}
