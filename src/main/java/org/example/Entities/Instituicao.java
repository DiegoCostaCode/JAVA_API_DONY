package org.example.Entities;

public class Instituicao extends _BaseEntity{

    private String nome_instituicao;
    private String site;
    private Usuario representante_id;

    public Instituicao(){}

    public Instituicao(int id_entidade, String nome_instituicao, String site, Usuario representante_id) {
        super(id_entidade);
        this.nome_instituicao = nome_instituicao;
        this.site = site;
        this.representante_id = representante_id;
    }

    public String getNome_instituicao() {
        return nome_instituicao;
    }

    public void setNome_instituicao(String nome_instituicao) {
        this.nome_instituicao = nome_instituicao;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public Usuario getRepresentante_id() {
        return representante_id;
    }

    public void setRepresentante_id(Usuario representante_id) {
        this.representante_id = representante_id;
    }

    @Override
    public String toString() {
        return "Instituicao{" +
                "nome_instituicao='" + nome_instituicao + '\'' +
                ", site='" + site + '\'' +
                ", representante_id=" + representante_id +
                '}';
    }
}
