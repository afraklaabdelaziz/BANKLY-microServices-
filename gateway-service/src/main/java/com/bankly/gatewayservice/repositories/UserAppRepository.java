package com.bankly.gatewayservice.repositories;

import com.bankly.gatewayservice.entities.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAppRepository extends JpaRepository<UserApp,Long> {

}
