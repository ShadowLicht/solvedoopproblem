import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {

        ArrayList<AtmCard> atmcards = new ArrayList<>();
        AtmCard card = new AtmCard();
        int choice;

        System.out.println("Enter 5 valid atm card along with their details: ");
        for (int i = 0; i < 5; i++) {
            System.out.println("\n\nAtm Card " + (i + 1) + ":");
            card = getCardData();
            atmcards.add(card);
        }

        do {
            System.out.println("\n\nWelcome to the ATM!");
            System.out.println("1. View Account Details");
            System.out.println("2. Change PIN");
            System.out.println("3. Withdraw");
            System.out.println("4. Deposit");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = ConsInput.getIntinp();
            switch (choice) {
                case 1:
                    AtmRecord.viewAcc(atmcards);
                    break;
                case 2:
                    AtmRecord.changePIN(atmcards);
                    break;
                case 3:
                    AtmRecord.withdraw(atmcards);
                    break;
                case 4:
                    AtmRecord.deposit(atmcards);
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

    }

    // get the card data then store it to an object c
    static AtmCard getCardData() {

        AtmCard c = new AtmCard();
        String cardnum;
        String pin;

        do {
            System.out.print("Enter the 8 digit Card Number: ");
            cardnum = ConsInput.getStrinp();

        } while (cardnotvalid(cardnum));

        c.setCardNumber(cardnum);

        do {
            System.out.print("Enter the 6 Pin Number: ");
            pin = ConsInput.getStrinp();
        } while (pinnotvalid(pin));
        c.setCardPin(pin);

        System.out.print("Enter the Name of Card Holder: ");
        c.setAccName(ConsInput.getStrinp());
        System.out.print("Enter the Account Number: ");
        c.setAccNumber(ConsInput.getStrinp());
        System.out.print("Enter the current amount or the balance of the Card: ");
        c.setAccBalance(ConsInput.getDouinp());
        ConsInput.skipl();
        return c;

    }

    static boolean cardnotvalid(String cardnum) {

        if (cardnum.length() == 8) {

            char digit = ' ';
            int snum = 0;
            int sum = 0;
            int lastnum = 0, len = 0;
            String lsum;

            for (int i = 0; i < 8; i++) {
                // get 1 character base on the index given then store it to strchar
                digit = cardnum.charAt(i);

                // determine if each character in the string is consider as digit
                if (digit >= 48 && digit <= 57) {

                    // this will convert the each digit extracted in the acctnum to integer using
                    // parseInt then store it to snum
                    snum = Integer.parseInt(cardnum.substring(i, i + 1));

                    // check if the digit is the 1st or 2nd or 5th or 7th digit
                    if (i == 0 || i == 1 || i == 4 || i == 6) {

                        sum += snum; // add the value of snum to sum

                        continue;
                    }

                    // this if statement is to determine if snum holds the last digit
                    if (i == 7) {

                        // convert the value of sum to string then store it to lsum
                        lsum = Integer.toString(sum);

                        // get the length of lsum the store it to len
                        len = lsum.length();

                        // extract the last digit in the lsum and convert it into integer then store it
                        // to lastnum
                        lastnum = Integer.parseInt(lsum.substring(len - 1, len));

                        // check if the sum is equal to the last or 8th digit
                        if (lastnum == snum) {

                            return false;
                        } else {

                            // display the account number is invalid
                            System.out.println("\t-- " + cardnum + " is invalid account number");
                            return true;
                        }
                    }

                }

                // else if the acct number contain other character aside from digit
                else {

                    System.out.println("\t-- " + cardnum + " is invalid account number");
                    return true;
                }

            }

        }

        System.out.println("\t-- " + cardnum + " is invalid account number");
        return true;

    }

    static boolean pinnotvalid(String pin) {

        if (pin.length() == 6) {
            try {
                int d = Integer.parseInt(pin);
            } catch (NumberFormatException nfe) {
                System.out.println("\t-- " + pin + " is invalid pin number");
                return true;
            }
            return false;
        }
        System.out.println("\t-- " + pin + " is invalid pin number");
        return true;
    }

}
