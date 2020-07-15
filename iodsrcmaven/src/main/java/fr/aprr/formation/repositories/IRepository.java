package fr.aprr.formation.repositories;

import fr.aprr.formation.entities.IEntity;

import java.util.List;

public interface IRepository<T extends IEntity> {

    public List<T> getAll();
    public T getById(int id);

}
