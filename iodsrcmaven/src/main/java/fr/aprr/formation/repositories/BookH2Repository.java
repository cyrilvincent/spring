package fr.aprr.formation.repositories;

import fr.aprr.formation.entities.Book;
import fr.aprr.formation.entities.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookH2Repository extends CrudRepository<Book, Integer> {

    Book findById(int id);

    List<Book> findByTitleContainsIgnoreCase(String title);

    List<Book> findByPriceLessThan(double price);

}
