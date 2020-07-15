package fr.aprr.formation.factories;

import fr.aprr.formation.repositories.MockBookRepository;
import fr.aprr.formation.services.MainService;

public class ServiceFactory {

    public static MainService factory() {
        MockBookRepository repo = new MockBookRepository();
        MainService service = new MainService();
        return service;
    }
}
