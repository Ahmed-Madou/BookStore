package com.springstore.models;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NonNull
    @Column(name = "USER_ID")
    private Long id;

    @Column(name = "USER_FIRSTNAME")
    private String firstName;

    @Column(name = "USER_LASTNAME")
    private String lastName;

    @Column(name = "USER_DATEOFBIRTH")
    private Date dateOfBirth;

    @Column(name = "USER_BUDGET")
    private double budget;

    @Column(name = "USER_GENDER")
    private String gender;

    public User(String firstName, String lastName, Date dateOfBirth,float budget, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.budget = budget;
        this.gender = gender;
    }

    public User() {
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateofBirth() {
        return dateOfBirth;
    }

    public void setDateofBirth(Date dateofBirth) {
        this.dateOfBirth = dateofBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return String.format("User[id= %d, First name= '%s', Last name= '%s', Date of birth= '%s', Gender= %s",
                id, firstName, lastName, dateOfBirth.toString(), gender);
    }
}

