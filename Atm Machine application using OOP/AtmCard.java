
public class AtmCard {
    private String CardNumber;
    private String Account_Number;
    private String Account_Name;
    private String CardPin;
    private double Account_Balance;

    // Setter Method
    public void setCardNumber(String CardNumber) {
        this.CardNumber = CardNumber;
    }

    public void setAccNumber(String Account_Number) {
        this.Account_Number = Account_Number;
    }

    public void setAccName(String Account_Name) {
        this.Account_Name = Account_Name;
    }

    public void setCardPin(String CardPin) {
        this.CardPin = CardPin;
    }

    public void setAccBalance(double Account_Balance) {
        this.Account_Balance = Account_Balance;
    }

    // Getter Methods
    public String getCardNumber() {
        return this.CardNumber;
    }

    public String getAccNumber() {
        return this.Account_Number;
    }

    public String getAccName() {
        return this.Account_Name;
    }

    public String getCardPin() {
        return this.CardPin;
    }

    public double getAccBalance() {
        return this.Account_Balance;
    }

}
