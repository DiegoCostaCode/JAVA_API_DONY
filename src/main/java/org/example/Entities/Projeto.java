package org.example.Entities;

import java.util.StringJoiner;

public class Projeto extends Instituicao{

    private int ID;
    private String TITULO;
    private String DESCRICAO;
    private Instituicao RESPONSAVEL_ID;

    public Projeto (){}

    public Projeto(int ID, String TITULO, String DESCRICAO, Instituicao RESPONSAVEL_ID) {
        this.ID = ID;
        this.TITULO = TITULO;
        this.DESCRICAO = DESCRICAO;
        this.RESPONSAVEL_ID = RESPONSAVEL_ID;
    }

    public Projeto(int ID, String NOME, String SITE, Usuario USUARIO_ID, int ID1, String TITULO, String DESCRICAO, Instituicao RESPONSAVEL_ID) {
        super(ID, NOME, SITE, USUARIO_ID);
        this.ID = ID1;
        this.TITULO = TITULO;
        this.DESCRICAO = DESCRICAO;
        this.RESPONSAVEL_ID = RESPONSAVEL_ID;
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

    public String getDESCRICAO() {
        return DESCRICAO;
    }

    public void setDESCRICAO(String DESCRICAO) {
        this.DESCRICAO = DESCRICAO;
    }

    public Instituicao getRESPONSAVEL_ID() {
        return RESPONSAVEL_ID;
    }

    public void setRESPONSAVEL_ID(Instituicao RESPONSAVEL_ID) {
        this.RESPONSAVEL_ID = RESPONSAVEL_ID;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Projeto.class.getSimpleName() + "[", "]")
                .add("ID=" + ID)
                .add("TITULO='" + TITULO + "'")
                .add("DESCRICAO='" + DESCRICAO + "'")
                .add("RESPONSAVEL_ID=" + RESPONSAVEL_ID)
                .toString();
    }
}
