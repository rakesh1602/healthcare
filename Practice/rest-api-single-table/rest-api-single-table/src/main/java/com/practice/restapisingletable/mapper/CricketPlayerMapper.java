package com.practice.restapisingletable.mapper;

import com.practice.restapisingletable.entity.CricketPlayerEntity;
import com.practice.restapisingletable.model.CricketPlayers;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CricketPlayerMapper {
        CricketPlayerEntity modelTOEntity(CricketPlayers cricketPlayers);
        CricketPlayers entityToModel(CricketPlayerEntity cricketPlayerEntity);
}
