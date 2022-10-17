package com.example.oneToOneMapping.mapper;

import com.example.oneToOneMapping.entity.AddressEntity;
import com.example.oneToOneMapping.entity.PersonEntity;
import com.example.oneToOneMapping.model.Address;
import com.example.oneToOneMapping.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PersonAddressMapper {
    PersonAddressMapper INSTANCE= Mappers.getMapper(PersonAddressMapper.class);

    PersonEntity personToEntity(Person person);
    AddressEntity personToEntity(Address address);

    Person entityToPerson(PersonEntity personEntity);
}
