package com.mg.backend.player;

import com.mg.backend.Position;
import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;

@MongoEntity(collection = "player")
public class Player extends PanacheMongoEntity {

    private String firstName;
    private String lastName;
    private String club;
    private int shirtNumber;
    private Position position;

    public Player() {

    }

    public String getFirstName() {
        return firstName;
    }

    public Player setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Player setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getClub() {
        return club;
    }

    public Player setClub(String club) {
        this.club = club;
        return this;
    }

    public int getShirtNumber() {
        return shirtNumber;
    }

    public Player setShirtNumber(int shirtNumber) {
        this.shirtNumber = shirtNumber;
        return this;
    }

    public Position getPosition() {
        return position;
    }

    public Player setPosition(Position position) {
        this.position = position;
        return this;
    }
}
