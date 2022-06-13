package com.techelevator.view.logs;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class VendingLog {

    public static void log(String message){
        File logFile = new File("C:\\Users\\OWNER\\OneDrive\\Documents\\Java\\Merit America\\Week 9 - 10\\capstone-1\\src\\main\\java\\com\\techelevator\\view\\logs\\Log.txt");

        try(PrintWriter logWriter = new PrintWriter(new FileOutputStream(logFile, true))){
            logWriter.println(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS) + " " + message);

        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
