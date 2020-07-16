package fr.aprr.formation.services;

import fr.aprr.formation.entities.Book;
import fr.aprr.formation.entities.Customer;
import fr.aprr.formation.repositories.BookH2Repository;
import fr.aprr.formation.repositories.CustomerH2Repository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class H2BookFactory {

    @Autowired
    BookH2Repository repository;

    public void create() {
        repository.save(new Book("Java", 10, 100));
        repository.save(new Book("Python", 10, 100));
        repository.save(new Book("Java et Python", 10, 100));

        // fetch all customers
        log.info("Book found with findAll():");
        log.info("-------------------------------");
        for (Book b : repository.findAll()) {
            log.info(b.toString());
        }
        log.info("");

        // fetch an individual customer by ID
        Book book = repository.findById(6);
        log.info("Book found with findById(1):");
        log.info("--------------------------------");
        log.info(book.toString());
        log.info("");

        // fetch customers by last name
        log.info("Book found with findByTitleContainsIgnoreCase('java'):");
        log.info("--------------------------------------------");
        repository.findByTitleContainsIgnoreCase("java").forEach(b -> {
            log.info(b.toString());
        });

        log.info("Book found with findByPriceLessThan(15):");
        log.info("--------------------------------------------");
        repository.findByPriceLessThan(15).forEach(b -> {
            log.info(b.toString());
        });

    }
}
