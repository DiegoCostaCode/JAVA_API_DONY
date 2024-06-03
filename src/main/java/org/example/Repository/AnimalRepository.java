package org.example.Repository;

import org.example.Entities.Animal;
import org.example.Entities._BaseEntity;
import org.example.Infrastructure.Loggable;

import java.util.List;

public class AnimalRepository implements Loggable<String>, _BaseRepository<Animal> {
    @Override
    public void Create(Animal entidade) {

    }

    @Override
    public List<Animal> Read() {
        return null;
    }

    @Override
    public void Update(Animal entidade) {

    }

    @Override
    public void Delete(int id) {

    }

    @Override
    public Animal SearchById(int id) {
        return null;
    }
}
