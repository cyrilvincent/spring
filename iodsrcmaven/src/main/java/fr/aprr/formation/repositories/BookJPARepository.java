package fr.aprr.formation.repositories;

import fr.aprr.formation.entities.Book;
import fr.aprr.formation.entities.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookJPARepository extends CrudRepository<Book, Integer> {

    Book findById(int id);

    List<Book> findByTitleContainsIgnoreCase(String title);

    List<Book> findByPriceLessThan(double price);

    List<Book> findByPublisherId(int publisherId);

}
