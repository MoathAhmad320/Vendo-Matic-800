package com.techelevator;

import com.techelevator.view.logs.VendingLog;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Money {
    private static int currentAmount;
    private static Map<Double, Integer> moneyCount = new HashMap<>();
    private static int billFed;
//    changed currentamount to int for arithmetic operations and to avoid excessive parsing

    public static int getBillFed() {
        return billFed;
    }

    public static int getCurrentAmount() {
        return currentAmount;
    }
    //    added method for displaying currentamount as a currency value
    public static double displayCurrentAmount(){
        return (currentAmount/100.0);
    }

    public void setCurrentAmount(int currentAmount) {
        this.currentAmount = currentAmount;}


    public static void moneyInput(int amount){
        currentAmount += amount;
    }

    public static void transaction(int amount){
        currentAmount -= amount;
    }


    //    New method to ask for bill amounts
    public static void feedBillsInput(){
        try{
            System.out.print("Please enter dollar Bill to feed into machine: $");
            Scanner input = new Scanner(System.in);
            billFed = Integer.parseInt(input.nextLine());
        } catch (Exception e){
//            we "eat" the exception because it is addressed by the plugin method
        }}

    // testable method that adds bills total
    public static void feedBillsProcessor(int bills){
        if (bills==1||bills==2||bills==5||bills==10||bills==20||bills==50||bills==100){
            Money.moneyInput((bills*100));
            VendingLog.log("Feed Money"+" $"+(Money.displayCurrentAmount()-bills)+" $"+( Money.displayCurrentAmount()));
            System.out.println("Current Money Provided $"+Money.displayCurrentAmount()+"0");
        } else {
            System.out.println("Invalid Entry, Please enter valid whole dollar bills(1,2,5,10,20,50,100)");
        }
    }

    public static void changeCalculator(int amount){
        int quantity = 0;
        quantity = currentAmount/amount;
        moneyCount.put((amount/100.0),quantity);
        currentAmount-=(amount*quantity);
    }
//    adjusted changed method to account for ints instead of doubles

    public static void changeCalculator(){
//        added  20,50, and 100 dollar change statements and added change to audit log
        VendingLog.log("Change Dispensed $"+Money.displayCurrentAmount()+" $0.00");
        while (currentAmount > 0){
            if(currentAmount >= 10000){
                changeCalculator(10000);
            }else if(currentAmount >= 5000) {
                changeCalculator(5000);
            }else if(currentAmount >= 2000){
                changeCalculator(2000);
            }else if(currentAmount >= 1000){
                changeCalculator(1000);
            }else if(currentAmount >= 500){
                changeCalculator(500);
            }else if(currentAmount >= 200){
                changeCalculator(200);
            }else if (currentAmount >= 100){
                changeCalculator(100);
            }else if (currentAmount >= 25){
                changeCalculator(25);
            }else if (currentAmount >= 10){
                changeCalculator(10);
            }else if (currentAmount >= 5){
                changeCalculator(5);
            }
        }}
    //        Split method because it was too long and harder to test
    public static void changePrinter(){
        System.out.println("Your change is:");
        for(Map.Entry<Double, Integer> billPair : moneyCount.entrySet() ){
            if (billPair.getKey()>=1){
                System.out.println((billPair.getValue())+" $"+billPair.getKey()+"0 bill"+(billPair.getValue()>1?"s":""));}
            else if(billPair.getKey()==.25){
                System.out.println(billPair.getValue()+" quarter"+(billPair.getValue()>1?"s":""));
            } else if(billPair.getKey()==.10){
                System.out.println(billPair.getValue()+" dime"+(billPair.getValue()>1?"s":""));}
            else if(billPair.getKey()==.05){
                System.out.println(billPair.getValue()+" nickle"+(billPair.getValue()>1?"s":""));}
        }moneyCount.clear();
    }}
//added clear map line so change runs correctly
