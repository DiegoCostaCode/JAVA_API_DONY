package org.example.Repository;

import org.example.Entities.Instituicao;
import org.example.Entities.Projeto;
import org.example.Config.Loggable;
import org.example.Entities.Reciclagem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static org.example.Config.DatabaseConfiguration.getConnection;

public class ProjetoRepository implements Loggable<String>,_BaseRepository<Projeto> {
    @Override
    public void Create(Projeto entidade) {
        Projeto projeto = new Projeto();

        String sql = "INSERT INTO PROJETO(ID,TITULO,DESCRICAO,THUMBNAIL,INSTITUICAO_ID) VALUES (PROJETO_SEQ.nextval,?,?,?,?)";

        try (Connection connection = getConnection();

             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, entidade.getTitulo_projeto());
            ps.setString(2, entidade.getThumbnail());
            ps.setString(3, entidade.getDescricao_projeto());
            ps.setInt(5, entidade.getResponsavel_id().getId_entidade());


            int rowsAffected = ps.executeUpdate(); // Execute a atualização sem esperar por um resultado
            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int id = generatedKeys.getInt(1);
                        entidade.setId_entidade(id);
                        Loggable.logInfo("Projeto criado com sucesso! ID: " + id);
                    }}}

            Loggable.logInfo("Projeto criado!");

        } catch (SQLException e) {
            Loggable.logError("Não foi possível cadastrar projeto " + e.getMessage());
        }
    }

    @Override
    public List<Projeto> Read() {
        return null;
    }

    @Override
    public void Update(Projeto entidade) {

    }

    @Override
    public void Delete(int id) {

    }

    @Override
    public Projeto SearchById(int id) {
        Projeto projeto = new Projeto();

        try ( Connection connection = getConnection();
        )
        {
            String sql = "SELECT * FROM PROJETO WHERE ID = ?"; //Query SQL

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                projeto.setId_entidade(rs.getInt("ID"));
                projeto.setTitulo_projeto(rs.getString("TITULO"));
                projeto.setDescricao_projeto(rs.getString("DESCRICAO"));
                projeto.setThumbnail(rs.getString("THUMBNAIL"));

                Loggable.logInfo("Trazendo os produtos cadastrados!");
            }

        } catch (SQLException e) {
            Loggable.logError("Problema em executar a QUERY" + e.getMessage());
        }
        return projeto;
    }
    }