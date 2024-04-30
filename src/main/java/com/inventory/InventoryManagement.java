package com.inventory;

import com.common.DataManagement;
import com.common.PathBuilder;
import com.common.PathToData;
import java.io.*;
import java.lang.Exception;

public class InventoryManagement {
    PathBuilder pb;
    PathToData ptd;
    DataManagement Dtmanagement;
    File fl;
    String source = "data";

    public String pathcreation() {
        pb = new PathBuilder("iventory", source, "name1", "id", "buying price", "selling price", "quantity", "online");
        return pb.getPath();
    }
    public boolean createData(){
        Dtmanagement = new DataManagement();
        fl = new File(pathcreation());
        if (Dtmanagement.checkFile(fl)==false) {
            try {
                Dtmanagement.addNewData(fl);
                return true;
            
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
        return false;
        
    }

}
