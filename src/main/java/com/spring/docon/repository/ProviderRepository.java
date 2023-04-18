package com.spring.docon.repository;

import com.spring.docon.entity.ProviderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


    @Repository
    public interface ProviderRepository extends JpaRepository<ProviderEntity, Long> {


    }


