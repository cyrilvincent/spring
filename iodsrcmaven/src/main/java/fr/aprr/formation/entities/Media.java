package fr.aprr.formation.entities;

public abstract class Media implements IEntity {

    private int id;
    private String title;
    private double price;

    public Media(int id, String title, double price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }
    public Media() {}

    public abstract double getNetPrice();

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
