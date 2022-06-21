package com.techelevator.view.Logs;

import com.techelevator.Inventory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;

public class VendingLog {

    private static File logFile;
    private static String saleReportDirectory;
    static SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
    static SimpleDateFormat dateFormatSales = new SimpleDateFormat("MM_dd_yyyy_hh_mm_a");
    static Date date = new Date();
    public static void setLoggerPath(){
        try{
            System.out.println("Please enter filepath for Audit Log file: ");
            Scanner input = new Scanner(System.in);
            logFile = new File(input.nextLine());
            if (logFile.isFile()){
                return;
            } else{
                System.out.println("Invalid filepath entered, file not found.Please try again valid filepath for Audit log.");
                System.exit(1);
            }
        }catch(Exception e){System.out.println("Invalid Entry");}}

    public static void setSaleReportDirectoryFilePath(){
        try{
            System.out.println("Please enter filepath for Sales Report Directory: ");
            Scanner input = new Scanner(System.in);
            saleReportDirectory = input.nextLine();
            File directoryCheck = new File(saleReportDirectory);
            if (directoryCheck.isDirectory()){
                return;
            } else{
                System.out.println("Invalid filepath entered, Directory not found.Please try again valid filepath for Sale Reports.");
                System.exit(1);
            }
        }catch(Exception e){System.out.println("Invalid Entry");}}

    public static void log(String message){

        try(PrintWriter logWriter = new PrintWriter(new FileOutputStream(logFile, true))){
            logWriter.println(dateFormat.format(date) + " " + message);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    public static void salesReport(){
        File sales = new File(saleReportDirectory+"\\"+"SalesReport_"+dateFormatSales.format(date)+".txt");
        String salespath = sales.toString();
        double salestotal=0;
        if (!sales.exists()){
        try{sales.createNewFile();
            try(PrintWriter logWriter = new PrintWriter(new FileOutputStream(salespath, true))){
                for(Map.Entry<String,Double> x: Inventory.getSalesMap().entrySet()){
                    logWriter.println(x.getKey()+" | "+x.getValue());
                    salestotal+=x.getValue();
                }logWriter.print("\n"+"TOTAL SALES | "+salestotal);
            }
        }catch (Exception e){
        System.out.println("Could not create sales report txt file.");}
        }}
}