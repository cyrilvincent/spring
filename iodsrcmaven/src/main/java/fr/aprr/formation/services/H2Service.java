package fr.aprr.formation.services;

import fr.aprr.formation.entities.Book;
import fr.aprr.formation.entities.Media;
import fr.aprr.formation.repositories.BookH2Repository;
import fr.aprr.formation.repositories.MockBookRepository;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
@NoArgsConstructor
@ToString
public class H2Service {

    private List<Media> cart = new ArrayList<>();

    @Autowired
    private BookH2Repository repository;

    public void addToCart(int id) {
        Media b = repository.findById(id);
        cart.add(b);
    }

    public double getTotalNetPrice() {
        //return cart.stream().map(b -> b.getNetPrice()).mapToDouble(b -> b).sum();
        double sum = 0;
        for(Media m : cart) {
            sum += m.getNetPrice();
        }
        return sum;
    }

}
