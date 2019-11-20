package com.mg.backend;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class PlayerService {

    @Inject
    MongoClient mongoClient;

    public List<Player> list() {
        List<Player> list = new ArrayList<>();
        MongoCursor<Document> cursor = getCollection().find().iterator();

        try {
            while (cursor.hasNext()) {
                Document document = cursor.next();
                Player greeting = new Player();
                greeting.setFirstName(document.getString("firstName"));
                list.add(greeting);
            }
        } finally {
            cursor.close();
        }

        return list;

    }

    public void add(Player player) {
        Document document = new Document().append("firstName", player.getFirstName());
        getCollection().insertOne(document);
    }

    private MongoCollection<Document> getCollection() {
        return mongoClient.getDatabase("greeting").getCollection("greeting");
    }

    public String greeting(String name) {
        return "Hello " + name;
    }
}

