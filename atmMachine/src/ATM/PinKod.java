package ATM;

import java.util.Scanner;

public class PinKod {

    // Check users pinkod(pinkod = 1234)
    public void pinKodChecker(Scanner input, String pinkod, int userTriesLeft, int triesLeft) {
        int maxTries = 3;

        for (int i = 0; i < maxTries; i++) {
            userTriesLeft--;
            System.out.print("You have " + userTriesLeft + " tries! Enter your Pinkod: ");
            String pinKodUser = input.nextLine();
            if (!pinKodUser.equals(pinkod)) {
                triesLeft--;
                if (userTriesLeft > 1) {
                    System.out.println("Wrong");
                }
            } else {
                maxTries = 0;
                System.out.println("You password was correct! ");
            }
        }
        if(triesLeft == 0) {
            System.out.println("You entered your password incorrect 3 times. ");
            System.exit(0);
        }
    }
}
