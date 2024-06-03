package org.example.Repository;

import org.example.Entities.Tipousuario;
import org.example.Infrastructure.Loggable;

import java.util.List;

public class TipousuarioRepository implements Loggable<String>,_BaseRepository<Tipousuario> {


    @Override
    public void Create(Tipousuario entidade) {

    }

    @Override
    public List<Tipousuario> Read() {
        return null;
    }

    @Override
    public void Update(Tipousuario entidade) {

    }

    @Override
    public void Delete(int id) {

    }

    @Override
    public Tipousuario SearchById(int id) {
        return null;
    }
}
