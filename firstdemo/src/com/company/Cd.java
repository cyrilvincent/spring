package com.company;

public class Cd extends Media {

    private int nbTrack = 0;

    public Cd(int id, String title, double price, int nbTrack) {
        super(id, title, price);
        this.nbTrack = nbTrack;
    }

    public Cd(int id, String title, double price) {
        super(id, title, price);
    }

    @Override
    public double getNetPrice() {
        return this.getPrice() * 1.2;
    }
}
