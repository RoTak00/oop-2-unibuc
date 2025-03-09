package lab1;

public class DepositAccount extends BankAccount{

    protected final int maturity;
    protected int age;
    protected double interest_rate;
    DepositAccount(Person owner, int balance, String iban, int maturity)
    {
        super(owner, balance, iban);

        this.maturity = maturity;
        this.age = 0;
        this.interest_rate = DepositAccount.calculateInterest(maturity);
    }

    private void updateBalanceOnDepositMature()
    {
        double calculated_interest = (this.maturity / 12.0f) * ((float)this.interest_rate / 100.0f) * this.balance;
        this.balance += calculated_interest;

        System.out.println("Balance after interest: " + this.balance);

    }

    @Override
    public void advanceTime()
    {
        age++;

        if(age >= maturity)
        {
            this.age = 0;
            this.updateBalanceOnDepositMature();
        }
    }

    @Override
    public void addBalance(double amount)
    {
        super.addBalance(amount);
        this.age = 0;
    }


    // Based on the account maturity, calculates an interest rate
    private static double calculateInterest(int maturity_months)
    {
        double base_rate = 1.5 + Math.log(maturity_months) * 0.8;

        double calculated_interest = Math.min(Math.max(base_rate, 0.5), 8.0);

        calculated_interest = Math.round(calculated_interest * 20) / 20.0;

        return calculated_interest;
    }

    @Override
    public String toString()
    {
        return "Deposit Bank Account\n" +
                "Maturity: " + this.maturity + "\n" +
                "Interest Rate: " + this.interest_rate + "\n" +
                "IBAN: " + this.iban + "\n" +
                "Owner Name: " + this.getOwnerName() + "\n" +
                "Owner Personal Numerical: " + this.getOwnerPersonalNumericalCode() + "\n" +
                "Balance: " + this.balance + "\n" +
                "Age: " + this.age + " months\n";
    }
}
