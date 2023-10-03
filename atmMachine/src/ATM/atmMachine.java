package ATM;

import java.util.Scanner;

public class atmMachine {
    protected boolean gameOn = true;

    protected int accountBalance = 3000;
    protected int depositLimit = 3000;
    protected int userTriesLeft = 4;
    protected int triesLeft = 3;


    // Shows account Balance
    public void showAccountBalance(int accountMoney) {
        System.out.println("You have " + accountMoney + " kr on your account");
        System.out.println(" ");
    }
    // Account balance after deposit/withdraw. Are not actually needed.
    public int newAccountBalance(int accountBalance) {
        return accountBalance;
    }

    // The deposit balance function
    public void depositBalance(Scanner input) {
        atmMachine clas = new atmMachine();
        System.out.println("Enter the amount you want to deposit. Limit is " + clas.depositLimit + " kr");


        while(true) {
            int depositAmount = input.nextInt();

            depositAmountChecker(depositAmount);
            if(depositAmount < clas.depositLimit) {
                System.out.println("You have successfully deposited " + depositAmount + " kr! Your new balance are " + newAccountBalance(clas.accountBalance + depositAmount) + " kr");
                break;
            }
        }
    }

    //The Withdrawal balance function
    public void withdrawFunction(Scanner input) {
        atmMachine clas = new atmMachine();
        System.out.println("How much do you want to withdraw! You have " + clas.accountBalance + " kr on your account!");

        while(true){
            int withdrawAmount = input.nextInt();

            withdrawAmountChecker(withdrawAmount);
            if (withdrawAmount < clas.accountBalance) {
                System.out.println("You have successfully withdrawed " + withdrawAmount + " kr! Your new balance are " + newAccountBalance(clas.accountBalance - withdrawAmount));
                break;
            }
        }
    }

    // Prints out what the user can choose between(1, 2 ,3 for deposit..)
    public void serviceMethod(String[] atmTypes, int[] chooseService) {
        for (int i = 0; i < atmTypes.length; i++) {
            System.out.println("Choose " + chooseService[i] + " for " + atmTypes[i]);
        }
    }

    // Exit or restart the program after a function is done
    public void goBack(Scanner input) {
        int[] chooseService = {1, 2};
        String [] goBackTypes = {"Restart", "Exit"};

        System.out.println(" ");
        for(int i = 0; i < goBackTypes.length; i++) {
            System.out.println("Choose " + chooseService[i] + " for " + goBackTypes[i]);
        }

        int choosedService = input.nextInt();
        if(choosedService == 2) {
            System.out.println("Have a great day!");
            System.exit(0);
        }
    }

    // Checks if the deposit amount follow the rules
    public void depositAmountChecker(int depositAmount) {
        atmMachine clas = new atmMachine();

        if (depositAmount > clas.depositLimit) {
            System.out.println("The amount is higher than the limit!");
            System.out.println("Enter the amount that is lower than the limit!");
        }
    }

    // Check if the withdrawal amount follow the rules
    public void withdrawAmountChecker(int withdrawAmount) {
        atmMachine clas = new atmMachine();

        if(withdrawAmount > clas.accountBalance) {
            System.out.println("You dont have enough money on your balance to withdraw " + withdrawAmount + " kr");
            System.out.println("Enter the amount that is lower than your account balance. ");
        }
    }
}
