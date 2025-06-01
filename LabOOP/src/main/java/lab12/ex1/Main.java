package lab12.ex1;

import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        BankAccount account = new BankAccount();

        account.deposit(100);
        System.out.println(account.getBalance());
        account.deposit(200);
        account.deposit(400);
        account.deposit(500);
        account.deposit(500);
        account.deposit(500);
        account.deposit(200);

        System.out.println(account.getBalance());

        account.withdraw(200);

        account.withdraw(400);

        account.withdraw(400);
        account.withdraw(400);
        account.withdraw(400);
        System.out.println(account.getBalance());
        account.withdraw(400);
        account.withdraw(400);
        account.withdraw(400);
        account.withdraw(400);
        System.out.println(account.getBalance());
        account.withdraw(400);
        account.withdraw(400);
        account.withdraw(4000);
        account.withdraw(4000);
        System.out.println(account.getBalance());
        account.withdraw(4000);
        System.out.println(account.getBalance());
    }

}
