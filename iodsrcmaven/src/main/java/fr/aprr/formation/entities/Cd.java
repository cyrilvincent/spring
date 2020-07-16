package fr.aprr.formation.entities;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Cd extends Media {

    private int nbTrack;


    @Override
    public double getNetPrice() {
        return this.getPrice() * 1.2;
    }
}
