package com.techelevator.view.logs;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class VendingLog {
    private static File logFile;

    public static void setInventoryPath(){
        System.out.println("Please enter filepath for Audit Log file: ");
        Scanner input = new Scanner(System.in);
        logFile = new File(input.nextLine());
        if (logFile.isFile()){
            return;
        } else{
            System.out.println("Invalid filepath entered. File not found");
        }
        input.close();
    }

    public static void log(String message){
        try(PrintWriter logWriter = new PrintWriter(new FileOutputStream(logFile, true))){
            logWriter.println(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS) + " " + message);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
