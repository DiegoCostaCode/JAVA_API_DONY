package org.example.Repository;

import org.example.Entities.Reciclagem;
import org.example.Infrastructure.DatabaseConfiguration;
import org.example.Infrastructure.Loggable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ReciclagemRepository extends DatabaseConfiguration implements Loggable<String>, _BaseRepository<Reciclagem> {

    @Override
    public void Create(Reciclagem entidade) {

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
            String sql = "SELECT * FROM PRODUTO WHERE ID = ?"; //Query SQL

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                reciclagem.setId_produto(rs.getInt("ID"));
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
