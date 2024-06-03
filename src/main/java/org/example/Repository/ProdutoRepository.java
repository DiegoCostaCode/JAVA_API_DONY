package org.example.Repository;

import org.example.Entities.Produto;
import org.example.Entities.Usuario;
import org.example.Infrastructure.DatabaseConfiguration;
import org.example.Infrastructure.Loggable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoRepository extends DatabaseConfiguration implements Loggable<String> {

    public static Produto read(int id)
    {
        Produto produto = new Produto();

        try ( Connection connection = getConnection();
        )
        {
            String sql = "SELECT * FROM PRODUTO WHERE ID = ?"; //Query SQL

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                produto.setId_produto(rs.getInt("ID"));
                produto.setTitulo(rs.getString("TITULO"));
                produto.setCod_barras(rs.getString("COD_BARRAS"));
                produto.setThumbnail(rs.getString("THUMBNAIL"));

                Loggable.logInfo("Trazendo os produtos cadastrados!");
            }

        } catch (SQLException e) {
            Loggable.logError("Problema em executar a QUERY" + e.getMessage());
        }
        return produto;
    }

}
