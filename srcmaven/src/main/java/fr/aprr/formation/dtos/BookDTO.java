package fr.aprr.formation.dtos;

import fr.aprr.formation.entities.Author;
import fr.aprr.formation.entities.Media;
import fr.aprr.formation.entities.Publisher;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
public class BookDTO {

    private int id;
    private String title;
    private double price;

}
