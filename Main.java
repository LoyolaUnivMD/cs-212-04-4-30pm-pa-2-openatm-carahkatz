import java.util.Scanner;
import java.text.DecimalFormat;

class Account {
    // Initialize variables/imports
    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("0.00");
    String accountOwner;
    double balance;
    int transactionsCount;
    double largestTransaction;
    double smallestTransaction;
    double totalMoneyTransacted;

    public Account(String user, double balance) {
        accountOwner = user;
        this.balance = balance;
        transactionsCount = 0;
        largestTransaction = 0;
        smallestTransaction = 0;
        totalMoneyTransacted = 0;
    }

    // isOwner method
    public void isOwner() {
        // Ask who owns
        System.out.println("Enter the name of this account's owner: ");
        String personInQuestion = input.nextLine();

        // See if true
        if (accountOwner.equals(personInQuestion)) {
            System.out.println("This account is owned by " + personInQuestion);
        }
        else {
            System.out.println("This account is not used by " + personInQuestion);
        }
    }

    // Deposit method
    public double deposit(double balance) {
        // Call on classes
        Scanner input = new Scanner(System.in);

        // Ask user how much they want to deposit
        System.out.println("\nHow much money would you like to deposit? ");
        double deposit = input.nextDouble();

        // While deposit is less than 0, error message + ask user for input again
        while (deposit <= 0){
            System.out.println("Error. Invalid deposit amount. Please try again.");
            System.out.println("How much money would you like to deposit? ");
            deposit = input.nextDouble();
        }

        // Update balance (balance = balance + deposit)
        balance += deposit;

        // Completion message
        System.out.println("Your balance has been updated.");

        // Transactions stats
        if (transactionsCount == 0) {
            largestTransaction = deposit;
            smallestTransaction = deposit;
        }
        else if (deposit > largestTransaction) {
            largestTransaction = deposit;
        }
        else if (deposit < smallestTransaction) {
            smallestTransaction = deposit;
        }
        totalMoneyTransacted += deposit;
        transactionsCount++;

        // Returns balance back to main
        return balance;
    }

    // Withdraw method
    public double withdraw(double balance) {
        // Call on classes
        Scanner input = new Scanner(System.in);

        // Ask user how much they want to withdraw
        System.out.println("\nHow much money would you like to withdraw?");
        double withdraw = input.nextDouble();

        // While deposit is less than 0, error message + ask user for input again
        while (withdraw <= 0) {
            System.out.println("Error. Invalid withdraw amount. Please try again.");
            System.out.println("How much money would you like to withdraw?");
            withdraw = input.nextDouble();
        }

        // Update balance (balance = balance - withdraw)
        balance -= withdraw;

        // Completion message
        System.out.println("Your balance has been updated.");

        // If balance is less than 0, alert user that it is negative and will be charged 5%
        if (balance < 0) {
            System.out.println("!ALERT! Your current balance is negative. You will be charged 5%.");
        }

        // Transactions stats
        if (transactionsCount == 0) {
            largestTransaction = withdraw;
            smallestTransaction = withdraw;
        }
        else if (withdraw > largestTransaction) {
            largestTransaction = withdraw;
        }
        else if (withdraw < smallestTransaction) {
            smallestTransaction = withdraw;
        }
        totalMoneyTransacted += withdraw;
        transactionsCount++;

        // Returns withdraw back to main
        return balance;
    }

    // getStats method
    public void getStats(String user, double balance){
        System.out.println("Account Owner: " + user);
        System.out.println("Balance: $" + moneyFormat.format(balance));
        System.out.println("Number of Transactions: " + transactionsCount);
        System.out.println("Maximum Transaction Size: " + largestTransaction);
        System.out.println("Minimum Transaction Size: " + smallestTransaction);
        System.out.println("Average Transaction Size: " + (totalMoneyTransacted/transactionsCount));
    }

    // Display method (show menu options)
    public void menuOptions(){
        System.out.println("\nPlease select from the following options:");
        System.out.println("-".repeat(50));
        System.out.println("O - Owner\n\tThis will ask you to clarify the owner of the account");
        System.out.println("S - Stats\n\tThis will display your account's information");
        System.out.println("D - Deposit\n\tThis will allow you to deposit a provided amount into your balance");
        System.out.println("W - Withdraw\n\tThis will allow you to withdraw a provided amount from your balance");
        System.out.println("E - Exit");
        System.out.println("-".repeat(50));
    }

}

class Main {
    public static void main(String[] args) {
        // Call on classes
        Scanner input = new Scanner(System.in);

        // Find account for user
        System.out.println("What is your first and last name? Or, to exit, please type exit");
        String user = input.nextLine();
        if (user.equalsIgnoreCase("exit")) {
            System.out.println("\nThank you for using the ATM. Have a nice day!");
        }
        else {
            // Initialize variables
            Account newUser = new Account(user, 212.90);

            // Welcome message
            System.out.println("\n---Welcome to the ATM, " + user + "---");

            // Opening statements + gives user options of choices
            newUser.menuOptions();

            String choice = input.nextLine().toLowerCase();

            // While user input isn't E,
            while (!choice.equals("e")) {
                // If input is O, ask about owner
                if (choice.equals("o")) {
                    newUser.isOwner();
                }
                // If input is S, print stats
                else if (choice.equals("s")) {
                    newUser.getStats(user, newUser.balance);
                }
                // If input is D, call deposit method
                else if (choice.equals("d")) {
                    newUser.balance = newUser.deposit(newUser.balance);
                }
                // If input is W, call withdraw method
                else if (choice.equals("w")) {
                    newUser.balance = newUser.withdraw(newUser.balance);
                }
                // Else, error message + option list
                else {
                    System.out.println("Error. Invalid option choice. Please try again.");
                    newUser.menuOptions();
                }
                // Provide user option list for next loop through
                newUser.menuOptions();
                choice = input.nextLine().toLowerCase();
            }
            // Exit message
            System.out.println("\nThank you for using the ATM. Have a nice day!");
        }
    }

}