package com.techelevator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Money {
    private double currentAmount;
    private double change;

    public double getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(double currentAmount) {
        this.currentAmount = currentAmount;
    }

    public double getChange() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }

    public void moneyInput(double amount){
        currentAmount += amount;
    }

    public void transaction(double amount){
        currentAmount -= amount;
    }

    public void change(){

        Map<String, Integer> moneyCount = new HashMap<>();
        int quantity = 0;

        while (currentAmount > 0){
            if(currentAmount >= 10){
                quantity = (int)currentAmount/10;
                moneyCount.put("10",quantity);
                currentAmount -= 10*quantity;
            }else if(currentAmount >= 5){
                quantity = (int)currentAmount/5;
                moneyCount.put("5",quantity);
                currentAmount -= 5*quantity;
            }else if(currentAmount >= 2){
                quantity = (int)currentAmount/2;
                moneyCount.put("2",quantity);
                currentAmount -= 2*quantity;
            }else if (currentAmount >= 1){
                quantity = (int)currentAmount;
                moneyCount.put("1",quantity);
                currentAmount -= quantity;
            }else if (currentAmount >= 0.25){
                System.out.println("In 25");
                quantity = (int)(currentAmount/0.25);
                moneyCount.put("0.25",quantity);
                currentAmount -= 0.25*quantity;
            }else if (currentAmount >= 0.10){
                System.out.println("In 10");
                quantity = (int)(currentAmount/0.10);
                moneyCount.put("0.10",quantity);
                currentAmount -= 0.10*quantity;
                System.out.println(currentAmount);
            }else if (currentAmount >= 0.05){
                System.out.println("In 5");
                quantity = (int)(currentAmount/0.05);
                moneyCount.put("0.05",quantity);
                currentAmount -= 0.05*quantity;
            }
        }


        for(Map.Entry<String, Integer> billPair : moneyCount.entrySet() ){
            System.out.println(billPair.getKey());
            System.out.println(billPair.getValue());
            System.out.println("");
        }



    }
}
