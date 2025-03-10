import java.util.ArrayList;

public class AtmRecord {

    public static void viewAcc(ArrayList<AtmCard> atmcards) {

        int i = login(atmcards);

        System.out.println("\n\nAccount Details: ");
        System.out.println("Account Name: " + atmcards.get(i).getAccName());
        System.out.println("Account Number: " + atmcards.get(i).getAccNumber());
        System.out.println("Account Card Number: " + atmcards.get(i).getCardNumber());
        System.out.println("Account Pin: " + atmcards.get(i).getCardPin());
        System.out.println("Account Balance: " + atmcards.get(i).getAccBalance());

    }

    public static void changePIN(ArrayList<AtmCard> atmcards) {

        int i = login(atmcards);
        String pin;
        String newpin;

        do {
            System.out.print("\n\nEnter your previous pin: ");
            pin = ConsInput.getStrinp();
        } while (checkCardPin(atmcards, pin, i));

        System.out.print("Enter your new pin: ");
        newpin = ConsInput.getStrinp();

        System.out.println("Changes Successfully Saved!");
        atmcards.get(i).setCardPin(newpin);

    }

    public static void withdraw(ArrayList<AtmCard> atmcards) {
        int i = login(atmcards);
        double amount = 0, remainingbal = 0;
        System.out.println("\n\nAvailable Balance: " + atmcards.get(i).getAccBalance());
        do {
            remainingbal = 0;
            System.out.print("Enter the amount you want to withdraw: ");
            amount = ConsInput.getDouinp();
            remainingbal = atmcards.get(i).getAccBalance() - amount;
            if (remainingbal < 0) {
                System.out.println("Insufficient Balance!");
            }
        } while (remainingbal < 0);
        atmcards.get(i).setAccBalance(remainingbal);
        System.out.println("Withdraw Successfully!");
        System.out.println("Remaining Balance: " + atmcards.get(i).getAccBalance());

    }

    public static void deposit(ArrayList<AtmCard> atmcards) {
        int i = login(atmcards);
        double amount = 0, updatedbal = 0;
        do {
            updatedbal = 0;
            System.out.print("\n\nEnter the amount you want to deposit ");
            amount = ConsInput.getDouinp();
            updatedbal = atmcards.get(i).getAccBalance() + amount;

            if (amount < 0)
                System.out.println("Invalid amount of deposit!");
        } while (amount < 0);

        atmcards.get(i).setAccBalance(updatedbal);
        System.out.println("Deposited Successfully!");
        System.out.println("Total Balance: " + atmcards.get(i).getAccBalance());
    }

    public static boolean checkCardNum(ArrayList<AtmCard> atmcards, String cardnum) {

        for (int i = 0; i < atmcards.size(); i++) {
            if (atmcards.get(i).getCardNumber().equals(cardnum))
                return false;
        }
        System.out.println("The card you entered is incorrect");
        return true;
    }

    public static boolean checkCardPin(ArrayList<AtmCard> atmcards, String pin, int i) {

        if (atmcards.get(i).getCardPin().equals(pin))
            return false;

        System.out.println("The pin you entered is incorrect");
        return true;

    }

    public static int getCardPosition(ArrayList<AtmCard> atmcards, String cardnum) {
        int pos = 0;
        for (int i = 0; i < atmcards.size(); i++) {
            if (atmcards.get(i).getCardNumber().equals(cardnum))
                pos = i;
        }

        return pos;
    }

    public static int login(ArrayList<AtmCard> atmcards) {

        String cardnum;
        String pin;
        int index;
        ConsInput.skipl();
        do {
            System.out.print("\n\nEnter the Card Number: ");
            cardnum = ConsInput.getStrinp();
        } while (App.cardnotvalid(cardnum) || checkCardNum(atmcards, cardnum));

        index = getCardPosition(atmcards, cardnum);
        do {
            System.out.print("Enter the 6 digit Pin Number: ");
            pin = ConsInput.getStrinp();
        } while (App.pinnotvalid(pin) || checkCardPin(atmcards, pin, index));

        return index;
    }

}
