package com.naveen.canteenapp.order.exceptions;

public class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String s) {
        super(s);
    }
}