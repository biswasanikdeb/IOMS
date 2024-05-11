package com.newcommon;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.lang.Exception;



public class DataManagement {
    private String data[];
    File newfile;
    

    public void addData(String data1, String data2, File newFile) { // add data to file by tab and new line) {

       
        
        try {
            newFile.createNewFile();
            FileWriter writer = new FileWriter(newFile,true);
            writer.write(data1 + "\t" + data2 + "\n");
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String[] readData(File newFile, Scanner sc) { //reads data by line, has to use in a loop
        
        try {
            
            String tempData= sc.nextLine();
            data = tempData.split("\t");
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return data;
    }
    public void modifyData(String newData, String OldData, File Datafile)throws IOException{
        File tmpfile = new File("./tempfile.txt");
        
        BufferedReader reader = new BufferedReader(new FileReader(Datafile));
        FileWriter writer = new FileWriter(tmpfile);
       

        String line ;
        while ((line =reader.readLine()) != null) {
            line.replaceAll(OldData, newData);
            writer.write(line+ System.lineSeparator());
            
        }
        reader.close();
        writer.close();
        tmpfile.renameTo(Datafile);
        Datafile.delete();
        
       



    }

}
