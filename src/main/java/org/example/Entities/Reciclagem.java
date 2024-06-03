package org.example.Entities;

import java.util.StringJoiner;

public class Reciclagem extends _BaseEntity {

    private int id_produto;
    private String titulo;
    private String cod_barras;
    private String thumbnail;
    private Material material_id;
    private Usuario usuario_id;

    public Reciclagem(){}

    public Reciclagem(int id_produto, String titulo, String cod_barras, String thumbnail, Material material_id, Usuario usuario_id) {
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

    public Material getMaterial_id() {
        return material_id;
    }

    public void setMaterial_id(Material material_id) {
        this.material_id = material_id;
    }

    public Usuario getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Usuario usuario_id) {
        this.usuario_id = usuario_id;
    }

    @Override
    public String toString() {
        return "Reciclagem{" +
                "id_produto=" + id_produto +
                ", titulo='" + titulo + '\'' +
                ", cod_barras='" + cod_barras + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", material_id=" + material_id +
                ", usuario_id=" + usuario_id +
                "} " + super.toString();
    }
}
