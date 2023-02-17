package com.bankly.transactionservice.repositories;

import com.bankly.transactionservice.dto.ResponseDto;
import com.bankly.transactionservice.entities.Operation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationRepository extends MongoRepository<Operation,String> {
    List<Operation> findOperationByWalletRef(String walletRef);
}
