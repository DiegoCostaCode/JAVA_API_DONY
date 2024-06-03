package org.example.Entities;

public class Noticia extends _BaseEntity{

    private String titulo_noticia;
    private String conteudo;
    private String data_publicacao;
    private String fonte_noticia;
    private Instituicao autor_id;
    private String thumbnail_noticia;

    public Noticia(){}

    public Noticia(int id_entidade, String titulo_noticia, String conteudo, String data_publicacao, String fonte_noticia, Instituicao autor_id, String thumbnail_noticia) {
        super(id_entidade);
        this.titulo_noticia = titulo_noticia;
        this.conteudo = conteudo;
        this.data_publicacao = data_publicacao;
        this.fonte_noticia = fonte_noticia;
        this.autor_id = autor_id;
        this.thumbnail_noticia = thumbnail_noticia;
    }

    public String getTitulo_noticia() {
        return titulo_noticia;
    }

    public void setTitulo_noticia(String titulo_noticia) {
        this.titulo_noticia = titulo_noticia;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getData_publicacao() {
        return data_publicacao;
    }

    public void setData_publicacao(String data_publicacao) {
        this.data_publicacao = data_publicacao;
    }

    public String getFonte_noticia() {
        return fonte_noticia;
    }

    public void setFonte_noticia(String fonte_noticia) {
        this.fonte_noticia = fonte_noticia;
    }

    public Instituicao getAutor_id() {
        return autor_id;
    }

    public void setAutor_id(Instituicao autor_id) {
        this.autor_id = autor_id;
    }

    public String getThumbnail_noticia() {
        return thumbnail_noticia;
    }

    public void setThumbnail_noticia(String thumbnail_noticia) {
        this.thumbnail_noticia = thumbnail_noticia;
    }

    @Override
    public String toString() {
        return "Noticia{" +
                "titulo_noticia='" + titulo_noticia + '\'' +
                ", conteudo='" + conteudo + '\'' +
                ", data_publicacao='" + data_publicacao + '\'' +
                ", fonte_noticia='" + fonte_noticia + '\'' +
                ", autor_id=" + autor_id +
                ", thumbnail_noticia='" + thumbnail_noticia + '\'' +
                '}';
    }
}
