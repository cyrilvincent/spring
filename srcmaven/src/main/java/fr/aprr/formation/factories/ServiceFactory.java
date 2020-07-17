package fr.aprr.formation.factories;

import fr.aprr.formation.repositories.MockBookRepository;
import fr.aprr.formation.services.IMainService;
import fr.aprr.formation.services.MainService;

public class ServiceFactory {

    public static IMainService factory() {
        MockBookRepository repo = new MockBookRepository();
        IMainService service = new MainService();
        return service;
    }
}
