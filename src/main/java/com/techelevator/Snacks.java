package com.techelevator;

import java.io.File;
import java.util.*;

public class Snacks{

        Map<String,String> itemName = new HashMap<>();
        Map<String,String> itemType = new HashMap<>();
        Map<String, Double> itemPrice = new HashMap<>();
        Map<String, Integer> itemQuantity = new HashMap<>();
        List<String> itemSlot=new ArrayList<>();
private File inventoryFile;

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


public void setInventoryPath(){
        System.out.println("Please enter filepath for inventory file: ");
        Scanner input = new Scanner(System.in);
        inventoryFile = new File(input.nextLine());
        if (inventoryFile.isFile()){
        return;
        } else{
        System.out.println("Invalid filepath entered. File not found");
        }
        }

public void restockInventory(){
        try(Scanner inventoryScanner = new Scanner(inventoryFile)){
        String productString;
        String[] productArr;
        while (inventoryScanner.hasNext()){
        productString = inventoryScanner.nextLine();
        productArr = productString.split("\\|");

//                System.out.println(Arrays.toString(productArr));
            itemSlot.add(productArr[0]);
        itemName.put(productArr[0],productArr[1]);
        itemType.put(productArr[0],productArr[3]);
        itemPrice.put(productArr[0],Double.parseDouble(productArr[2]));
        itemQuantity.put(productArr[0],5);
        Collections.sort(itemSlot);
        }
        }catch (Exception e){
        System.err.println(e.getMessage());
        }}

public void print(){
        for(String x:itemSlot){
                System.out.println(x);
        };
}}

