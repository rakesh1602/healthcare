package com.practice.restapisingletable.repository;

import com.practice.restapisingletable.entity.CricketPlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CricketPlayerRepository extends JpaRepository<CricketPlayerEntity, Long> {
}
