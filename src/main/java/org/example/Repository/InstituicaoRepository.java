package org.example.Repository;

import org.example.Entities.Instituicao;
import org.example.Infrastructure.Loggable;

import java.util.List;

public class InstituicaoRepository implements Loggable<String>,_BaseRepository<Instituicao> {
    @Override
    public void Create(Instituicao entidade) {

    }

    @Override
    public List<Instituicao> Read() {
        return null;
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
