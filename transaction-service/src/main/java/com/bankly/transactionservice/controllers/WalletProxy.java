package com.bankly.transactionservice.controllers;

import com.bankly.transactionservice.dto.WalletDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "wallet-service")
public interface WalletProxy {
    @GetMapping("/api/v1/wallet/wallet-by-ref/{ref}")
    WalletDto findWalletByRef(@PathVariable String ref);

    @GetMapping("/api/v1/wallet/wallet-client/{cin}")
    List<WalletDto> findWalletsClientByCin(@PathVariable String cin);

    @PutMapping("/api/v1/wallet/update-wallet")
    WalletDto updateWallet(@RequestBody WalletDto walletDto);
}
