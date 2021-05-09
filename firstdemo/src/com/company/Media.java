package com.company;

import java.util.Objects;

public abstract class Media implements IMedia {

    private int id;
    private String title;
    private double price;

    public Media(int id, String title, double price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public Media() {}

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Media{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Media media = (Media) o;
        return id == media.id &&
                Double.compare(media.price, price) == 0 &&
                title.equals(media.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, price);
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public abstract double getNetPrice();
}
