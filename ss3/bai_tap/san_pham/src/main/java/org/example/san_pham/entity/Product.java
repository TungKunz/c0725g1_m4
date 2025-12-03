package org.example.san_pham.entity;

public class Product {
    private int id;
    private String name;
    private float price;
    private String nxs;

    public Product() {
    }

    public Product(int id, String name, float price, String nxs) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.nxs = nxs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getNxs() {
        return nxs;
    }

    public void setNxs(String nxs) {
        this.nxs = nxs;
    }
}
