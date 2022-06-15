package com.techelevator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Money {
    private static double currentAmount;
    private static Map<String, Integer> moneyCount = new HashMap<>();

    public static double getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(double currentAmount) {
        this.currentAmount = currentAmount;
    }

    public static void moneyInput(double amount){
        currentAmount += amount;
    }

    public static void transaction(double amount){
        currentAmount -= amount;
    }

//    public static void change(){
//
//        Map<String, Integer> moneyCount = new HashMap<>();
//        int quantity = 0;
//
//        while (currentAmount > 0){
//            if(currentAmount >= 10){
//                quantity = (int)currentAmount/10;
//                moneyCount.put("10",quantity);
//                currentAmount -= 10*quantity;
//            }else if(currentAmount >= 5){
//                quantity = (int)currentAmount/5;
//                moneyCount.put("5",quantity);
//                currentAmount -= 5*quantity;
//            }else if(currentAmount >= 2){
//                quantity = (int)currentAmount/2;
//                moneyCount.put("2",quantity);
//                currentAmount -= 2*quantity;
//            }else if (currentAmount >= 1){
//                quantity = (int)currentAmount;
//                moneyCount.put("1",quantity);
//                currentAmount -= quantity;
//            }else if (currentAmount >= 0.25){
//                System.out.println("In 25");
//                quantity = (int)(currentAmount/0.25);
//                moneyCount.put("0.25",quantity);
//                currentAmount -= 0.25*quantity;
//            }else if (currentAmount >= 0.10){
//                System.out.println("In 10");
//                quantity = (int)(currentAmount/0.10);
//                moneyCount.put("0.10",quantity);
//                currentAmount -= 0.10*quantity;
//                System.out.println(currentAmount);
//            }else if (currentAmount >= 0.05){
//                System.out.println("In 5");
//                quantity = (int)(currentAmount/0.05);
//                moneyCount.put("0.05",quantity);
//                currentAmount -= 0.05*quantity;
//            }
//        }
//
//
//        for(Map.Entry<String, Integer> billPair : moneyCount.entrySet() ){
//            System.out.println(billPair.getKey());
//            System.out.println(billPair.getValue());
//            System.out.println("");
//        }
//
//
//
//    }}


    public static void changeCalculator(double amount){
        int quantity = 0;
        quantity = (int)(currentAmount/amount);
        moneyCount.put(Double.toString((amount)/100),quantity);
        currentAmount-=(amount*quantity);
    }


    public static void change(){
        currentAmount=(currentAmount*100);
        while (currentAmount > 0){
            if(currentAmount >= 1000){
                changeCalculator(1000);
            }else if(currentAmount >= 500){
                changeCalculator(500);
            }else if(currentAmount >= 200){
                changeCalculator(200);
            }else if (currentAmount >= 100){
                changeCalculator(1);
            }else if (currentAmount >= 25){
                changeCalculator(25);
            }else if (currentAmount >= 10){
                changeCalculator(10);
            }else if (currentAmount >= 5){
                changeCalculator(5);
            }
        }
        for(Map.Entry<String, Integer> billPair : moneyCount.entrySet() ){
            if (Double.parseDouble(billPair.getKey())>=1){
                System.out.println(billPair.getValue()+" $"+billPair.getKey()+"0 bill"+(billPair.getValue()>1?"s":""));}
            else if(Double.parseDouble(billPair.getKey())==.25){
                System.out.println(billPair.getValue()+" quarter"+(billPair.getValue()>1?"s":""));
            } else if(Double.parseDouble(billPair.getKey())==.10){
                System.out.println(billPair.getValue()+" dime"+(billPair.getValue()>1?"s":""));}
            else if(Double.parseDouble(billPair.getKey())==.05){
                System.out.println(billPair.getValue()+" nickle"+(billPair.getValue()>1?"s":""));}
        }
    }}

