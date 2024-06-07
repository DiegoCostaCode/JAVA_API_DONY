package org.example.Repository;

import org.example.Entities.Material;
import org.example.Entities.Usuario;
import org.example.Config.Loggable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.example.Config.DatabaseConfiguration.getConnection;

public class MaterialRepository implements Loggable<String>,_BaseRepository<Material> {
    @Override
    public void Create(Material entidade) {
        Usuario usuario = new Usuario();

        String sql = "INSERT INTO MATERIAL (ID, NOME, DESCRICAO, THUMBNAIL, DECOMPOSICAO) VALUES (MATERIAL_SEQ.nextval,?,?,?,?)";

        try (Connection connection = getConnection();

             PreparedStatement ps = connection.prepareStatement(sql)) {

            // Não é necessário definir um valor para a coluna ID, pois é gerado automaticamente pela sequência
            ps.setString(1, entidade.getNome_material());
            ps.setString(2, entidade.getDescricao_material());
            ps.setString(3, entidade.getThumbnail());
            ps.setFloat(4, entidade.getDecomposicao());

            /*ps.executeUpdate(); // Execute a atualização sem esperar por um resultado*/

            int rowsAffected = ps.executeUpdate(); // Execute a atualização sem esperar por um resultado
            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int id = generatedKeys.getInt(1);
                        entidade.setId_entidade(id);
                        Loggable.logInfo("Material criado com sucesso! ID: " + id);
                    }}}

            Loggable.logInfo("Material criado!");

        } catch (SQLException e) {
            Loggable.logError("Não foi possível criar o material " + e.getMessage());
        }
    }

    @Override
    public List<Material> Read() {
        String sql = "SELECT * FROM MATERIAL"; //Query SQL

        List<Material> materiais = new ArrayList<>();

        try (Connection connection = getConnection();

             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()){

            while (rs.next()) {
                Material material = new Material();

                material.setId_entidade(rs.getInt("ID"));
                material.setNome_material(rs.getString("NOME"));
                material.setDescricao_material(rs.getString("DESCRICAO"));
                material.setDecomposicao(rs.getFloat("DECOMPOSICAO"));
                material.setThumbnail(rs.getString("THUMBNAIL"));

                materiais.add(material);

                Loggable.logInfo("Trazendo os materiais cadastrados!");
            }

        } catch (SQLException e) {
            Loggable.logError("Problema em executar a QUERY" + e.getMessage());
        }
        return materiais;
    }

    @Override
    public void Update(Material entidade) {

    }

    @Override
    public void Delete(int id) {

    }

    @Override
    public Material SearchById(int id) {
        return null;
    }
}
