package com.mg.backend;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;

@Path("/greet")
public class GreetingResource {

    @Inject
    GreetingService greetingService;
    
    @GET
    public List<Greeting> list() {
        return greetingService.list();
    }
    
    @POST
    public List<Greeting> add(Greeting greeting) {
        greetingService.add(greeting);
        return list();
    }
}