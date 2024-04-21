package com.inventory;

import com.common.DataManagement;
import com.common.PathBuilder;
import com.common.PathToData;

public class InventoryManagement {
    PathBuilder pb;
    PathToData ptd;
    DataManagement Dtmanagement;
    String source = "data";

    public String pathcreation() {
        pb = new PathBuilder("iventory", source, "name1", "id", "buying price", "selling price", "quantity", "online");
        return pb.getPath();
    }
    

}
