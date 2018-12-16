package com.springstore.models;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PROMOTIONS")
public class Promotion {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @NonNull
    @Column(name = "PROMOTION_ID")
    private Long id;

    @Column(name = "PROMOTION_PERCENTAGE")
    private double percentage;

    @Column(name = "BEGIN")
    private Date debut;

    @Column(name = "END")
    private Date fin;

    @ManyToOne(cascade = CascadeType.ALL)
    private Book book;

    public Promotion() {
    }

    public Promotion(double percentage, Date debut, Date fin, Book book) {
        this.percentage = percentage;
        this.debut = debut;
        this.fin = fin;
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public Date getDebut() {
        return debut;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
