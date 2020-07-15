package fr.aprr.formation.services;

import fr.aprr.formation.entities.Media;
import fr.aprr.formation.repositories.MockBookRepository;

import java.util.ArrayList;
import java.util.List;

public class MainService {

    private List<Media> cart = new ArrayList<>();
    private MockBookRepository repository;

    public MainService(MockBookRepository repository) {
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
}
