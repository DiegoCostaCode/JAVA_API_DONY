package org.example.Entities;

public class Noticia extends _BaseEntity{

    private String titulo_noticia;
    private String conteudo;
    private String data_publicacao;
    private String fonte_noticia;
    private String thumbnail_noticia;

    public Noticia(){}

    public Noticia(int id_entidade, String titulo_noticia, String conteudo, String data_publicacao, String fonte_noticia, String thumbnail_noticia) {
        super(id_entidade);
        this.titulo_noticia = titulo_noticia;
        this.conteudo = conteudo;
        this.data_publicacao = data_publicacao;
        this.fonte_noticia = fonte_noticia;
        this.thumbnail_noticia = thumbnail_noticia;
    }

    public String getTitulo_noticia(String title) {
        return titulo_noticia;
    }

    public void setTitulo_noticia(String titulo_noticia) {
        this.titulo_noticia = titulo_noticia;
    }

    public String getConteudo(String description) {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getData_publicacao(String publishedAt) {
        return data_publicacao;
    }

    public void setData_publicacao(String data_publicacao) {
        this.data_publicacao = data_publicacao;
    }

    public String getFonte_noticia(String fonte) {
        return fonte_noticia;
    }

    public void setFonte_noticia(String fonte_noticia) {
        this.fonte_noticia = fonte_noticia;
    }


    public String getThumbnail_noticia(String thumbnail) {
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
                ", thumbnail_noticia='" + thumbnail_noticia + '\'' +
                '}';
    }
}
