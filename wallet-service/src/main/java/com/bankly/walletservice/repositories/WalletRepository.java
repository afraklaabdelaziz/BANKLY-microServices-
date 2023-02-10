package com.bankly.walletservice.repositories;

import com.bankly.walletservice.entities.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WalletRepository extends JpaRepository<Wallet,Long> {

    Optional<Wallet> findByCinClient(String cin);

    Optional<Wallet> findWalletByReference(String ref);
}
