package com.springstore.models;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "BOOKS")
public class Book {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @NonNull
    @Column(name = "BOOK_ID")
    private Long id;

    @Column(name = "BOOK_NAME")
    private String name;

    @Column(name = "BOOK_AUTHOR")
    private String author;

    @Column(name = "BOOK_YEAR")
    private int year;

    @Column(name = "BOOK_PRICE")
    private double price;

    @Column(name = "QUANTITY")
    private int quantity;

    @ManyToMany(mappedBy = "booksCarts")
    private List<Cart> carts ;

    @ManyToMany(mappedBy = "orderBooks")
    private List<Order> orders;

    public Book() { }

    public Book(String name, String author, int year, double price,int quantity) {
        this.name = name;
        this.author = author;
        this.year = year;
        this.price = price;
        this.quantity =quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Cart> getCarts() {
        return carts;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
