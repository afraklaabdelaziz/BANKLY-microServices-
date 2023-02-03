package com.bankly.walletservice.services;

import com.bankly.walletservice.dto.ResponceDto;
import com.bankly.walletservice.entities.Wallet;

public interface IWalletService {
    public ResponceDto addWallet(Wallet wallet);
    public ResponceDto updateWallet(Wallet wallet);
    public ResponceDto findAllWallet();
    public ResponceDto findWalletByCinClient(String cin);
    public ResponceDto findWlletById(Long idWallet);
}
