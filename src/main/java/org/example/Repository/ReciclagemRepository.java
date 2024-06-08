package org.example.Repository;

import org.example.Entities.Reciclagem;
import org.example.Config.DatabaseConfiguration;
import org.example.Config.Loggable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ReciclagemRepository extends DatabaseConfiguration implements Loggable<String>, _BaseRepository<Reciclagem> {

    @Override
    public void Create(Reciclagem entidade) {

        String sql = "INSERT INTO RECICLAGEM (ID,TITULO,COD_BARRAS,THUMBNAIL,MATERIAL_ID,USUARIO_ID) VALUES (RECICLAGEM_SEQ.nextval,?,?,?,?,?)";

        try (Connection connection = getConnection();

             PreparedStatement ps = connection.prepareStatement(sql)) {


            ps.setString(1, entidade.getTitulo());
            ps.setString(2, entidade.getCod_barras());
            ps.setString(3, entidade.getThumbnail());
            ps.setInt(4, entidade.getMaterial_id().getId_entidade());
            ps.setInt(5, entidade.getUsuario_id().getId_entidade());


            int rowsAffected = ps.executeUpdate(); // Execute a atualização sem esperar por um resultado
            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int id = generatedKeys.getInt(1);
                        entidade.setId_entidade(id);
                        Loggable.logInfo("Usuario criada com sucesso! ID: " + id);
                    }}}

            Loggable.logInfo("Reciclagem criada!");

        } catch (SQLException e) {
            Loggable.logError("Não foi possível cadastrar reciclagem " + e.getMessage());
        }
    }

    @Override
    public List<Reciclagem> Read() {
        return null;
    }

    @Override
    public void Update(Reciclagem entidade) {

    }

    @Override
    public void Delete(int id) {

    }

    @Override
    public Reciclagem SearchById(int id) {

        Reciclagem reciclagem = new Reciclagem();

        try ( Connection connection = getConnection();
        )
        {
            String sql = "SELECT * FROM RECICLAGEM WHERE ID = ?"; //Query SQL

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {


                reciclagem.setId_entidade(rs.getInt("ID"));
                reciclagem.setTitulo(rs.getString("TITULO"));
                reciclagem.setCod_barras(rs.getString("COD_BARRAS"));
                reciclagem.setThumbnail(rs.getString("THUMBNAIL"));

                Loggable.logInfo("Trazendo os produtos cadastrados!");
            }

        } catch (SQLException e) {
            Loggable.logError("Problema em executar a QUERY" + e.getMessage());
        }
        return reciclagem;
    }
}
