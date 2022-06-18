package com.techelevator;

import com.techelevator.view.logs.VendingLog;
import java.io.File;
import java.util.*;

public class Inventory {
    private static Map<String,String> itemType = new HashMap<>();
    private static Map<String, Integer> itemPrice = new HashMap<>();
    private static Map<String, Integer> itemQuantity = new HashMap<>();
    private static File inventoryFile;
    private static List<String> itemSlot=new ArrayList<>();
    private static Map<String,String> itemName = new HashMap<>();
    //added setters and getters for unit testing and changed itemprice from double to int
    public static void setItemName(String key, String value) {
        Inventory.itemName.put(key,value);
    }

    public static void setItemType(String key, String value) {
        Inventory.itemType.put(key,value);
    }

    public static void setItemPrice(String key, int value) {
        Inventory.itemPrice.put(key,value);
    }

    public static void setItemQuantity(String key, int value) {
        Inventory.itemQuantity.put(key,value);
    }

    public static void setItemSlot(String item) {
        Inventory.itemSlot.add(item);
    }
    public static void setInventoryFile(String file){
        Inventory.inventoryFile= new File(file);
    }
    public static List<String> getItemSlot() {
        return itemSlot;
    }

    public static String getUserChoice() {
        return userChoice;
    }

    private static String userChoice;

    public static Map<String, String> getItemName() {
        return itemName;
    }

    public static Map<String, String> getItemType() {
        return itemType;
    }

    public static Map<String, Integer> getItemPrice() {
        return itemPrice;
    }

    public static Map<String, Integer> getItemQuantity() {
        return itemQuantity;
    }


    public static void setInventoryPath(){
//        added try catch block to handle input exceptions, and end program if no filepath set.
        try{
            System.out.println("Please enter filepath for inventory file: ");
            Scanner input = new Scanner(System.in);
            inventoryFile = new File(input.nextLine());
            if (inventoryFile.isFile()){
                return;
            } else{
                System.out.println("No inventory file found to stock inventory.Please try again with a valid inventory filepath.");
                System.exit(1);}
        }catch (Exception e){
            System.out.println("Invalid Entry");
        }}

    public static void restockInventory(){
        try(Scanner inventoryScanner = new Scanner(inventoryFile)){
            String productString;
            String[] productArr;
            while (inventoryScanner.hasNext()){
                productString = inventoryScanner.nextLine();
                productArr = productString.split("\\|");
                double priceConverter = Double.parseDouble(productArr[2]);
                itemSlot.add(productArr[0]);
                itemName.put(productArr[0],productArr[1]);
                itemType.put(productArr[0],productArr[3]);
                itemPrice.put(productArr[0],((int)(priceConverter*100)));
//                set price to be an int without decimal places for arithmetic operations
                itemQuantity.put(productArr[0],5);
                Collections.sort(itemSlot);
            }
        }catch (Exception e){
            System.out.println("No File found.");
        }}
    public static void showInventory(){
        for(String x:itemSlot){
            System.out.println(x+" "+itemName.get(x)+" "+(((double)(itemPrice.get(x)))/100)+" "+itemType.get(x)+" quantity "+(itemQuantity.get(x)>0?itemQuantity.get(x):"Sold Out"));
        }
    }

    public static void setUserChoice(){
        try{
            System.out.println("Please enter the slot of your selection: ");
            Scanner input = new Scanner(System.in);
            //        added line to convert to Capital Case to control for lowercase slot entry
            String initialInput=input.nextLine();
            userChoice= initialInput.toUpperCase();}
        catch (Exception e){
            System.out.println("Invalid Entry. Please enter a valid slot selection.");
        }
    }

    public static void purchase (String insertUserChoice){
//        added try catch block for IO errors and removed userchoice the variable from method and replaced it with
//        a generic parameter variable so we can test method
        try {if (itemQuantity.get(insertUserChoice)==0){
            System.out.println("Sorry product is sold out");
        } else {

            if(itemPrice.get(insertUserChoice)<=Money.getCurrentAmount()){
                VendingLog.log(itemName.get(insertUserChoice)+" $"+Money.displayCurrentAmount()+" $"+ ((Money.displayCurrentAmount()-(((double)itemPrice.get(insertUserChoice))/100))));
                itemQuantity.put((insertUserChoice),itemQuantity.get(insertUserChoice)-1);
                Money.transaction(itemPrice.get(insertUserChoice));
                System.out.println(itemName.get(insertUserChoice)+" "+itemPrice.get(insertUserChoice)+" Current Money Provided: $"+Money.displayCurrentAmount());
                if (itemType.get(insertUserChoice).equalsIgnoreCase("Chip")){
                    System.out.println("Crunch Crunch, Yum!");
                } else if (itemType.get(insertUserChoice).equalsIgnoreCase("Candy")){
                    System.out.println("Munch Munch, Yum!");}
                else if (itemType.get(insertUserChoice).equalsIgnoreCase("Drink")){
                    System.out.println("Glug Glug, Yum!");}
                else if (itemType.get(insertUserChoice).equalsIgnoreCase("Gum")){
                    System.out.println("Chew Chew, Yum!");
                }
            } else {
                System.out.println("Sorry you do not have enough money, please feed more into the machine.");}

        }}catch(Exception e){
            System.out.println("Sorry invalid slot entry, Please try again.");
        }}}
