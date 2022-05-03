package com.naveen.canteenapp.wallet.controller;

import com.naveen.canteenapp.wallet.models.Wallet;
import com.naveen.canteenapp.wallet.services.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/wallet")
public class WalletController {
    @Autowired
    WalletService walletService;

    @GetMapping("/{username}")
    ResponseEntity<Wallet> getBalance(@PathVariable String username) {
        return new ResponseEntity<>(walletService.getBalance(username), HttpStatus.OK);
    }

    @PutMapping("/{username}")
    ResponseEntity<Wallet> putBalance(@PathVariable("username") String username, @RequestBody Wallet wallet) {
        walletService.putBalance(username, wallet.getBalance());
        return new ResponseEntity<>(
                walletService.getBalance(username),
                HttpStatus.OK);
    }
}
