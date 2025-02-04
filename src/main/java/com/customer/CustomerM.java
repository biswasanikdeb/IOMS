package com.customer;


import com.db.DML;
import com.newCommon.DataManagement;

public class CustomerM extends DataManagement{
    private final String TABLENAME= "CUSTOMERVIEW";
    private final String TABLENAME1= "AUTH";
    private final String TABLENAME2= "CUSTOMER";
    private String headerColumn[] = new String[] {"ID","UserName","Name", "Gender","Phone No","DOB","Address"};
    DML dml = new DML();
    
    
    public Object[][] getData(){ 
        return dml.getTableData(TABLENAME);
    }
    
    public String[] getHeaderColumn(){return this.headerColumn;}
    public int getCustomerID(String username){
        return dml.getColumn(TABLENAME1,username, "USERNAME", "CUSTOMER_ID" );
    }
    public String getName(String username){
        return dml.getColumnS(TABLENAME2,getCustomerID(username), "CUSTOMER_ID", "NAME") ;
    }
    public String getName(int clientId){
        return dml.getColumnS(TABLENAME2,clientId, "CUSTOMER_ID", "NAME") ;
    }
    public String getPhone(String username){
        return dml.getColumnS(TABLENAME2,getCustomerID(username), "CUSTOMER_ID", "PHONE") ;
    }
    public String getPhone(int clientId){
        return dml.getColumnS(TABLENAME2,clientId, "CUSTOMER_ID", "PHONE") ;
    }
    public String getAddr(String username){
        return dml.getColumnS(TABLENAME2,getCustomerID(username), "CUSTOMER_ID", "ADDRESS") ;
    }
    public String getAddr(int clientId){
        return dml.getColumnS(TABLENAME2,clientId, "CUSTOMER_ID", "ADDRESS") ;
    }
}
