package com.mg.backend;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;;

@ApplicationScoped
public class GreetingService {
    
    @Inject
    MongoClient mongoClient;
    
    public List<Greeting> list() {
        List<Greeting> list = new ArrayList<>();
        MongoCursor<Document> cursor = getCollection().find().iterator();
        
        try {
            while (cursor.hasNext()) {
                Document document = cursor.next();
                Greeting greeting = new Greeting();
                greeting.setName(document.getString("name"));
                list.add(greeting);
            }
        } finally {
            cursor.close();
        }
        
        return list;

    }

    public void add(Greeting greeting) {
        Document document = new Document().append("name", greeting.getName());
        getCollection().insertOne(document);
    }
    
    private MongoCollection<Document> getCollection() {
        return mongoClient.getDatabase("greeting").getCollection("greeting");
    }

    public String greeting(String name) {
        return "Hello " + name;
    }
}
