package com.mg.backend.greet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingService {

  @Autowired
  private MongoTemplate mongoOps;

  public List<Greeting> list() {
    return mongoOps.findAll(Greeting.class);
  }

  public void add(Greeting greeting) {
    mongoOps.insert(greeting);
  }

}
