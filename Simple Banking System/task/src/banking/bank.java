package banking;

import java.util.ArrayList;

public class bank {
    ArrayList<bankAccount> bank;
    bank() {
        this.bank = new ArrayList<bankAccount>();
    }

    boolean checkNum(String num) {
        int i = 0;
        for (; i < bank.size(); i++) {
            if (num.equals(bank.get(i).getAccountNum()) == true) {
                return true;
            }
        }
        return !(i == bank.size());
        }

     String getPin(String num) {
         int i = 0;
         for (; i < bank.size(); i++) {
             if (num.equals(bank.get(i).getAccountNum()) == true) {
                 return bank.get(i).getPin();
             }
         }
         return "";
     }

    boolean LogIn(String num, String pin) {
        int i = 0;
        for (; i < bank.size(); i++) {
            if (num.equals(bank.get(i).getAccountNum()) == true) {
                if (pin.equals(bank.get(i).getPin()) == true) {
                    return true;
                }

            }
        }
        return !(i == bank.size());
    }
    double getBalance(String num, String pin) {
        int i = 0;
        for (; i < bank.size(); i++) {
            if (num.equals(bank.get(i).getAccountNum()) == true) {
                if (pin.equals(bank.get(i).getPin()) == true) {
                    return bank.get(i).getBalance();
                }

            }
        }
        return 0;
    }
    void setBalance(String num, String pin,double b) {
        int i = 0;
        for (; i < bank.size(); i++) {
            if (num.equals(bank.get(i).getAccountNum()) == true) {
                if (pin.equals(bank.get(i).getPin()) == true) {
                     bank.get(i).setBalance(b);
                }

            }
        }
    }
    void addIncome(String num, String pin,double b) {
        int i = 0;
        for (; i < bank.size(); i++) {
            if (num.equals(bank.get(i).getAccountNum()) == true) {
                if (pin.equals(bank.get(i).getPin()) == true) {
                    bank.get(i).setBalance(bank.get(i).getBalance()+b);
                }

            }
        }
    }
    public boolean delAccount(String num, String pin) {
        int i = 0;
        for (; i < bank.size(); i++) {
            if (num.equals(bank.get(i).getAccountNum()) == true) {
                if (pin.equals(bank.get(i).getPin()) == true) {
                    bank.remove(i);
                    return true;
                }

            }
        }
        return false;
    }
}


