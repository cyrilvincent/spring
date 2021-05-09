package fr.aprr.formation.repositories;

import fr.aprr.formation.entities.Book;
import fr.aprr.formation.entities.IEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MockBookRepository implements IRepository<Book> {

    @Override
    public List<Book> getAll() {
        List<Book> res = new ArrayList<Book>();
        res.add(new Book(0,"Java",10));
        res.add(new Book(1,"Spring",20));
        return res;
    }

    @Override
    public Book getById(int id) {
        return new Book(0,"Java",10);
    }
}
