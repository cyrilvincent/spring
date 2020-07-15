package fr.aprr.formation.services;

import fr.aprr.formation.entities.Media;
import fr.aprr.formation.repositories.MockBookRepository;

import java.util.List;

public interface IMainService {
    MockBookRepository getRepository();

    void setRepository(MockBookRepository repository);

    double getTotalNetPrice();

    List<Media> getCart();

    boolean accessRepository();
}
