package lab1;

import java.util.Random;

public class BankAccountFactory {
    private static BankAccountFactory instance;
    private final Person person;
    private int maturity;

    private BankAccountFactory(Person person)
    {
        this.person = person;
        this.maturity = 0;
    }

    public static BankAccountFactory getInstance(Person person)
    {
        if(instance == null)
        {
            instance = new BankAccountFactory(person);
        }
        return instance;
    }

    public static BankAccountFactory getInstance(String firstname, String lastname, String pnc)
    {
        if(instance == null)
        {
            Person person = new Person(firstname, lastname, pnc);
            instance = new BankAccountFactory(person);
        }
        return instance;
    }

    public Person getPerson()
    {
        return this.person;
    }

    public void setMaturity(int maturity)
    {
        this.maturity = maturity;
    }

    public int getMaturity()
    {
        return this.maturity;
    }

    public BankAccount createBankAccount(String type)
    {

        String iban = BankAccountFactory.generateIban();
        switch(type)
        {
            case "deposit_account":
                if(this.maturity == 0){
                    System.out.println("Deposit account creation failed. No maturity set");
                    System.out.println("Generated bank account with iban " + iban);
                    return new BankAccount(this.person, 0, iban);
                }
                System.out.println("Generated deposit account with iban " + iban);
                return new DepositAccount(this.person, 0, iban, this.maturity);
            default:
                System.out.println("Generated bank account with iban " + iban);
                return new BankAccount(this.person,0, iban);
        }
    }

    /********************** Static Functions */

    // Generates a new account IBAN
    private static String generateIban() {
        Random rand = new Random();

        int check_digit = rand.nextInt(90) + 10;
        String bank_code = "RBNK" + (rand.nextInt(9000) + 1000);
        String account_number = String.format("%010d", rand.nextLong(1_000_000_000L));

        return "RO" + check_digit + bank_code + account_number;
    }


}
