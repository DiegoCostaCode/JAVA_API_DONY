package org.example.Entities;

import java.util.StringJoiner;

public class Produto{

    private int id_produto;
    private String titulo;
    private String cod_barras;
    private String thumbnail;
    private int material_id;
    private int usuario_id;

    public Produto(){}

    public Produto(int id_produto, String titulo, String cod_barras, String thumbnail, int material_id, int usuario_id) {
        this.id_produto = id_produto;
        this.titulo = titulo;
        this.cod_barras = cod_barras;
        this.thumbnail = thumbnail;
        this.material_id = material_id;
        this.usuario_id = usuario_id;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCod_barras() {
        return cod_barras;
    }

    public void setCod_barras(String cod_barras) {
        this.cod_barras = cod_barras;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getMaterial_id() {
        return material_id;
    }

    public void setMaterial_id(int material_id) {
        this.material_id = material_id;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Produto.class.getSimpleName() + "[", "]")
                .add("id_produto=" + id_produto)
                .add("titulo='" + titulo + "'")
                .add("cod_barras='" + cod_barras + "'")
                .add("thumbnail='" + thumbnail + "'")
                .add("material_id=" + material_id)
                .add("usuario_id=" + usuario_id)
                .toString();
    }
}
