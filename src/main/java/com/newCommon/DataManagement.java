package com.newCommon;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;



public class DataManagement {
    private String data[];
    File newfile;
    

    public void addData(String data1, String data2, File newFile) { // add data to file by tab and new line) {

       
        
        try {
            newfile.createNewFile();
            FileWriter writer = new FileWriter(newfile,true);
            writer.write(data1 + "\t" + data2 + "\n");
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String[] readData(File newFile, Scanner sc) { //reads data by line, has to use in a loop
        
        try {
            while (sc.hasNextLine()) {
            String tempData= sc.nextLine();
            data = tempData.split("\t");
            }
            
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return data;
    }
    public void modifyData(){
        

    }

}
