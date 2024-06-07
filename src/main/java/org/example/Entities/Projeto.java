package org.example.Entities;

public class Projeto extends _BaseEntity{

    private String titulo_projeto;
    private String descricao_projeto;
    private String thumbnail;
    private Instituicao responsavel_id;

    public Projeto(){}

    public Projeto(int id_entidade, String titulo_projeto, String descricao_projeto, String thumbnail, Instituicao responsavel_id) {
        super(id_entidade);
        this.titulo_projeto = titulo_projeto;
        this.descricao_projeto = descricao_projeto;
        this.thumbnail = thumbnail;
        this.responsavel_id = responsavel_id;
    }

    public String getTitulo_projeto() {
        return titulo_projeto;
    }

    public void setTitulo_projeto(String titulo_projeto) {
        this.titulo_projeto = titulo_projeto;
    }

    public String getDescricao_projeto() {
        return descricao_projeto;
    }

    public void setDescricao_projeto(String descricao_projeto) {
        this.descricao_projeto = descricao_projeto;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Instituicao getResponsavel_id() {
        return responsavel_id;
    }

    public void setResponsavel_id(Instituicao responsavel_id) {
        this.responsavel_id = responsavel_id;
    }

    @Override
    public String toString() {
        return "Projeto{" +
                "titulo_projeto='" + titulo_projeto + '\'' +
                ", descricao_projeto='" + descricao_projeto + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", responsavel_id=" + responsavel_id +
                "} " + super.toString();
    }
}
