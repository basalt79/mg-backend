package com.mg.backend.player;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/player")
public class PlayerResource {

  @Inject
  PlayerService service;

  @GetMapping
  public List<Player> list() {
    return service.list();
  }

  @GetMapping("club")
  public List<Player> findClub(@RequestParam("q") String query) {
    return service.findAllForClub(query);
  }

  @PostMapping
  public List<Player> add(@RequestBody Player player) {
    service.add(player);
    return list();
  }

  @PutMapping("/{id}")
  public Player put(@PathVariable("id") String id, @RequestBody Player player) {
    return service.put(id, player);
  }

  @DeleteMapping("/{id}")
  public List<Player> delete(@PathVariable("id") String id) {
    service.delete(id);
    return list();
  }
}
