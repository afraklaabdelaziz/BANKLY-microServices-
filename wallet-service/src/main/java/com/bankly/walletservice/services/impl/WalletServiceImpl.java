package com.bankly.walletservice.services.impl;

import com.bankly.walletservice.dto.ResponseDto;
import com.bankly.walletservice.entities.Wallet;
import com.bankly.walletservice.repositories.WalletRepository;
import com.bankly.walletservice.services.IWalletService;
import com.bankly.walletservice.utile.GenerateReference;
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
    public ResponseDto addWallet(Wallet wallet) {
        if (wallet == null){
            return new ResponseDto("bad request","wallet is null");
        } else if (wallet.getCinClient().isEmpty()) {
            return new ResponseDto("bad request","cin client is required");
        }else {
            wallet.setBalance(0D);
            wallet.setReference(GenerateReference.applyGenerateReference());
            wallet.setCreatedAt(LocalDate.now());
            walletRepository.save(wallet);
            return new ResponseDto("success","your wallet created with success");
        }
    }

    @Override
    public ResponseDto updateWallet(Wallet wallet) {
        Optional<Wallet> walletFound = (Optional<Wallet>) this.findWalletByRef(wallet.getReference()).getData();
        walletFound.get().setBalance(wallet.getBalance());
        walletRepository.save(walletFound.get());
       return new ResponseDto("success","wallet updated",walletFound.get());
    }

    @Override
    public ResponseDto findAllWallet() {
        return new ResponseDto("success","all wallets",walletRepository.findAll());
    }

    @Override
    public ResponseDto findWalletByCinClient(String cin) {

            return new ResponseDto("success","wallet of client port cin "+cin,walletRepository.findByCinClient(cin));
    }

    @Override
    public ResponseDto findWlletById(Long idWallet) {
        Optional<Wallet> wallet = walletRepository.findById(idWallet);
        if (!wallet.isPresent()){
            return new ResponseDto("bad request","wallet of this client not exist");
        }else {
            return new ResponseDto("success","wallet",wallet);
        }
    }

    @Override
    public ResponseDto findWalletByRef(String ref) {
        Optional<Wallet> wallet = walletRepository.findWalletByReference(ref);
        if (!wallet.isPresent()){
            return new ResponseDto("bad request","wallet of this client not exist");
        }else {
            return new ResponseDto("success","wallet",wallet);
        }
    }
}
