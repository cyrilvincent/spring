package fr.aprr.formation.services;

import fr.aprr.formation.entities.Media;
import fr.aprr.formation.repositories.MockBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MainService implements IMainService {

    private List<Media> cart = new ArrayList<>();

    @Autowired
    private MockBookRepository repository;

    @Override
    public MockBookRepository getRepository() {
        return repository;
    }

    @Override
    public void setRepository(MockBookRepository repository) {
        this.repository = repository;
    }

    @Override
    public double getTotalNetPrice() {
        //return cart.stream().map(b -> b.getNetPrice()).mapToDouble(b -> b).sum();
        double sum = 0;
        for(Media m : cart) {
            sum += m.getNetPrice();
        }
        return sum;
    }

    @Override
    public List<Media> getCart() {
        return cart;
    }

    @Override
    public boolean accessRepository() {
        return this.repository != null;
    }
}
