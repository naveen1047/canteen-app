package com.naveen.canteenapp.wallet.services;

import com.naveen.canteenapp.wallet.dao.WalletRepository;
import com.naveen.canteenapp.wallet.models.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletServiceImpl implements WalletService{
    @Autowired
    WalletRepository walletRepository;

    @Override
    public Wallet getBalance(String username) {
        return walletRepository.findByUserId(username);
    }

    @Override
    public void putBalance(String username, int amount) {
        Wallet wallet = getBalance(username);
        wallet.setBalance(wallet.getBalance() + amount);
        walletRepository.save(wallet);
    }
}
