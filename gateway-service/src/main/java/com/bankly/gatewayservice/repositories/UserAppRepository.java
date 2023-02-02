package com.bankly.gatewayservice.repositories;

import com.bankly.gatewayservice.entities.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAppRepository extends JpaRepository<UserApp,Long> {

    Optional<UserApp> findByCin(String cin);
}
