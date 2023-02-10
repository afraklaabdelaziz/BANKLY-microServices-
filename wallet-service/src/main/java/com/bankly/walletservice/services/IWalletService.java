package com.bankly.walletservice.services;

import com.bankly.walletservice.dto.ResponceDto;
import com.bankly.walletservice.entities.Wallet;

public interface IWalletService {
     ResponceDto addWallet(Wallet wallet);
     ResponceDto updateWallet(Wallet wallet);
     ResponceDto findAllWallet();
     ResponceDto findWalletByCinClient(String cin);
     ResponceDto findWlletById(Long idWallet);

     ResponceDto findWalletByRef(String ref);
}
