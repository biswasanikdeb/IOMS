package com.common;
import java.io.*;

public class CheckFile {


    public CheckFile(){
    }

    File newFile;

    
    public boolean checkFile( File newFile){
        if (newFile.exists()) {
            return true;
        }
        else{
            return false;
        }
    }
    public boolean createFile(File newFile){
        boolean success = checkFile(newFile);
        if(success == false){
            try {
                newFile.createNewFile();
                System.out.println("File Created Successfully");

            } catch (Exception e) {
                System.err.println(e);
            }
            return checkFile(newFile);
        }
        else{
            return false;   //will return false if file already exists
        }
    }
}
