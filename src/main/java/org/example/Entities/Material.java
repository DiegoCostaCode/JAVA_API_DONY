package org.example.Entities;

import org.glassfish.jersey.message.internal.MatchingEntityTag;

import java.util.StringJoiner;

public class Material extends Instituicao {

    private int id_material;
    private String nome;
    private String descricao_material;
    private String decomposicao;
    private Instituicao publicitario_id;

    public Material(){}

    public Material(int id_material, String nome, String descricao_material, String decomposicao, Instituicao publicitario_id) {
        this.id_material = id_material;
        this.nome = nome;
        this.descricao_material = descricao_material;
        this.decomposicao = decomposicao;
        this.publicitario_id = publicitario_id;
    }

    public int getId_material() {
        return id_material;
    }

    public void setId_material(int id_material) {
        this.id_material = id_material;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao_material() {
        return descricao_material;
    }

    public void setDescricao_material(String descricao_material) {
        this.descricao_material = descricao_material;
    }

    public String getDecomposicao() {
        return decomposicao;
    }

    public void setDecomposicao(String decomposicao) {
        this.decomposicao = decomposicao;
    }

    public Instituicao getPublicitario_id() {
        return publicitario_id;
    }

    public void setPublicitario_id(Instituicao publicitario_id) {
        this.publicitario_id = publicitario_id;
    }
    @Override
    public String toString() {
        return new StringJoiner(", ", Material.class.getSimpleName() + "[", "]")
                .add("id_material=" + id_material)
                .add("nome='" + nome + "'")
                .add("descricao_material='" + descricao_material + "'")
                .add("decomposicao='" + decomposicao + "'")
                .add("publicitario_id=" + publicitario_id)
                .toString();
    }
}
