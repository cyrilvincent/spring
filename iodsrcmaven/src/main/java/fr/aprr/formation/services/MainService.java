package fr.aprr.formation.services;

import fr.aprr.formation.entities.Media;
import fr.aprr.formation.repositories.MockBookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MainService {

    private List<Media> cart = new ArrayList<>();


    private MockBookRepository repository;

    public MockBookRepository getRepository() {
        return repository;
    }

    public void setRepository(MockBookRepository repository) {
        this.repository = repository;
    }

    public double getTotalNetPrice() {
        //return cart.stream().map(b -> b.getNetPrice()).mapToDouble(b -> b).sum();
        double sum = 0;
        for(Media m : cart) {
            sum += m.getNetPrice();
        }
        return sum;
    }

    public List<Media> getCart() {
        return cart;
    }

    public boolean accessRepository() {
        return this.repository != null;
    }
}
