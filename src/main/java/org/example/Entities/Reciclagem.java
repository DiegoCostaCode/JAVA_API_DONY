package org.example.Entities;

public class Reciclagem extends _BaseEntity {

    private String titulo;
    private String cod_barras;
    private String thumbnail;
    private Material material_id;
    private Usuario usuario_id;

    public Reciclagem(){}


    public Reciclagem(int id_entidade, String titulo, String cod_barras, String thumbnail, Material material_id, Usuario usuario_id) {
        super(id_entidade);
        this.titulo = titulo;
        this.cod_barras = cod_barras;
        this.thumbnail = thumbnail;
        this.material_id = material_id;
        this.usuario_id = usuario_id;
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
        final StringBuilder sb = new StringBuilder("org.example.Entities.Reciclagem{");
        sb.append("titulo='").append(titulo).append('\'');
        sb.append(", cod_barras='").append(cod_barras).append('\'');
        sb.append(", thumbnail='").append(thumbnail).append('\'');
        sb.append(", material_id=").append(material_id);
        sb.append(", usuario_id=").append(usuario_id);
        sb.append('}');
        return sb.toString();
    }
}
