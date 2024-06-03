package org.example.Entities;

import java.util.StringJoiner;

public class Noticias extends Usuario{

    private int id_noticias;
    private String titulo_usuario;
    private String conteudo_noticias;
    private String data_publicacao_noticias;
    private String fonte_noticias;
    private Usuario autor_id_noticias;

    public Noticias (){}

    public Noticias(int id_noticias, String titulo_usuario, String conteudo_noticias, String data_publicacao_noticias, String fonte_noticias, Usuario autor_id_noticias) {
        this.id_noticias = id_noticias;
        this.titulo_usuario = titulo_usuario;
        this.conteudo_noticias = conteudo_noticias;
        this.data_publicacao_noticias = data_publicacao_noticias;
        this.fonte_noticias = fonte_noticias;
        this.autor_id_noticias = autor_id_noticias;
    }

    public Noticias(int id_noticias, String NOME, String EMAIL, String SENHA, String TIPO_USUARIO, int PONTOS, int id_noticias1, String titulo_usuario, String conteudo_noticias, String data_publicacao_noticias, String fonte_noticias, Usuario autor_id_noticias) {
        super(id_noticias, NOME, EMAIL, SENHA, TIPO_USUARIO, PONTOS);
        this.id_noticias = id_noticias1;
        this.titulo_usuario = titulo_usuario;
        this.conteudo_noticias = conteudo_noticias;
        this.data_publicacao_noticias = data_publicacao_noticias;
        this.fonte_noticias = fonte_noticias;
        this.autor_id_noticias = autor_id_noticias;
    }

    public int getId_noticias() {
        return id_noticias;
    }

    public void setId_noticias(int id_noticias) {
        this.id_noticias = id_noticias;
    }

    public String getTitulo_usuario() {
        return titulo_usuario;
    }

    public void setTitulo_usuario(String titulo_usuario) {
        this.titulo_usuario = titulo_usuario;
    }

    public String getConteudo_noticias() {
        return conteudo_noticias;
    }

    public void setConteudo_noticias(String conteudo_noticias) {
        this.conteudo_noticias = conteudo_noticias;
    }

    public String getData_publicacao_noticias() {
        return data_publicacao_noticias;
    }

    public void setData_publicacao_noticias(String data_publicacao_noticias) {
        this.data_publicacao_noticias = data_publicacao_noticias;
    }

    public String getFonte_noticias() {
        return fonte_noticias;
    }

    public void setFonte_noticias(String fonte_noticias) {
        this.fonte_noticias = fonte_noticias;
    }

    public Usuario getAutor_id_noticias() {
        return autor_id_noticias;
    }

    public void setAutor_id_noticias(Usuario autor_id_noticias) {
        this.autor_id_noticias = autor_id_noticias;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Noticias.class.getSimpleName() + "[", "]")
                .add("id_noticias=" + id_noticias)
                .add("titulo_usuario='" + titulo_usuario + "'")
                .add("conteudo_noticias='" + conteudo_noticias + "'")
                .add("data_publicacao_noticias='" + data_publicacao_noticias + "'")
                .add("fonte_noticias='" + fonte_noticias + "'")
                .add("autor_id_noticias=" + autor_id_noticias)
                .toString();
    }
}
