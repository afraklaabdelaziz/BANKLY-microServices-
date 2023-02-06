package com.bankly.transactionservice.repositories;

import com.bankly.transactionservice.entities.Opperation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpperationRepository extends MongoRepository<Opperation,Long> {
}
