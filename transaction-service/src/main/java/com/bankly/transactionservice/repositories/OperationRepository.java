package com.bankly.transactionservice.repositories;

import com.bankly.transactionservice.entities.Operation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationRepository extends MongoRepository<Operation,Long> {
}
