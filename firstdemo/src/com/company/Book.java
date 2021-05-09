package com.company;

public class Book extends Media {

    private int nbPage = 0;

    public Book(int id, String title, double price, int nbPage) {
        super(id,title,price);
        this.nbPage = nbPage;
    }
    public Book(int id, String title, double price) {
        super(id,title,price);
    }

    @Override
    public double getNetPrice() {
        return this.getPrice() * 1.055;
    }
}
