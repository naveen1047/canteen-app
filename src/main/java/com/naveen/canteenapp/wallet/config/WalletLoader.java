package com.naveen.canteenapp.wallet.config;

import com.naveen.canteenapp.config.UserList;
import com.naveen.canteenapp.user.models.User;
import com.naveen.canteenapp.user.services.UserService;
import com.naveen.canteenapp.user.services.UserServiceImpl;
import com.naveen.canteenapp.wallet.dao.WalletRepository;
import com.naveen.canteenapp.wallet.models.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WalletLoader implements CommandLineRunner {
    @Autowired
    WalletRepository walletRepository;
    @Autowired
    UserServiceImpl userService;

    @Override
    public void run(String... args) throws Exception {
        loadWallet();
    }

    private void loadWallet() {
        List<Wallet> wallets = new ArrayList<>();

        UserList ul = new UserList();
        ul.generateAndGetUserList().forEach(user -> {
            final User[] currUser = new User[1];
            userService.getUsers().forEach(user1 -> {
                if (user.getUsername().equals(user1.getUsername())) {
                    System.out.println("found");
                    currUser[0] = user1;
                }
            });
            Wallet wallet = new Wallet(user.getUsername(), 0, currUser[0]);
            wallets.add(wallet);
        });

        for (int i = 0; i < wallets.size(); i++)
            System.out.println(wallets.get(i).toString());

        walletRepository.saveAll(wallets);
    }
}
