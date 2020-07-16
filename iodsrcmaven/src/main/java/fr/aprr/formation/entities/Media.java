package fr.aprr.formation.entities;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Media implements IEntity {

    private int id;
    private String title;
    private double price;


    public abstract double getNetPrice();

}
