package com.spring.docon.repository;

import com.spring.docon.entity.UserRegisterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserRegisterEntity, Long> {
}
