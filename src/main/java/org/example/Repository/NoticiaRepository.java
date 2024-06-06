package org.example.Repository;

import org.example.Entities.Noticia;
import org.example.Entities.Reciclagem;
import org.example.Infrastructure.Loggable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static org.example.Infrastructure.DatabaseConfiguration.getConnection;

public class NoticiaRepository implements Loggable<String>,_BaseRepository<Noticia> {
    @Override
    public void Create(Noticia entidade) {
        Reciclagem reciclagem = new Reciclagem();

        String sql = "INSERT INTO NOTICIA (ID,TITULO,CONTEUDO,DATA_PUBLICACAO,FONTE,THUMBNAIL) VALUES (NOTICIA_SEQ.nextval,?,?,?,?,?)";

        try (Connection connection = getConnection();

             PreparedStatement ps = connection.prepareStatement(sql)) {


            ps.setString(1, entidade.getTitulo_noticia());
            ps.setString(2, entidade.getConteudo());
            ps.setString(3, entidade.getData_publicacao());
            ps.setString(4, entidade.getFonte_noticia());
            ps.setString(5, entidade.getThumbnail_noticia());


            int rowsAffected = ps.executeUpdate(); // Execute a atualização sem esperar por um resultado
            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int id = generatedKeys.getInt(1);
                        entidade.setId_entidade(id);
                        Loggable.logInfo("Noticia criada com sucesso! ID: " + id);
                    }}}

            Loggable.logInfo("Noticia criada!");

        } catch (SQLException e) {
            Loggable.logError("Não foi possível cadastrar a noticia " + e.getMessage());
        }
    }

    @Override
    public List<Noticia> Read() {
        return null;
    }

    @Override
    public void Update(Noticia entidade) {

    }

    @Override
    public void Delete(int id) {

    }

    @Override
    public Noticia SearchById(int id) {
        return null;
    }
}
