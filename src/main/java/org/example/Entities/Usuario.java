package org.example.Entities;

import java.util.StringJoiner;

public class Usuario {

    private int id_usuario;
    private String nome_usuario;
    private String email_usuario;
    private String senha_usuario;
    private String tipo_usuario;
    private int pontos_usuario;

    public Usuario(){}

    public Usuario(int id_usuario, String nome_usuario, String email_usuario, String senha_usuario, String tipo_usuario, int pontos_usuario) {
        this.id_usuario = id_usuario;
        this.nome_usuario = nome_usuario;
        this.email_usuario = email_usuario;
        this.senha_usuario = senha_usuario;
        this.tipo_usuario = tipo_usuario;
        this.pontos_usuario = pontos_usuario;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public String getEmail_usuario() {
        return email_usuario;
    }

    public void setEmail_usuario(String email_usuario) {
        this.email_usuario = email_usuario;
    }

    public String getSenha_usuario() {
        return senha_usuario;
    }

    public void setSenha_usuario(String senha_usuario) {
        this.senha_usuario = senha_usuario;
    }

    public String getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public int getPontos_usuario() {
        return pontos_usuario;
    }

    public void setPontos_usuario(int pontos_usuario) {
        this.pontos_usuario = pontos_usuario;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Usuario.class.getSimpleName() + "[", "]")
                .add("id_usuario=" + id_usuario)
                .add("nome_usuario='" + nome_usuario + "'")
                .add("email_usuario='" + email_usuario + "'")
                .add("senha_usuario='" + senha_usuario + "'")
                .add("tipo_usuario='" + tipo_usuario + "'")
                .add("pontos_usuario=" + pontos_usuario)
                .toString();
    }
}
