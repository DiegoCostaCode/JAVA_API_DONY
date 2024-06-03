package org.example.Repository;

import org.example.Entities.Noticia;
import org.example.Infrastructure.Loggable;

import java.util.List;

public class NoticiaRepository implements Loggable<String>,_BaseRepository<Noticia> {
    @Override
    public void Create(Noticia entidade) {

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
