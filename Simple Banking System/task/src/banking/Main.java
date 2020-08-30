package banking;

import org.sqlite.SQLiteDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        ConnectDB db = new ConnectDB(args[1]);
        db.createTable();
        bank b = new bank();
        b.bank = db.getData();
        loop: while (true) {
            System.out.println("1. Create an account");
            System.out.println("2. Log into account");
            System.out.println("0. Exit");
            Scanner scanner = new Scanner(System.in);
            int a = scanner.nextInt();
            switch (a) {
                case 1: {
                    creatAccount(b,db);

                    break;
                }
                case 2: {
                    logIn(b,db);
                    break;
                }
                case 0: {
                    System.out.println("\nBye!");
                    break loop;
                }
            }
        }
    }



    public static void creatAccount (bank b, ConnectDB db) {

        String num = generateAccNum();

        while (!b.checkNum(num)) {

            String pin = generatePin();
            bankAccount ba = new bankAccount(num, pin, 0);
            b.bank.add(ba);
            db.addData(num,pin);
            System.out.println("Your card has been created");
            System.out.println("Your card number:");
            System.out.println(num);
            System.out.println("Your card PIN:");
            System.out.println(pin + "\n");
        }
    }



        private static void logIn (bank b, ConnectDB db) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your card number:");
            String num = scanner.next();
            System.out.println("Enter your PIN:");
            String p = scanner.next();


            if (b.LogIn(num, p)) {
                System.out.println("You have successfully logged in!\n");
                loop:
                while (true) {
                    System.out.println("1. Balance");
                    System.out.println("2. Add income");
                    System.out.println("3. Do transfer");
                    System.out.println("4. Close account");
                    System.out.println("5. Log out");
                    System.out.println("0. Exit");
                    int a = scanner.nextInt();
                    switch (a) {
                        case 1: {
                            System.out.println("Balance: " + b.getBalance(num, p) + "\n");
                            break;
                        }
                        case 2: {
                            addIncome(num, p,db,b);
                            break;
                        }
                        case 3: {
                            makeTransfer(num,p,db,b);
                            break;
                        }
                        case 4: {
                            if (b.delAccount(num, p)) {
                                db.deleteData(num, p);
                                System.out.println("The account has been closed!");
                                break loop;
                            }

                        }
                        case 5: {
                            break loop;
                        }
                        case 0: {
                            System.out.println();
                            System.exit(0);
                            break;
                        }
                    }
                }
            } else System.out.println("Wrong card number or PIN!\n");
        }

     private static void makeTransfer(String num, String p, ConnectDB db, bank b) {
         System.out.println("Enter card number:");
         Scanner scanner = new Scanner(System.in);
         String num2 = scanner.next();
         if (!check(num2)) {
             System.out.println("Probably you made mistake in the card number. Please try again!");
         } else {
                if (b.checkNum(num2)) {
                    String p2 = b.getPin(num2);
                    System.out.println("Enter how much money you want to transfer:");
                    double t = scanner.nextDouble();
                    if (t > b.getBalance(num,p)) {System.out.println("Not enough money!");}
                    else {
                        b.setBalance(num,p,b.getBalance(num,p) - t);
                        System.out.println("before update " + b.getBalance(num,p));
                        db.updateData(num,p,b.getBalance(num,p));

                        b.setBalance(num2,p2,b.getBalance(num2,p2)+t);
                        db.updateData(num2,p2,b.getBalance(num2,p2));
                        System.out.println("Success!");
                    }
                }
         }
     }

    private static void addIncome(String num, String p, ConnectDB db, bank b) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter income:");
        double income = scanner.nextDouble();
        b.addIncome(num,p,income);
        db.updateData(num,p,income);
        System.out.println("Income was added!");

    }


    private static String generateAccNum () {
        Random random = new Random();
        String str1 = "400000";
        String str = "";
        String strf = "";
        int a = 0;
        int b = 0;
        int sum = 0;
        a = random.nextInt(1000000000);
        String str2 = String.format("%09d", a);
        b = random.nextInt(10);

        str = str1 + str2 + b;
        sum = Check(str);
        sum -= b;
        do {
            b = random.nextInt(10);
        } while ((sum + b) % 10 != 0);
        strf = str1 + str2 + b;
        System.out.println(b);
        System.out.println(check(strf));
        //System.out.println(str.length());
        return strf;
    }
        private static String generatePin () {
            Random random = new Random();
            String pin = "";
            pin = pin + String.format("%04d", random.nextInt(10000));
            return pin;
        }
        public static int Check (String ccNumber)
        {
            int sum = 0;
            boolean alternate = false;
            for (int i = ccNumber.length() - 1; i >= 0; i--) {
                int n = Integer.parseInt(ccNumber.substring(i, i + 1));
                if (alternate) {
                    n *= 2;
                    if (n > 9) {
                        n = (n % 10) + 1;
                    }
                }
                sum += n;
                alternate = !alternate;
            }
            return (sum);
        }
        public static boolean check (String ccNumber)
        {
            int sum = 0;
            boolean alternate = false;
            for (int i = ccNumber.length() - 1; i >= 0; i--) {
                int n = Integer.parseInt(ccNumber.substring(i, i + 1));
                if (alternate) {
                    n *= 2;
                    if (n > 9) {
                        n = (n % 10) + 1;
                    }
                }
                sum += n;
                alternate = !alternate;
            }
            return (sum % 10 == 0);
        }
    }

