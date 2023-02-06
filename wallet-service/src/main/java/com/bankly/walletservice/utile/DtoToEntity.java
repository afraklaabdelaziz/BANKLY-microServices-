package com.bankly.walletservice.utile;

import com.bankly.walletservice.dto.WalletDto;
import com.bankly.walletservice.entities.Wallet;
import org.modelmapper.ModelMapper;

public class DtoToEntity {
    public static Wallet walletDtoToWalletEntity(WalletDto walletDto) {
        ModelMapper modelMapper=new ModelMapper();
        return modelMapper.map(walletDto, Wallet.class);
    }
}
