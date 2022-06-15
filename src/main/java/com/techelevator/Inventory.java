package com.techelevator;

import com.techelevator.view.logs.VendingLog;

import java.io.File;
import java.util.*;

public class Inventory {
    private static Map<String,String> itemName = new HashMap<>();
    private static Map<String,String> itemType = new HashMap<>();
    private static Map<String, Double> itemPrice = new HashMap<>();
    private static Map<String, Integer> itemQuantity = new HashMap<>();
    private static File inventoryFile;
    private static List<String> itemSlot=new ArrayList<>();
    private static String userChoice;

    public Map<String, String> getItemName() {
        return itemName;
    }

    public Map<String, String> getItemType() {
        return itemType;
    }

    public Map<String, Double> getItemPrice() {
        return itemPrice;
    }

    public Map<String, Integer> getItemQuantity() {
        return itemQuantity;
    }


    public static void setInventoryPath(){
        System.out.println("Please enter filepath for inventory file: ");
        Scanner input = new Scanner(System.in);
        inventoryFile = new File(input.nextLine());
        if (inventoryFile.isFile()){
            return;
        } else{
            System.out.println("Invalid filepath entered. File not found");
        }
    input.close();
    }

    public static void restockInventory(){
        try(Scanner inventoryScanner = new Scanner(inventoryFile)){
            String productString;
            String[] productArr;
            while (inventoryScanner.hasNext()){
                productString = inventoryScanner.nextLine();
                productArr = productString.split("\\|");


                itemSlot.add(productArr[0]);
                itemName.put(productArr[0],productArr[1]);
                itemType.put(productArr[0],productArr[3]);
                itemPrice.put(productArr[0],Double.parseDouble(productArr[2]));
                itemQuantity.put(productArr[0],5);
                Collections.sort(itemSlot);
            }
        }catch (Exception e){
            System.err.println(e.getMessage());
        }

    }

    public static void showInventory(){
        for(String x:itemSlot){
            System.out.println(x+" "+itemName.get(x)+" "+itemPrice.get(x)+" "+itemType.get(x)+" quantity "+(itemQuantity.get(x)>0?itemQuantity.get(x):"Sold Out"));
        }
    }

    public static void getUserChoice(){
        System.out.println("Please enter the slot of your selection: ");
        Scanner input = new Scanner(System.in);
        userChoice=input.nextLine();
        input.close();
    }

    public static void purchase (){
        if (itemName.get(userChoice).equals(null)){
            System.out.println("Sorry invalid slot entry, Please try again");
        } else if (itemQuantity.get(userChoice)==0){
            System.out.println("Sorry product is sold out");
        } else{

            if(itemPrice.get(userChoice)<=Money.getCurrentAmount()){
                VendingLog.log(itemName.get(userChoice)+" "+Money.getCurrentAmount()+" "+ (Money.getCurrentAmount()-itemPrice.get(userChoice)));
                itemQuantity.put((userChoice),itemQuantity.get(userChoice)-1);
                Money.transaction(itemPrice.get(userChoice));
                System.out.println(itemName.get(userChoice)+" "+itemPrice.get(userChoice)+" "+Money.getCurrentAmount());
                if (itemType.get(userChoice).equalsIgnoreCase("Chip")){
                    System.out.println("Crunch Crunch, Yum!");
                } else if (itemType.get(userChoice).equalsIgnoreCase("Candy")){
                    System.out.println("Munch Munch, Yum!");}
                    else if (itemType.get(userChoice).equalsIgnoreCase("Drink")){
                        System.out.println("Glug Glug, Yum!");}
                else if (itemType.get(userChoice).equalsIgnoreCase("Gum")){
                    System.out.println("Chew Chew, Yum!");
            }
        }

    }}}


