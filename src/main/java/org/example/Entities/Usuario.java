package org.example.Entities;

import java.util.StringJoiner;

public class Usuario {

    private int ID;
    private String NOME;
    private String EMAIL;
    private String SENHA;
    private String TIPO_USUARIO;
    private int PONTOS;

    public Usuario(){}

    public Usuario(int ID, String NOME, String EMAIL, String SENHA, String TIPO_USUARIO, int PONTOS) {
        this.ID = ID;
        this.NOME = NOME;
        this.EMAIL = EMAIL;
        this.SENHA = SENHA;
        this.TIPO_USUARIO = TIPO_USUARIO;
        this.PONTOS = PONTOS;
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

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getSENHA() {
        return SENHA;
    }

    public void setSENHA(String SENHA) {
        this.SENHA = SENHA;
    }

    public String getTIPO_USUARIO() {
        return TIPO_USUARIO;
    }

    public void setTIPO_USUARIO(String TIPO_USUARIO) {
        this.TIPO_USUARIO = TIPO_USUARIO;
    }

    public int getPONTOS() {
        return PONTOS;
    }

    public void setPONTOS(int PONTOS) {
        this.PONTOS = PONTOS;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Usuario.class.getSimpleName() + "[", "]")
                .add("ID=" + ID)
                .add("NOME='" + NOME + "'")
                .add("EMAIL='" + EMAIL + "'")
                .add("SENHA='" + SENHA + "'")
                .add("TIPO_USUARIO='" + TIPO_USUARIO + "'")
                .add("PONTOS=" + PONTOS)
                .toString();
    }
}
