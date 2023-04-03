package com.crossasyst.docon.repository;

import com.crossasyst.docon.entity.UserRegisterEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRegisterRepository extends ReactiveCrudRepository<UserRegisterEntity, Long> {
}
