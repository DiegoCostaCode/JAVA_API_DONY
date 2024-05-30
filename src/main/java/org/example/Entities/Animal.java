package org.example.Entities;

import java.util.StringJoiner;

public class Animal {

    private int ID;
    private String Nome;
    private String Descricao;

    public Animal(){}

    public Animal(int ID, String nome, String descricao) {
        this.ID = ID;
        Nome = nome;
        Descricao = descricao;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Animal.class.getSimpleName() + "[", "]")
                .add("ID=" + ID)
                .add("Nome='" + Nome + "'")
                .add("Descricao='" + Descricao + "'")
                .toString();
    }
}
