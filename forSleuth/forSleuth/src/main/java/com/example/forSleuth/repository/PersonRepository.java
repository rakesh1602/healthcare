package com.example.oneToOneMapping.repository;

import com.example.oneToOneMapping.entity.PersonEntity;
import com.example.oneToOneMapping.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
}
