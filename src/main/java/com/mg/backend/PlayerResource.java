package com.mg.backend;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;

@Path("/player")
public class PlayerResource {

    @Inject
    PlayerService service;
    
    @GET
    public List<Player> list() {
        return service.list();
    }
    
    @POST
    public List<Player> add(Player player) {
        service.add(player);
        return list();
    }
}