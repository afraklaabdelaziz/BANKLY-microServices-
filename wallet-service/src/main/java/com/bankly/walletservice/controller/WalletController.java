package com.bankly.walletservice.controller;

import com.bankly.walletservice.dto.ResponceDto;
import com.bankly.walletservice.dto.WalletDto;
import com.bankly.walletservice.entities.Wallet;
import com.bankly.walletservice.services.IWalletService;
import com.bankly.walletservice.utile.DtoToEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/wallet")
public class WalletController {
    private IWalletService walletService;

    public WalletController(IWalletService walletService) {
        this.walletService = walletService;
    }

    @PostMapping("/add-wallet")
    public ResponceDto addWallet(@RequestBody WalletDto walletdto){
        Wallet wallet = DtoToEntity.walletDtoToWalletEntity(walletdto);
        return walletService.addWallet(wallet);
    }

    @GetMapping("/wallet-client/{cin}")
    public ResponceDto findWalletOfClient(@PathVariable String cin){
        return walletService.findWalletByCinClient(cin);
    }

    @GetMapping("/wallet-by-ref/{ref}")
    public Optional<Wallet> findWalletByRef(@PathVariable String ref){
        return (Optional<Wallet>) walletService.findWalletByRef(ref).getData();
    }

    @GetMapping("/all-wallet")
    public ResponceDto findAllWallet(){
        return walletService.findAllWallet();
    }

    @PutMapping("/update-wallet")
    public ResponceDto updateWallet(@RequestBody Wallet wallet){
        return walletService.updateWallet(wallet);
    }
}
