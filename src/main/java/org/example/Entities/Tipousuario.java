package org.example.Entities;

public class Tipousuario extends _BaseEntity {

    private String tipo;

    public Tipousuario(){}

    public Tipousuario(String tipo) {
        this.tipo = tipo;
    }

    public Tipousuario(int id_entidade, String tipo) {
        super(id_entidade);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Tipo_usuario{" +
                "tipo='" + tipo + '\'' +
                '}';
    }
}
