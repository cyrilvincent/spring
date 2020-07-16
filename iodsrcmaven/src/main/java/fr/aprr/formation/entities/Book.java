package fr.aprr.formation.entities;

import lombok.*;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode
@Entity
public class Book extends Media {

    private Integer nbPage = 0;

    public Book(int id, String title, double price) {
        super(id, title, price);
    }
    public Book(String title, double price, Integer nbPage) {
        this.setTitle(title);
        this.setPrice(price);
        this.nbPage = nbPage;
    }

    @Override
    public double getNetPrice() {
        return this.getPrice() * 1.055;
    }

}
