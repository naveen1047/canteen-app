package com.naveen.canteenapp.wallet.models;

import com.naveen.canteenapp.loginJwt.models.AuthenticationRequest;
import com.naveen.canteenapp.user.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Table(name = "wallets")
public class Wallet {
    @Id
    @Column(name = "wallet_id")
    @GeneratedValue
    Long walletId;
    @Column
    int balance;

    public Wallet(String username, int balance) {
//        this.username = username;
        this.balance = balance;
    }

    public Wallet(String username, int balance, User user) {
//        this.username = username;
        this.balance = balance;
        this.user = user;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public int getBalance() {
        return balance;
    }
    public User getUser() {
        return user;
    }


    @OneToOne()
    @JoinColumn(name = "id", referencedColumnName = "username", nullable = false)
    private User user;
}
