package lab12.ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BankAccount {

    ExecutorService executor = Executors.newCachedThreadPool();

    private double balance;

    public BankAccount() {
        this.balance = 10000;
    }

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        synchronized (this)
        {
            return balance;
        }
    }

    public void deposit(double amount) {
       executor.submit(() -> {
           synchronized (this)
           {
               this.balance += amount;
           }
       });
    }

    public void withdraw(double amount) {
        executor.submit(() -> {
                    synchronized (this) {
                        if (amount <= this.balance) {
                            this.balance -= amount;
                        }
                    }
                }
            );

    }



}
