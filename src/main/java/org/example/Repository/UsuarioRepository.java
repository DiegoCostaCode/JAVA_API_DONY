package org.example.Repository;

import org.example.Entities.Usuario;
import org.example.Infrastructure.DatabaseConfiguration;
import org.example.Infrastructure.Loggable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository extends DatabaseConfiguration implements Loggable<String>{

    public static Usuario create(Usuario usuario)
    {

        String sql = "INSERT INTO USUARIO (ID,NOME,EMAIL, SENHA,TIPO_USUARIO,PONTOS) VALUES (USUARIO_SEQ.nextval,?,?,?,?,?)";

        try (Connection connection = getConnection();

             PreparedStatement ps = connection.prepareStatement(sql)) {

            // Não é necessário definir um valor para a coluna ID, pois é gerado automaticamente pela sequência
            ps.setString(1, usuario.getNOME());
            ps.setString(2, usuario.getEMAIL());
            ps.setString(3, usuario.getSENHA());
            ps.setString(4, usuario.getTIPO_USUARIO());
            ps.setInt(5, usuario.getPONTOS());

            /*ps.executeUpdate(); // Execute a atualização sem esperar por um resultado*/

            int rowsAffected = ps.executeUpdate(); // Execute a atualização sem esperar por um resultado
            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int id = generatedKeys.getInt(1);
                        usuario.setID(id);
                        Loggable.logInfo("Usuario criada com sucesso! ID: " + id);
                        return usuario;
                    }}}

            Loggable.logInfo("Usuario criado!");

        } catch (SQLException e) {
            Loggable.logError("Não foi possível criar usuario " + e.getMessage());
            try {
                getConnection().close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        return null;// Retorna null ou lança uma exceção se necessário
    }

    public static List<Usuario> read()
    {
        String sql = "SELECT * FROM USUARIO"; //Query SQL

        List<Usuario> usuarios = new ArrayList<>();

        try ( Connection connection = getConnection();

                  PreparedStatement ps = connection.prepareStatement(sql);
                  ResultSet rs = ps.executeQuery();){

            while (rs.next()) {
                Usuario usuario = new Usuario();

                usuario.setID(rs.getInt("ID"));
                usuario.setNOME(rs.getString("NOME"));
                usuario.setEMAIL(rs.getString("EMAIL"));
                usuario.setSENHA(rs.getString("SENHA"));
                usuario.setTIPO_USUARIO(rs.getString("TIPO_USUARIO"));
                usuario.setPONTOS(rs.getInt("PONTOS"));

                usuarios.add(usuario);

                Loggable.logInfo("Trazendo os usuarios cadastrados!");
            }

        } catch (SQLException e) {
            Loggable.logError("Problema em executar a QUERY" + e.getMessage());
        }
        return usuarios;
    }
}
