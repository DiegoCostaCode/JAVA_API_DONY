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

        String sql = "INSERT INTO USUARIO (ID, NOME, EMAIL, SENHA, TIPO_USUARIO, PONTOS) VALUES (USUARIO_SEQ.nextval,?,?,?,?,?)";

        try (Connection connection = getConnection();

             PreparedStatement ps = connection.prepareStatement(sql)) {

            // Não é necessário definir um valor para a coluna ID, pois é gerado automaticamente pela sequência
            ps.setString(1, usuario.getNome_usuario());
            ps.setString(2, usuario.getEmail_usuario());
            ps.setString(3, usuario.getSenha_usuario());
            ps.setString(4, usuario.getTipo_usuario());
            ps.setInt(5, usuario.getPontos_usuario());

            /*ps.executeUpdate(); // Execute a atualização sem esperar por um resultado*/

            int rowsAffected = ps.executeUpdate(); // Execute a atualização sem esperar por um resultado
            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int id = generatedKeys.getInt(1);
                        usuario.setId_usuario(id);
                        Loggable.logInfo("Usuario criada com sucesso! ID: " + id);
                        return usuario;
                    }}}

            Loggable.logInfo("Usuario criado!");

        } catch (SQLException e) {
            Loggable.logError("Não foi possível criar usuario " + e.getMessage());
        }
        return null;// Retorna null ou lança uma exceção se necessário
    }

    public static List<Usuario> read()
    {
        String sql = "SELECT * FROM USUARIO"; //Query SQL

        List<Usuario> usuarios = new ArrayList<>();

        try ( Connection connection = getConnection();

                  PreparedStatement ps = connection.prepareStatement(sql);
                  ResultSet rs = ps.executeQuery()){

            while (rs.next()) {
                Usuario usuario = new Usuario();

                usuario.setId_usuario(rs.getInt("ID"));
                usuario.setNome_usuario(rs.getString("NOME"));
                usuario.setEmail_usuario(rs.getString("EMAIL"));
                usuario.setSenha_usuario(rs.getString("SENHA"));
                usuario.setTipo_usuario(rs.getString("TIPO_USUARIO"));
                usuario.setPontos_usuario(rs.getInt("PONTOS"));

                usuarios.add(usuario);

                Loggable.logInfo("Trazendo os usuarios cadastrados!");
            }

        } catch (SQLException e) {
            Loggable.logError("Problema em executar a QUERY" + e.getMessage());
        }
        return usuarios;
    }
}
