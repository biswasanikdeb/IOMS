package com.common;

import java.io.File;
import java.io.IOException;

public class DataManagement extends CheckFile {

    File newFile;

    public String checkData(File file)  {
        String path = "no data found";
        if (file.exists()) {

            for (File subFile : file.listFiles()) {
                if (subFile.isDirectory()) {
                    checkData(subFile);
                } else if (subFile.isFile()) {

                    path = subFile.getAbsolutePath();
                    break;
                }

            }
        }
        return path;
    }

    public static void deleteData(File file) throws IOException {
        for (File subfile : file.listFiles()) {
            if (subfile.isDirectory()) {
                deleteData(subfile);
            }
            subfile.delete();
        }
    }

    public void addNewData(File newFile) throws IOException {
        if (newFile.exists()) {
            System.out.println("FIle Already exists");
        } else {
            newFile.mkdirs();
            System.out.println("file created successfully");
        }
    }

    public void modifyData(File oldFile, File newFile) {
        boolean isThere = super.checkFile(oldFile);
        try{
            if (isThere) {
                deleteData(oldFile);
                newFile.mkdirs();
            } 
            else {
                System.out.println("No Data found");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}
