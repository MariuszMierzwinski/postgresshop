package com.example.demo.models;

import javax.persistence.*;

@Entity(name = "Product")
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String size;
    private String colour;
    private Sex sex;
    private double price;
    private long quantity;
    private long reserved;
    @ManyToOne
    private Basket basket;
    @ManyToOne
    private Transaction transaction;
    private String picture;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", colour='" + colour + '\'' +
                ", sex='" + sex + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", reserved=" + reserved +
                ", basket=" + basket +
                ", transaction=" + transaction +
                ", picture='" + picture + '\'' +
                ", category=" + category +
                '}';
    }

    public Product() {
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Product(String name, String size, String colour, Sex sex, double price, long quantity, long reserved, String picture) {

        this.name = name;
        this.size = size;
        this.colour = colour;
        this.sex = sex;
        this.price = price;
        this.quantity = quantity;
        this.reserved = reserved;
        this.picture = picture;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long qantity) {
        this.quantity = qantity;
    }

    public long getReserved() {
        return reserved;
    }

    public void setReserved(long reserved) {
        this.reserved = reserved;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

}
