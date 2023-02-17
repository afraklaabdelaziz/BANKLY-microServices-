package com.bankly.walletservice.controller;

import com.bankly.walletservice.dto.ResponseDto;
import com.bankly.walletservice.dto.WalletDto;
import com.bankly.walletservice.entities.Wallet;
import com.bankly.walletservice.services.IWalletService;
import com.bankly.walletservice.utile.DtoToEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/wallet")
public class WalletController {
    private IWalletService walletService;

    public WalletController(IWalletService walletService) {
        this.walletService = walletService;
    }

    @PostMapping("/add-wallet")
    public ResponseDto addWallet(@RequestBody WalletDto walletdto){
        Wallet wallet = DtoToEntity.walletDtoToWalletEntity(walletdto);
        return walletService.addWallet(wallet);
    }

    @GetMapping("/wallet-client/{cin}")
    public List<Wallet> findWalletOfClient(@PathVariable String cin){
        return ((List<Wallet>) walletService.findWalletByCinClient(cin).getData());
    }

    @GetMapping("/wallet-by-ref/{ref}")
    public Optional<Wallet> findWalletByRef(@PathVariable String ref){
        return (Optional<Wallet>) walletService.findWalletByRef(ref).getData();
    }

    @GetMapping("/all-wallet")
    public ResponseDto findAllWallet(){
        return walletService.findAllWallet();
    }

    @PutMapping("/update-wallet")
    public ResponseDto updateWallet(@RequestBody Wallet wallet){
        return walletService.updateWallet(wallet);
    }
}
