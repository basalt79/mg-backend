package com.mg.backend;

import io.quarkus.mongodb.panache.PanacheMongoRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PlayerRepository implements PanacheMongoRepositoryBase<Player, String> {

    @Override
    public Player findById(String id) {
        return find("{'_id': {'$oid': ?1}}", id).singleResult();
    }
}
