package com.bankly.walletservice.services;

import com.bankly.walletservice.dto.ResponseDto;
import com.bankly.walletservice.entities.Wallet;

public interface IWalletService {
     ResponseDto addWallet(Wallet wallet);
     ResponseDto updateWallet(Wallet wallet);
     ResponseDto findAllWallet();
     ResponseDto findWalletByCinClient(String cin);
     ResponseDto findWlletById(Long idWallet);

     ResponseDto findWalletByRef(String ref);
}
