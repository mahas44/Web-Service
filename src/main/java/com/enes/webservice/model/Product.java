package com.enes.webservice.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class Product {
    @Id
    private int _id;
    private String name;
    private int lastPrice;
    private String bidderName;

    public Product(int _id, String name, int lastPrice, String bidderName) {
        this._id = _id;
        this.name = name;
        this.lastPrice = lastPrice;
        this.bidderName = bidderName;
    }

    public int get_id() {
        return _id;
    }

    public int getLastPrice() {
        return lastPrice;
    }

    public String getBidderName() {
        return bidderName;
    }

    public String getName() {
        return name;
    }
}
