package fr.aprr.formation.repositories;

import fr.aprr.formation.entities.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerJPARepository extends CrudRepository<Customer, Integer> {

    Customer findById(int id);

    List<Customer> findByLname(String lname);

}
