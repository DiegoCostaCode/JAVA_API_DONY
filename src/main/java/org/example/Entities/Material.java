package org.example.Entities;

public class Material extends _BaseEntity{

    private String nome_material;
    private String descricao_material;
    private Float decomposicao;

    public Material(){}

    public Material(int id_entidade, String nome_material, String descricao_material, Float decomposicao) {
        super(id_entidade);
        this.nome_material = nome_material;
        this.descricao_material = descricao_material;
        this.decomposicao = decomposicao;
    }

    public String getNome_material() {
        return nome_material;
    }

    public void setNome_material(String nome_material) {
        this.nome_material = nome_material;
    }

    public String getDescricao_material() {
        return descricao_material;
    }

    public void setDescricao_material(String descricao_material) {
        this.descricao_material = descricao_material;
    }

    public Float getDecomposicao() {
        return decomposicao;
    }

    public void setDecomposicao(Float decomposicao) {
        this.decomposicao = decomposicao;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("org.example.Entities.Material{");
        sb.append("nome_material='").append(nome_material).append('\'');
        sb.append(", descricao_material='").append(descricao_material).append('\'');
        sb.append(", decomposicao=").append(decomposicao);
        sb.append('}');
        return sb.toString();
    }
}
