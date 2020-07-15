package fr.aprr.formation.entities;

public class Book extends Media {

    private int nbPage = 0;

    public Book(int id, String title, double price) {
        super(id, title, price);
    }
    public Book() {}

    @Override
    public double getNetPrice() {
        return this.getPrice() * 1.055;
    }

    public int getNbPage() {
        return nbPage;
    }

    public void setNbPage(int nbPage) {
        this.nbPage = nbPage;
    }
}
