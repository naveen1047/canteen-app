package com.naveen.canteenapp.user.models;


import com.naveen.canteenapp.wallet.models.Wallet;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Table(name = "users")
@Getter
public class User {
    @Id
    String username;

    public User(String username) {
        this.username = username;
    }


//    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Wallet wallet;
}
