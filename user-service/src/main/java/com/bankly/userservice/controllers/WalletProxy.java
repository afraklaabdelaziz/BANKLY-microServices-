package com.bankly.userservice.controllers;

import com.bankly.userservice.dto.WalletDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@FeignClient(name = "wallet-service")
public interface WalletProxy {
    @PostMapping("/api/v1/wallet/add-wallet")
    WalletDto addWallet(@RequestBody WalletDto walletDto);
}
