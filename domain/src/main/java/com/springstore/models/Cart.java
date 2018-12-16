package com.springstore.models;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CARTS")
public class Cart {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @NonNull
    @Column(name = "CART_ID")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    @Column(name = "TOTAL_PRICE")
    private float totalPrice;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Book> booksCarts;

    public Cart() {
    }

    public Cart(User user,float totalPrice) {
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Book> getBooksCarts() {
        return booksCarts;
    }

    public void setBooksCarts(List<Book> booksCarts) {
        this.booksCarts = booksCarts;
    }
}

