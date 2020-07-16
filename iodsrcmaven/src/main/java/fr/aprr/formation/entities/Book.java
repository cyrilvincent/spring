package fr.aprr.formation.entities;

import lombok.*;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Book extends Media {

    private Integer nbPage = 0;

    public Book(int id, String title, double price) {
        super(id, title, price);
    }

    @Override
    public double getNetPrice() {
        return this.getPrice() * 1.055;
    }

}
