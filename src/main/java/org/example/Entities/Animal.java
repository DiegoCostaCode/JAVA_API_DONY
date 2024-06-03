package org.example.Entities;

public class Animal extends _BaseEntity{

    private String nome_animal;
    private String descricao_animal;

    public Animal(){}

    public Animal(int id_entidade, String nome_animal, String descricao_animal) {
        super(id_entidade);
        this.nome_animal = nome_animal;
        this.descricao_animal = descricao_animal;
    }

    public String getNome_animal() {
        return nome_animal;
    }

    public void setNome_animal(String nome_animal) {
        this.nome_animal = nome_animal;
    }

    public String getDescricao_animal() {
        return descricao_animal;
    }

    public void setDescricao_animal(String descricao_animal) {
        this.descricao_animal = descricao_animal;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "nome_animal='" + nome_animal + '\'' +
                ", descricao_animal='" + descricao_animal + '\'' +
                "} " + super.toString();
    }
}
