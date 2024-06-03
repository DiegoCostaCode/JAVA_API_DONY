package org.example.Repository;

import org.example.Entities.Material;
import org.example.Infrastructure.Loggable;

import java.util.List;

public class MaterialRepository implements Loggable<String>,_BaseRepository<Material> {
    @Override
    public void Create(Material entidade) {

    }

    @Override
    public List<Material> Read() {
        return null;
    }

    @Override
    public void Update(Material entidade) {

    }

    @Override
    public void Delete(int id) {

    }

    @Override
    public Material SearchById(int id) {
        return null;
    }
}
