package lab1;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String firstname = "";
        String lastname = "";
        String pnc = "";

        Person person;

        BankAccountFactory factory = null;
        BankAccount account = null;

        while(true)
        {


            /*** Conditii de start ***/
            if(firstname.equals(""))
            {
                System.out.println("Enter First Name: ");
                if(scanner.hasNextLine())
                {
                    firstname = scanner.nextLine();
                }
                else
                {
                    scanner.next();
                    System.out.println("Invalid input...");
                }
                continue;
            }

            if(lastname.equals(""))
            {
                System.out.println("Enter Last Name: ");
                if(scanner.hasNextLine())
                {
                    lastname = scanner.nextLine();
                }
                else
                {
                    scanner.next();
                    System.out.println("Invalid input...");
                }
                continue;
            }

            if(pnc.equals(""))
            {
                System.out.println("Enter PNC Number: ");
                if(scanner.hasNextLine())
                {
                    pnc = scanner.nextLine();

                    person = new Person(firstname, lastname, pnc);
                    factory = BankAccountFactory.getInstance(person);
                }
                else
                {
                    scanner.next();
                    System.out.println("Invalid input...");
                }
                continue;
            }

            if(account == null)
            {
                System.out.println("Create account type: ");
                System.out.println("0: Normal Bank Account");
                System.out.println("1: Deposit Account");

                if(scanner.hasNextInt())
                {
                    int type = scanner.nextInt();
                    scanner.nextLine();
                    if(type > 1)
                    {
                        System.out.println("Invalid input...");
                    }
                    else
                    {
                        switch(type)
                        {
                            case 0:
                                account = factory.createBankAccount("bank_account");
                                break;
                            case 1:
                                System.out.println("Enter Account Maturity (months): ");
                                if(scanner.hasNextInt()) {
                                    factory.setMaturity(scanner.nextInt());
                                    scanner.nextLine();
                                }
                                else
                                {
                                    scanner.next();
                                    System.out.println("Invalid input... Setting maturity to 3 months");
                                    factory.setMaturity(3);
                                }
                                account = factory.createBankAccount("deposit_account");
                        }
                    }
                }
                else
                {
                    scanner.next();
                    System.out.println("Invalid input...");
                }
                continue;
            }

            System.out.println("Actions: ");
            System.out.print("0: Advance Time ");
            System.out.print("1: Add Balance ");
            System.out.println("2: Withdraw Balance");
            System.out.print("3: Check balance ");
            System.out.print("4: Account Information ");
            System.out.println("exit / quit to exit");
            if(scanner.hasNextInt())
            {
                int action = scanner.nextInt();
                scanner.nextLine();

                switch(action)
                {
                    case 0:
                        account.advanceTime();
                        break;
                    case 1:
                    case 2:
                        System.out.println("Enter Amount: ");
                        if(scanner.hasNextInt())
                        {
                            int amount = scanner.nextInt();
                            scanner.nextLine();

                            if(action == 1)
                                account.addBalance(amount);
                            else
                                account.withdrawBalance(amount);
                        }
                        else
                        {
                            scanner.next();
                            System.out.println("Invalid input...");
                        }
                        break;
                    case 3:
                        System.out.println("Account balance: " + account.getBalance());
                        break;
                    case 4:
                        System.out.println(account);
                        break;
                    default:
                        System.out.println("Invalid input...");
                }
            }
            else
            {
                if(scanner.hasNextLine()) {
                    String action = scanner.nextLine();

                    if (action.equals("exit") || action.equals("quit")) {
                        System.out.println("Exiting...");
                        break;
                    }
                    else
                    {
                        System.out.println("Invalid input...");
                    }
                }
            }


        }
    }
}
