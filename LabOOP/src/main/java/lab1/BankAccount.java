package lab1;

import java.util.Random;

public class BankAccount {
    protected Person owner;

    protected double balance;
    protected final String iban;

    BankAccount(Person owner, double balance, String iban) {
        this.owner = owner;
        this.balance = 0;
        this.iban = iban;
    }



    // Owner
    public String getOwnerName() {
        return this.owner.getFirstName() + " " + this.owner.getLastName();
    }

    public String getOwnerPersonalNumericalCode() {
        return this.owner.getPersonalNumericalCode();
    }

    public void setOwnerFirstName(String owner_firstname) {
        this.owner.setFirstName(owner_firstname);
    }

    public void setOwnerLastName(String owner_lastname) {
        this.owner.setLastName(owner_lastname);
    }

    /*********************** Balance **/

    public double getBalance() {
        return this.balance;
    }

    public void addBalance(double amount) {
        this.balance += amount;
        System.out.println("Successfully added balance to the account.");
    }

    public void withdrawBalance(double amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
            System.out.println("Successfully withdrew balance to the account.");
        }
    }

    /************************ IBAN **/

    public String getIban() {
        return this.iban;
    }

    /**** Others ***/
    public void advanceTime()
    {
    }

    @Override
    public String toString()
    {
        return "Default Bank Account\n" +
                "IBAN: " + this.iban + "\n" +
                "Owner Name: " + this.getOwnerName() + "\n" +
                "Owner Personal Numerical: " + this.getOwnerPersonalNumericalCode() + "\n" +
                "Balance: " + this.balance + "\n";
    }


}
