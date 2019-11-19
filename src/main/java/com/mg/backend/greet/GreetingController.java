package com.mg.backend.greet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/greet")
public class GreetingController {

  @Autowired
  private GreetingService greetingService;

  @GetMapping("/")
  public List<Greeting> list() {
    return greetingService.list();
  }

  @PostMapping("/")
  public List<Greeting> add(@RequestBody Greeting greeting) {
    greetingService.add(greeting);
    return list();
  }

}
