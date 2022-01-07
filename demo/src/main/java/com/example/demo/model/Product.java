package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Product {

    private final UUID id;
    private final String name;
    private final int price;

    public Product(@JsonProperty("id") UUID id,
                   @JsonProperty ("name") String name,
                   @JsonProperty ("price") int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getprice() {
        return price;
    }
}
