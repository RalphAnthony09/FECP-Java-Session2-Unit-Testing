package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BankAccountTest {

    private static final double delta = 0.001;

    @Test
    void testGetAccountNumber() {

        BankAccount account = new BankAccount(90904, "Johnny Dog", 10000);
        assertEquals(90904, account.getAccountNumber());
    }

    @Test
    void depositValidAmount() {

        BankAccount account = new BankAccount(50004, "Ralph Anthony", 1000.0);
        double initialBalance = account.getBalance();
        account.depositMoney(500.0);

        assertEquals(initialBalance + 500.0, account.getBalance(), delta);
    }

    @Test
    void depositInvalidAmount() {

        BankAccount account = new BankAccount(50004, "Ralph Anthony", 1000.0);
        double initialBalance = account.getBalance();

        account.depositMoney(-500.0);

        assertEquals(initialBalance, account.getBalance(), delta);
    }

    @Test
    void withdrawValidAmount() {

        BankAccount account = new BankAccount(50004, "Ralph Anthony", 1000.0);
        double initialBalance = account.getBalance();

        account.withdrawMoney(500.0);

        assertEquals(initialBalance - 500.0, account.getBalance(), delta);
    }

    @Test
    void withdrawInvalidAmount() {

        BankAccount account = new BankAccount(50004, "Ralph Anthony", 1000.0);
        double initialBalance = account.getBalance();

        account.withdrawMoney(-500.0);

        assertEquals(initialBalance, account.getBalance(), delta);
    }

    @Test
    void withdrawAmountExceedingBalance() {

        BankAccount account = new BankAccount(50004, "Ralph Anthony", 1000.0);
        double initialBalance = account.getBalance();

        account.withdrawMoney(2000.0);

        assertEquals(initialBalance, account.getBalance(), delta);
    }

    @Test
    void testCreationBankAccountWithoutDeposits() {

        BankAccount account = new BankAccount(50004, "Ralph Anthony", 0.0);
        assertEquals(0.0, account.getBalance(), delta);
    }

}