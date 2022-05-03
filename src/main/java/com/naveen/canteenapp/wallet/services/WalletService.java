package com.naveen.canteenapp.wallet.services;

import com.naveen.canteenapp.wallet.models.Wallet;

public interface WalletService {
    Wallet getBalance(String username);

    void putBalance(String username, int wallet);
}
