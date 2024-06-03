package org.example.Entities;

import java.util.StringJoiner;

public class Instituicao extends Usuario{

    private int ID;
    private String NOME;
    private String SITE;
    private Usuario USUARIO_ID;

    public Instituicao(){}

    public Instituicao(int ID, String NOME, String SITE, Usuario USUARIO_ID) {
        this.ID = ID;
        this.NOME = NOME;
        this.SITE = SITE;
        this.USUARIO_ID = USUARIO_ID;
    }

    public Instituicao(int ID, String NOME, String EMAIL, String SENHA, String TIPO_USUARIO, int PONTOS, int ID1, String NOME1, String SITE, Usuario USUARIO_ID) {
        super(ID, NOME, EMAIL, SENHA, TIPO_USUARIO, PONTOS);
        this.ID = ID1;
        this.NOME = NOME1;
        this.SITE = SITE;
        this.USUARIO_ID = USUARIO_ID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNOME() {
        return NOME;
    }

    public void setNOME(String NOME) {
        this.NOME = NOME;
    }

    public String getSITE() {
        return SITE;
    }

    public void setSITE(String SITE) {
        this.SITE = SITE;
    }

    public Usuario getUSUARIO_ID() {
        return USUARIO_ID;
    }

    public void setUSUARIO_ID(Usuario USUARIO_ID) {
        this.USUARIO_ID = USUARIO_ID;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Instituicao.class.getSimpleName() + "[", "]")
                .add("ID=" + ID)
                .add("NOME='" + NOME + "'")
                .add("SITE='" + SITE + "'")
                .add("USUARIO_ID=" + USUARIO_ID)
                .toString();
    }
}
