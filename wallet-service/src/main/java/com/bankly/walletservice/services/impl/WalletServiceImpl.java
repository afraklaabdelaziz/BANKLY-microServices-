package com.bankly.walletservice.services.impl;

import com.bankly.walletservice.dto.ResponceDto;
import com.bankly.walletservice.entities.Wallet;
import com.bankly.walletservice.repositories.WalletRepository;
import com.bankly.walletservice.services.IWalletService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
@Service
public class WalletServiceImpl implements IWalletService {
    private WalletRepository walletRepository;

    public WalletServiceImpl(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    @Override
    public ResponceDto addWallet(Wallet wallet) {
        if (wallet == null){
            return new ResponceDto("bad request","wallet is null");
        } else if (wallet.getCinClient().isEmpty()) {
            return new ResponceDto("bad request","cin client is required");
        }else {
            wallet.setBalance(0D);
            wallet.setCreatedAt(LocalDate.now());
            walletRepository.save(wallet);
            return new ResponceDto("success","your wallet created with success");
        }
    }

    @Override
    public ResponceDto updateWallet(Wallet wallet) {
        Optional<Wallet> walletFound = (Optional<Wallet>) this.findWalletByRef(wallet.getReference()).getData();
        walletFound.get().setBalance(wallet.getBalance());
        walletRepository.save(walletFound.get());
       return new ResponceDto("success","wallet updated",walletFound.get());
    }

    @Override
    public ResponceDto findAllWallet() {
        return new ResponceDto("success","all wallets",walletRepository.findAll());
    }

    @Override
    public ResponceDto findWalletByCinClient(String cin) {
        Optional<Wallet> wallet = walletRepository.findByCinClient(cin);
        if (!wallet.isPresent()){
            return new ResponceDto("bad request","wallet of this client not exist");
        }else {
            return new ResponceDto("success","wallet of client port cin "+cin,wallet);
        }
    }

    @Override
    public ResponceDto findWlletById(Long idWallet) {
        Optional<Wallet> wallet = walletRepository.findById(idWallet);
        if (!wallet.isPresent()){
            return new ResponceDto("bad request","wallet of this client not exist");
        }else {
            return new ResponceDto("success","wallet",wallet);
        }
    }

    @Override
    public ResponceDto findWalletByRef(String ref) {
        Optional<Wallet> wallet = walletRepository.findWalletByReference(ref);
        if (!wallet.isPresent()){
            return new ResponceDto("bad request","wallet of this client not exist");
        }else {
            return new ResponceDto("success","wallet",wallet);
        }
    }
}
