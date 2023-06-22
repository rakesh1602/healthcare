package com.crossasyst.sqstodatabase.mapper;

import com.crossasyst.sqstodatabase.entity.MessageEntity;
import com.crossasyst.sqstodatabase.model.Message;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MessageMapper {

    MessageEntity modelToEntity(Message message);
}
