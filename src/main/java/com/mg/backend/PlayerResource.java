package com.mg.backend;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/player")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PlayerResource {

    @Inject
    PlayerService service;

    @GET
    public List<Player> list() {
        return service.list();
    }

    @GET
    @Path("club")
    public List<Player> findClub(@QueryParam("q") String query) {
        return service.findAllForClub(query);
    }

    @POST
    public List<Player> add(Player player) {
        service.add(player);
        return list();
    }

    @PUT
    public Player put(Player player) {
        service.put(player);
        return player;
    }

    @DELETE
    @Path("{id}")
    public List<Player> delete(@PathParam String id) {
        service.delete(id);
        return list();
    }
}