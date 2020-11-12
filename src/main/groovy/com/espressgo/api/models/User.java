package com.espressgo.api.models;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "user")
public class User {
    @Id
    public ObjectId id;
    public String email;
    public String displayName;
    public ArrayList<Message> messages = new ArrayList<>();
    public ArrayList<User> followees = new ArrayList<>();
    public ArrayList<User> followers = new ArrayList<>();

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }

    public void addMessage(Message message)
    {
        this.messages.add(message);
    }

    public ArrayList<User> getFollowees() {
        return followees;
    }

    public void setFollowees(ArrayList<User> followees) {
        this.followees = followees;
    }

    public void addFollowee(User user)
    {
        this.getFollowees().add(user);
    }

    public ArrayList<User> getFollowers() {
        return followers;
    }

    public void setFollowers(ArrayList<User> followers) {
        this.followers = followers;
    }

    public void addFollower(User user)
    {
        this.getFollowers().add(user);
    }
}