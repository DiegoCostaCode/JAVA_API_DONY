package org.example.Repository;

import org.example.Entities._BaseEntity;

import java.util.List;

public interface _BaseRepository <T extends _BaseEntity> {
    void Create(T entidade);
    List<T> Read();
    void Update(T entidade);
    void Delete(int id);
    T SearchById(int id);
}
