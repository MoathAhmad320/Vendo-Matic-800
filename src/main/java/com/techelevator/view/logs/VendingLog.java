package com.techelevator.view.logs;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class VendingLog {
    private static File logFile;
    //added try catch block to handle input exceptions, and end program if no filepath set.
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

    public static void log(String message){
//        cleaned up date time format
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
        Date date = new Date();
        try(PrintWriter logWriter = new PrintWriter(new FileOutputStream(logFile, true))){
            logWriter.println(dateFormat.format(date) + " " + message);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
