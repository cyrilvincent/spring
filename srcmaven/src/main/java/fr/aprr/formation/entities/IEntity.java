package fr.aprr.formation.entities;

import jdk.jshell.spi.ExecutionControl;

public interface IEntity {

    public int getId();
    public double getNetPrice() throws ExecutionControl.NotImplementedException;
}
