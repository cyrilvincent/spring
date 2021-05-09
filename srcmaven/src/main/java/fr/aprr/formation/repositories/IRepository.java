package fr.aprr.formation.repositories;

import fr.aprr.formation.entities.IEntity;

import java.sql.SQLException;
import java.util.List;

public interface IRepository<T extends IEntity> {

    public List<T> getAll() throws SQLException;
    public T getById(int id) throws SQLException;

}
