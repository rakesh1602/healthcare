package com.practice.restapisingletable.controller;

import com.practice.restapisingletable.model.CricketPlayers;
import com.practice.restapisingletable.response.CricketPlayerResponse;
import com.practice.restapisingletable.service.CricketPlayersService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Log4j2
public class CricketPlayersController {

  @Autowired
  private CricketPlayersService cricketPlayersService;

    @PostMapping(path = "/players", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CricketPlayerResponse> createPerson(@RequestBody CricketPlayers cricketPlayers){
        CricketPlayerResponse cricketPlayerResponse= cricketPlayersService.createPlayers(cricketPlayers);
        return new ResponseEntity<>(cricketPlayerResponse, HttpStatus.CREATED);
    }

    @GetMapping(path="/players/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CricketPlayers> getPlayers(@PathVariable Long id) throws Exception {
        CricketPlayers cricketPlayers=cricketPlayersService.getPlayers(id);
        return new ResponseEntity<>(cricketPlayers, HttpStatus.OK);
    }

    @PutMapping(path = "/players/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CricketPlayers> updatePlayers(@PathVariable Long id, @RequestBody CricketPlayers cricketPlayers){
        cricketPlayers=cricketPlayersService.updatePlayers(id, cricketPlayers );
        return new ResponseEntity<>(cricketPlayers, HttpStatus.OK);
    }

    @DeleteMapping(path = "/players/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        cricketPlayersService.delete(id);
        return ResponseEntity.ok().build();
    }

}
