package banking;

public class bankAccount {
    private String accountNum;
    private String pin;
    private double balance = 0;
    bankAccount(String num, String pin ) {
        this.accountNum = num;
        this.pin = pin;
    }
    bankAccount(String num, String pin, double balance ) {
        this.accountNum = num;
        this.pin = pin;
        this.balance = balance;
    }

    bankAccount() {}
    void setAccountNum(String num) {
        this.accountNum = num;
    }
    void setPin (String pin ) {
        this.pin = pin;
    }
    void setBalance (double balance) {
        this.balance = balance;
    }
    String getAccountNum() {
        return this.accountNum;
    }
    String getPin() {
        return this.pin;
    }
    double getBalance(){
        return this.balance;
    }

}
