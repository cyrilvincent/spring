package fr.aprr.formation.services;

import fr.aprr.formation.repositories.CustomerJPARepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class CustomerJPAService {

    @Autowired
    CustomerJPARepository repository;
}
