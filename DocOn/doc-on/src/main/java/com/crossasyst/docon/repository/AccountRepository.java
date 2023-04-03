package com.crossasyst.docon.repository;

import com.crossasyst.docon.entity.AccountEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends ReactiveCrudRepository<AccountEntity, Long> {
}
