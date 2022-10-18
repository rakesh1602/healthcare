package com.practice.restapisingletable.service;

import com.practice.restapisingletable.entity.CricketPlayerEntity;
import com.practice.restapisingletable.mapper.CricketPlayerMapper;
import com.practice.restapisingletable.model.CricketPlayers;
import com.practice.restapisingletable.repository.CricketPlayerRepository;
import com.practice.restapisingletable.response.CricketPlayerResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        cricketPlayerResponse.setId(cricketPlayerEntity.getId());
        cricketPlayerRepository.save(cricketPlayerEntity);
        log.info("Players Details is saved successfully !!");
        return cricketPlayerResponse;
    }
}
