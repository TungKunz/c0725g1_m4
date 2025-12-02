package org.example.sandwich.entity;


import java.util.List;

public class Order {
    private Integer id;
    private String sauces;
    private String seasoning;
    private String veggies;

    public Order() {
    }

    public Order(Integer id, String sauces, String seasoning, String veggies) {
        this.id = id;
        this.sauces = sauces;
        this.seasoning = seasoning;
        this.veggies = veggies;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSauces() {
        return sauces;
    }

    public void setSauces(String sauces) {
        this.sauces = sauces;
    }

    public String getSeasoning() {
        return seasoning;
    }

    public void setSeasoning(String seasoning) {
        this.seasoning = seasoning;
    }

    public String getVeggies() {
        return veggies;
    }

    public void setVeggies(String veggies) {
        this.veggies = veggies;
    }
}
