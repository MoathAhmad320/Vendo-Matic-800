package com.techelevator;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Inventory {
    Map<String,String> itemName = new HashMap<>();
    Map<String,String> itemType = new HashMap<>();
    Map<String, Double> itemPrice = new HashMap<>();
    Map<String, Integer> itemQuantity = new HashMap<>();

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

    public void restockInventory(){
        File inventoryFile = new File("C:\\Users\\OWNER\\OneDrive\\Documents\\Java\\Merit America\\Week 9 - 10\\capstone-1\\vendingmachine.csv");

        try(Scanner inventoryScanner = new Scanner(inventoryFile)){
            String productString;
            String[] productArr;
            while (inventoryScanner.hasNext()){
                productString = inventoryScanner.nextLine();
                productArr = productString.split("\\|");

//                System.out.println(Arrays.toString(productArr));

                itemName.put(productArr[0],productArr[1]);
                itemType.put(productArr[0],productArr[3]);
                itemPrice.put(productArr[0],Double.parseDouble(productArr[2]));
                itemQuantity.put(productArr[0],5);
            }
        }catch (Exception e){
            System.err.println(e.getMessage());
        }



    }

    public void showInventory(){
        File inventoryFile = new File("C:\\Users\\OWNER\\OneDrive\\Documents\\Java\\Merit America\\Week 9 - 10\\capstone-1\\vendingmachine.csv");

        try(Scanner inventoryScanner = new Scanner(inventoryFile)){
            String productString;

            while (inventoryScanner.hasNext()){
                productString = inventoryScanner.nextLine();
                System.out.println(productString);

            }
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

}
