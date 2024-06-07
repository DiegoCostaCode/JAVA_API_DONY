package org.example.Repository;

import org.example.Entities.Instituicao;
import org.example.Config.Loggable;
import org.example.Entities.Reciclagem;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.example.Config.DatabaseConfiguration.getConnection;

public class InstituicaoRepository implements Loggable<String>,_BaseRepository<Instituicao> {
    @Override
    public void Create(Instituicao entidade) {
        Instituicao instituicao = new Instituicao();

        String sql = "INSERT INTO INSTITUICAO (ID,NOME,RESUMO,CNPJ,EMAIL_CORPORATIVO,POSTADOR_ID) VALUES (INSTITUICAO_SEQ.nextval,?,?,?,?,?)";

        try (Connection connection = getConnection();

             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, entidade.getNome_instituicao());
            ps.setString(2, entidade.getEmail_corporativo());
            ps.setString(3, entidade.getResumo());
            ps.setString(4,entidade.getCnpj());
            ps.setInt(5, entidade.getPostador_id().getId_entidade());


            int rowsAffected = ps.executeUpdate(); // Execute a atualização sem esperar por um resultado
            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int id = generatedKeys.getInt(1);
                        entidade.setId_entidade(id);
                        Loggable.logInfo("Instituição criada com sucesso! ID: " + id);
                    }}}

            Loggable.logInfo("Instituição criada!");

        } catch (SQLException e) {
            Loggable.logError("Não foi possível cadastrar instituição " + e.getMessage());
        }
    }

    @Override
    public List<Instituicao> Read() {
        String sql = "SELECT * FROM INSTITUICAO"; //Query SQL

        List<Instituicao> instituicoes = new ArrayList<>();

        try (Connection connection = getConnection();

             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()){

            while (rs.next()) {
                Instituicao instituicao = new Instituicao();

                instituicao.setId_entidade(rs.getInt("ID"));
                instituicao.setNome_instituicao(rs.getString("NOME"));
                instituicao.setEmail_corporativo(rs.getString("EMAIL"));
                instituicao.setCnpj(rs.getString("CNPJ"));
                instituicao.setResumo(rs.getString("RESUMO"));

                instituicoes.add(instituicao);

                Loggable.logInfo("Trazendo os instituição cadastrados!");
            }

        } catch (SQLException e) {
            Loggable.logError("Problema em executar a QUERY" + e.getMessage());
        }
        return instituicoes;
    }

    @Override
    public void Update(Instituicao entidade) {

    }

    @Override
    public void Delete(int id) {

    }

    @Override
    public Instituicao SearchById(int id) {
        return null;
    }
}
