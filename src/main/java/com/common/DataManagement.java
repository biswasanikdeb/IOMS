package com.common;
import java.io.File;

public class DataManagement extends CheckFile {

    File newFile;

    public void addNewData(){
        if (newFile.exists()) {
            System.out.println("FIle Already exists");
        }
        else{
            newFile.mkdirs();
            System.out.println("file created successfully");
        }
    }
    public void modifyData(File oldFile, File newFile){
        
    }

}

