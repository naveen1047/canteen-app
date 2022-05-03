package com.naveen.canteenapp.wallet.dao;

import com.naveen.canteenapp.wallet.models.Wallet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Map;

public interface WalletRepository extends CrudRepository<Wallet, Long> {
    @Query(value = "SELECT * FROM wallets WHERE id = ?1", nativeQuery = true)
    Wallet findByUserId(String username);
}
