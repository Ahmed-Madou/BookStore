package com.springstore.models;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @NonNull
    @Column(name = "ORDER_ID")
    private Long id;

    @Column(name = "ORDER_OWNERID")
    private Long ownerId;

    @Column(name = "TOTAL_PRICE")
    private float totalPrice;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Book> orderBooks;

    public Order() {
    }

    public Order(Long ownerId,float totalPrice) {
        this.ownerId = ownerId;
        this.totalPrice = totalPrice;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public List<Book> getOrderBooks() {
        return orderBooks;
    }

    public void setOrderBooks(List<Book> orderBooks) {
        this.orderBooks = orderBooks;
    }
}
