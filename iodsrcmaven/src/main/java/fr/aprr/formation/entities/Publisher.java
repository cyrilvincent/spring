package fr.aprr.formation.entities;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "books")
@EqualsAndHashCode(exclude = "books")
@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @OneToMany
    private List<Book> books;

    public Publisher(String name) {
        this.name = name;
    }
}
