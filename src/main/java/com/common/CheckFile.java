package com.common;
import java.io.*;

public class CheckFile {
    private String filePathAndName;

    public CheckFile(String filePathAndName){
        this.filePathAndName = filePathAndName;
    }

    File newFile;


    public boolean checkFile(String filePathAndName, File newFile){
        if (newFile.exists()) {
            return true;
        }
        else{
            return false;
        }
    }
    public boolean createFile(String filePathAndName, File newFile){
        boolean success = checkFile(filePathAndName, newFile);
        if(success == false){
            try {
                newFile.createNewFile();
                System.out.println("File Created Successfully");

            } catch (Exception e) {
                System.err.println(e);
            }
            return checkFile(filePathAndName, newFile);
        }
        else{
            return false;
        }
    }
}
