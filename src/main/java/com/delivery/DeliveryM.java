package com.delivery;

import com.db.DML;

public class DeliveryM extends DML{
    private final String adminside = "DLVADMIN";
    private final String deliveryside = "DLVMN";
    private String adHeaders[] = new String[] {"Emp ID", "Emp Name", "Completed Order", "Pending Order" };
    private String dlvHeaders[] = new String[] {"Order ID", "Name", "Address", "Phone"};
    private int empId;
    public DeliveryM() {}
    public DeliveryM(String username) {
        empId = getColumn("auth", username, "USERNAME", "EMP_ID");
    }
    public DeliveryM(int empId) {
        this.empId = empId;
    }
    public Object[][] getAdminData() {
        return getTableData(adminside);
    }
    public Object[][] getDeliveryData() {
        return getDeliveryData(deliveryside,empId);
    }
    public String[] getAdminHeaders() {
        return this.adHeaders;
    }  
    public String[] getDeliveryHeaders() {
        return this.dlvHeaders;
    }
    public void updateDeliveryStatus(int orderId) {
        updateTable("ORDERS", "STATUS", "DELIVERED", "ORD_ID", orderId);
    }
    public int generateOTP(){
        return (int)(Math.random() * 10000);
    }
}
