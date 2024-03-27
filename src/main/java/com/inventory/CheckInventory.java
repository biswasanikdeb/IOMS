package com.inventory;
import java.io.*;
import com.common.CheckFile;

public class CheckInventory {
    CheckFile filecheck = new CheckFile();
    File newFile = new File("E:\\PS_project\\JAVA-PROJECT\\src\\main\\java\\com\\inventory\\inventory.json");
    boolean success = filecheck.checkFile(newFile);
    public boolean  anyreturn(){
        return success;
    }
}
