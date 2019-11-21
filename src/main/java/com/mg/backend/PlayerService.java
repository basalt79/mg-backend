package com.mg.backend;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;
import java.util.List;

@ApplicationScoped
public class PlayerService {

    @Inject
    PlayerRepository repository;

    public List<Player> list() {
        return repository.listAll();
    }

    public List<Player> add(Player player) {
        player.persist();
        return list();
    }

    public Player put(String id, Player player) {
        Player byId = repository.findById(id);
        if (byId == null) {
            throw new WebApplicationException("No player found with id '" + id + "'", 404);
        }
        // TODO i hate it
        byId.setFirstName(player.getFirstName());
        byId.setLastName(player.getLastName());
        byId.setClub(player.getClub());
        byId.setPosition(player.getPosition());
        byId.setShirtNumber(player.getShirtNumber());

        player.update(byId);
        return repository.findById(id);
    }

    public void delete(String id) {
        Player byId = repository.findById(id);
        if (byId == null) {
            throw new WebApplicationException("No player found with id '" + id + "'", 404);
        }
        byId.delete();
    }

    public List<Player> findAllForClub(String query) {
        return repository.find("{'club': {'$regex': ?1, '$options': 'i'}}", query).list();
    }
}

