package com.bankly.userservice.repositories;

import com.bankly.userservice.entities.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAppRepository extends JpaRepository<UserApp,Long> {

    Optional<UserApp> findByCin(String cin);
    Optional<UserApp> findByEmail(String email);
    Optional<UserApp> findByPhone(String phone);

}
