package org.example.Entities;

public abstract class _BaseEntity {

    private int id_entidade;

    public _BaseEntity(){}

    public _BaseEntity(int id_entidade) {
        this.id_entidade = id_entidade;
    }

    public int getId_entidade() {
        return id_entidade;
    }

    public void setId_entidade(int id_entidade) {
        this.id_entidade = id_entidade;
    }

    @Override
    public String toString() {
        return "_BaseEntity{" +
                "id_entidade=" + id_entidade +
                '}';
    }
}
