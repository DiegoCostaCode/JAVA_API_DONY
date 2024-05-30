package org.example.Entities;

import java.util.StringJoiner;

public class Noticias extends Usuario{

    private int ID;
    private String TITULO;
    private String CONTEUDO;
    private String DATA_PUBLICACAO;
    private String FONTE;
    private Usuario AUTOR_ID;

    public Noticias (){}

    public Noticias(int ID, String TITULO, String CONTEUDO, String DATA_PUBLICACAO, String FONTE, Usuario AUTOR_ID) {
        this.ID = ID;
        this.TITULO = TITULO;
        this.CONTEUDO = CONTEUDO;
        this.DATA_PUBLICACAO = DATA_PUBLICACAO;
        this.FONTE = FONTE;
        this.AUTOR_ID = AUTOR_ID;
    }

    public Noticias(int ID, String NOME, String EMAIL, String SENHA, String TIPO_USUARIO, int PONTOS, int ID1, String TITULO, String CONTEUDO, String DATA_PUBLICACAO, String FONTE, Usuario AUTOR_ID) {
        super(ID, NOME, EMAIL, SENHA, TIPO_USUARIO, PONTOS);
        this.ID = ID1;
        this.TITULO = TITULO;
        this.CONTEUDO = CONTEUDO;
        this.DATA_PUBLICACAO = DATA_PUBLICACAO;
        this.FONTE = FONTE;
        this.AUTOR_ID = AUTOR_ID;
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTITULO() {
        return TITULO;
    }

    public void setTITULO(String TITULO) {
        this.TITULO = TITULO;
    }

    public String getCONTEUDO() {
        return CONTEUDO;
    }

    public void setCONTEUDO(String CONTEUDO) {
        this.CONTEUDO = CONTEUDO;
    }

    public String getDATA_PUBLICACAO() {
        return DATA_PUBLICACAO;
    }

    public void setDATA_PUBLICACAO(String DATA_PUBLICACAO) {
        this.DATA_PUBLICACAO = DATA_PUBLICACAO;
    }

    public String getFONTE() {
        return FONTE;
    }

    public void setFONTE(String FONTE) {
        this.FONTE = FONTE;
    }

    public Usuario getAUTOR_ID() {
        return AUTOR_ID;
    }

    public void setAUTOR_ID(Usuario AUTOR_ID) {
        this.AUTOR_ID = AUTOR_ID;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Noticias.class.getSimpleName() + "[", "]")
                .add("ID=" + ID)
                .add("TITULO='" + TITULO + "'")
                .add("CONTEUDO='" + CONTEUDO + "'")
                .add("DATA_PUBLICACAO='" + DATA_PUBLICACAO + "'")
                .add("FONTE='" + FONTE + "'")
                .add("AUTOR_ID=" + AUTOR_ID)
                .toString();
    }
}
