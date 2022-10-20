package com.practice.restapisingletable.service;

import com.practice.restapisingletable.entity.CricketPlayerEntity;
import com.practice.restapisingletable.mapper.CricketPlayerMapper;
import com.practice.restapisingletable.model.CricketPlayers;
import com.practice.restapisingletable.repository.CricketPlayerRepository;
import com.practice.restapisingletable.response.CricketPlayerResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class CricketPlayersService {

    @Autowired
    private CricketPlayerRepository cricketPlayerRepository;

    @Autowired
    private CricketPlayerMapper cricketPlayerMapper;

    public CricketPlayerResponse createPlayers(CricketPlayers cricketPlayers) {
        CricketPlayerEntity cricketPlayerEntity=cricketPlayerMapper.modelTOEntity(cricketPlayers);

        CricketPlayerResponse cricketPlayerResponse=new CricketPlayerResponse();
        cricketPlayerRepository.save(cricketPlayerEntity);
        cricketPlayerResponse.setId(cricketPlayerEntity.getId());
        log.info("Players Details is saved successfully !!");
        return cricketPlayerResponse;
    }

    public CricketPlayers getPlayers(Long id) throws Exception {
        Optional<CricketPlayerEntity> optionalCricketPlayerEntity=cricketPlayerRepository.findById(id);
        CricketPlayers cricketPlayers=new CricketPlayers();
        if(optionalCricketPlayerEntity.isPresent()){
            CricketPlayerEntity cricketPlayerEntity= optionalCricketPlayerEntity.get();
            cricketPlayers = cricketPlayerMapper.entityToModel(cricketPlayerEntity);
            log.info("Getting info with id : "+id);
        } else {
            throw new RuntimeException("Id : " + id + "not found");
        }
        return cricketPlayers;
    }

    public CricketPlayers updatePlayers(Long id, CricketPlayers cricketPlayers) {
        Optional<CricketPlayerEntity> optionalCricketPlayers=cricketPlayerRepository.findById(id);
        if(optionalCricketPlayers.isPresent()){
            CricketPlayerEntity cricketPlayerEntity= optionalCricketPlayers.get();

            cricketPlayerEntity.setName(cricketPlayers.getName());
            cricketPlayerEntity.setRole(cricketPlayers.getRole());

            //cricketPlayerMapper.modelTOEntity(cricketPlayers);

            cricketPlayerRepository.save(cricketPlayerEntity);
            log.info("Players details with id {} updated", id);
        } else {
            throw new RuntimeException("Id : " + id + "not found");
        }
        return cricketPlayers;
    }

    public void delete(Long id) {
        Optional<CricketPlayerEntity> optionalCricketPlayers=cricketPlayerRepository.findById(id);
        if(optionalCricketPlayers.isPresent()){
            cricketPlayerRepository.deleteById(id);
            log.info("Id {} is deleted",id);
        }
    }
}
