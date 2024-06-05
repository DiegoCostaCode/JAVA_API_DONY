package org.example.Entities;

public class Instituicao extends _BaseEntity{

    private String nome_instituicao;
    private Usuario postador_id;

    public Instituicao(){}

    public Instituicao(int id_entidade, String nome_instituicao, Usuario representante_id) {
        super(id_entidade);
        this.nome_instituicao = nome_instituicao;
        this.postador_id = postador_id;
    }

    public String getNome_instituicao(String sourceName) {
        return nome_instituicao;
    }

    public void setNome_instituicao(String nome_instituicao) {
        this.nome_instituicao = nome_instituicao;
    }


    public Usuario getRepresentante_id() {
        return postador_id;
    }

    public void setRepresentante_id(Usuario representante_id) {
        this.postador_id = representante_id;
    }

    @Override
    public String toString() {
        return "Instituicao{" +
                "nome_instituicao='" + nome_instituicao + '\'' +
                ", postador_id=" + postador_id +
                '}';
    }
}
