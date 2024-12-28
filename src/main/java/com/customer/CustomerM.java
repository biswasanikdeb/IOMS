package com.customer;


import com.db.DML;
import com.newCommon.DataManagement;

public class CustomerM extends DataManagement{
    private final String TABLENAME= "CUSTOMER";
    private String headerColumn[] = new String[] {"SL. No","UserName ","Name", "Gender","Phone No","DOB","Address"};
    DML dml = new DML();
    
    
    public Object[][] getData(){ 
        return dml.getTableData(TABLENAME);
    }
    
    public String[] getHeaderColumn(){return this.headerColumn;}
}
