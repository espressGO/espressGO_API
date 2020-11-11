package com.espressgo.api.models;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "shop")
public class Shop {
    @Id
    public ObjectId id;
    public ArrayList<Drink> drinks;
    public ArrayList<Message> reviews;
    public String shopname;
    public String neighborhood;
    public String website;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shop_name) {
        this.shopname = shop_name;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public ArrayList<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(ArrayList<Drink> drinks) {
        this.drinks = drinks;
    }

    public ArrayList<Message> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<Message> reviews) {
        this.reviews = reviews;
    }

    public void addReview(Message review)
    {
        this.reviews.add(review);
    }
}
