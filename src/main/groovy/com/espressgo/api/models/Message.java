package com.espressgo.api.models;

import org.bson.types.ObjectId;

public class Message {
    public ObjectId userId;
    public ObjectId shopId;
    public ObjectId drinkId;
    public String comment;
    public Integer rating;

    public ObjectId getUserId() {
        return userId;
    }

    public void setUserId(ObjectId userId) {
        this.userId = userId;
    }

    public ObjectId getShopId() {
        return shopId;
    }

    public void setShopId(ObjectId shopId) {
        this.shopId = shopId;
    }

    public ObjectId getDrinkId() {
        return drinkId;
    }

    public void setDrinkId(ObjectId drinkId) {
        this.drinkId = drinkId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
