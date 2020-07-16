package fr.aprr.formation.entities;

import jdk.jshell.spi.ExecutionControl;
import lombok.*;
import org.springframework.stereotype.Component;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Component
public class Customer implements IEntity {

    private int id;
    private String lname;
    private String fname;
    private String comment;


    @Override
    public double getNetPrice() throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Not implemented");
    }
}
