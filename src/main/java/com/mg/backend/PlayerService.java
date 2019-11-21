package com.mg.backend;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
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

    public Player put(Player player) {
        player.update();
        return player;
    }

    public void delete(String id) {
        repository.findById(id).delete();
    }

    public List<Player> findAllForClub(String query) {
        return repository.find("{'club': {'$regex': ?1, '$options': 'i'}}", query).list();
    }
}

