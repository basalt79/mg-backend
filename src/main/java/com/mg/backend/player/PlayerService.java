package com.mg.backend.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.ws.rs.WebApplicationException;
import java.util.List;

@Service
public class PlayerService {

  @Autowired
  private PlayerRepository repo;

  @Autowired
  private MongoTemplate mongoOps;


  public List<Player> list() {
    return repo.findAll();
  }

  public List<Player> add(Player player) {
    repo.insert(player);
    return list();
  }

  public Player put(String id, Player player) {
    // I like the optional handling
    Player byId = repo.findById(id)
      .orElseThrow(() -> new WebApplicationException("No player found with id '" + id + "'", 404));

    // TODO i hate it
    byId.setFirstName(player.getFirstName());
    byId.setLastName(player.getLastName());
    byId.setClub(player.getClub());
    byId.setPosition(player.getPosition());
    byId.setShirtNumber(player.getShirtNumber());
    return repo.save(byId);
  }

  public void delete(String id) {
    Player p = repo.findById(id)
      .orElseThrow(() -> new WebApplicationException("No player found with id '" + id + "'", 404));
    repo.delete(p);
  }

  public List<Player> findAllForClub(String query) {
    Query q = new Query().addCriteria(Criteria.where("club").regex(query));
    return mongoOps.find(q, Player.class);
  }
}

