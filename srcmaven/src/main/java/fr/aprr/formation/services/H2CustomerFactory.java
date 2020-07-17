package fr.aprr.formation.services;

import fr.aprr.formation.entities.Customer;
import fr.aprr.formation.repositories.CustomerJPARepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class H2CustomerFactory {

    @Autowired
    CustomerJPARepository repository;

    public void create() {
        repository.save(new Customer("Jack", "Bauer"));
        repository.save(new Customer("Chloe", "O'Brian"));
        repository.save(new Customer("Kim", "Bauer"));
        repository.save(new Customer("David", "Palmer"));
        repository.save(new Customer("Michelle", "Dessler"));

        // fetch all customers
        log.info("Customers found with findAll():");
        log.info("-------------------------------");
        for (Customer customer : repository.findAll()) {
            log.info(customer.toString());
        }
        log.info("");

        // fetch an individual customer by ID
        Customer customer = repository.findById(1);
        log.info("Customer found with findById(1):");
        log.info("--------------------------------");
        log.info(customer.toString());
        log.info("");

        // fetch customers by last name
        log.info("Customer found with findByLname('Bauer'):");
        log.info("--------------------------------------------");
        repository.findByLname("Bauer").forEach(bauer -> {
            log.info(bauer.toString());
        });

    }
}
