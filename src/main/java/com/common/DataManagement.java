package com.common;

import java.io.File;

public class DataManagement extends CheckFile {

    File newFile;

    public static void deleteData(File file) {
        for (File subfile : file.listFiles()) {
            if (subfile.isDirectory()) {
                deleteData(file);
            }
            subfile.delete();
        }
    }

    public void addNewData() {
        if (newFile.exists()) {
            System.out.println("FIle Already exists");
        } else {
            newFile.mkdirs();
            System.out.println("file created successfully");
        }
    }

    public void modifyData(File oldFile, File newFile) {
        boolean isThere = super.checkFile(oldFile);

        if (isThere) {
            deleteData(oldFile);
        }
        newFile.mkdirs();

    }

}
