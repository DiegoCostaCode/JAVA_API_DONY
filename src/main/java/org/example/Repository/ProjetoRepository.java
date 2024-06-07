package org.example.Repository;

import org.example.Entities.Projeto;
import org.example.Config.Loggable;

import java.util.List;

public class ProjetoRepository implements Loggable<String>,_BaseRepository<Projeto> {
    @Override
    public void Create(Projeto entidade) {

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
        return null;
    }
}
