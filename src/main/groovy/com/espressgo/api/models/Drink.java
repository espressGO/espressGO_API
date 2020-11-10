package com.espressgo.api.models;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "drink")
public class Drink {

    public enum Type{
        TEA, LATTE
    }
    @Id
    public ObjectId id;
    public ObjectId shopId;
    public String drink_name;
    public Type drink_type;
    public Double price;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public ObjectId getShopId() {
        return shopId;
    }

    public void setShopId(ObjectId shopId) {
        this.shopId = shopId;
    }

    public String getDrink_name() {
        return drink_name;
    }

    public void setDrink_name(String drink_name) {
        this.drink_name = drink_name;
    }

    public Type getDrink_type() {
        return drink_type;
    }

    public void setDrink_type(Type drink_type) {
        this.drink_type = drink_type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
