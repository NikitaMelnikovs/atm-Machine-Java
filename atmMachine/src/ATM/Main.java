package ATM;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // classes import
        atmMachine atm = new atmMachine();
        PinKod pinkod = new PinKod();

        Scanner input = new Scanner(System.in);

        String[] atmTypes = {"Deposit", "Withdraw", "Check Balance", "Exit"};
        String PINKOD = "1234";

        int[] chooseService = {1, 2, 3, 4};
        int choosedService;

        // Runs the pinkodChecker
        pinkod.pinKodChecker(input, PINKOD, atm.userTriesLeft, atm.triesLeft);

        while(atm.gameOn) {
            // Check if the choice is valid
            while(true) {
                atm.serviceMethod(atmTypes, chooseService);
                choosedService = input.nextInt();

                if(choosedService == chooseService[0] || choosedService == chooseService[1] || choosedService == chooseService[2] || choosedService == chooseService[3]) {
                    break;
                } else{
                    System.out.println("Invalid answer! Please enter a valid choice!");
                }

            }

            switch(choosedService) {
                case 1:
                    atm.depositBalance(input);
                    break;
                case 2:
                    atm.withdrawFunction(input);
                    break;
                case 3:
                    atm.showAccountBalance(atm.accountBalance);
                    break;
                case 4:
                    System.out.println("Have a great day!");
                    atm.gameOn = false;
                    System.exit(0);
                    break;
            }
            atm.goBack(input);
        }
        input.close();
    }
}