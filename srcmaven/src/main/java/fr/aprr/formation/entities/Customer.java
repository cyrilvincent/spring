package fr.aprr.formation.entities;

import jdk.jshell.spi.ExecutionControl;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Component
@Entity
public class Customer implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String lname;
    private String fname;
    private String comment;

    public Customer(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
    }


    @Override
    public double getNetPrice() throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Not implemented");
    }
}
