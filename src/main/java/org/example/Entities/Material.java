package org.example.Entities;

import java.util.StringJoiner;

public class Material{

    private int ID;
    private String NOME;
    private String DESCRICAO;
    private String DECOMPOSICAO;

    public Material(){}

    public Material(int ID, String NOME, String DESCRICAO, String DECOMPOSICAO) {
        this.ID = ID;
        this.NOME = NOME;
        this.DESCRICAO = DESCRICAO;
        this.DECOMPOSICAO = DECOMPOSICAO;
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

    public String getDESCRICAO() {
        return DESCRICAO;
    }

    public void setDESCRICAO(String DESCRICAO) {
        this.DESCRICAO = DESCRICAO;
    }

    public String getDECOMPOSICAO() {
        return DECOMPOSICAO;
    }

    public void setDECOMPOSICAO(String DECOMPOSICAO) {
        this.DECOMPOSICAO = DECOMPOSICAO;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Material.class.getSimpleName() + "[", "]")
                .add("ID=" + ID)
                .add("NOME='" + NOME + "'")
                .add("DESCRICAO='" + DESCRICAO + "'")
                .add("DECOMPOSICAO='" + DECOMPOSICAO + "'")
                .toString();
    }
}
