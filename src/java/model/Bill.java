/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Acer
 */
public class Bill {
    private String id;
    private String roomId;
    private float waterFee;
    private float electricityFee;

    public Bill() {
        connect();
    }

    public Bill(String id, String roomId, float waterFee, float electricityFee) {
        this.id = id;
        this.roomId = roomId;
        this.waterFee = waterFee;
        this.electricityFee = electricityFee;
        connect();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }


    public float getWaterFee() {
        return waterFee;
    }

    public void setWaterFee(float waterFee) {
        this.waterFee = waterFee;
    }

    public float getElectricityFee() {
        return electricityFee;
    }

    public void setElectricityFee(float electricityFee) {
        this.electricityFee = electricityFee;
    }
    
    Connection cnn;
    Statement stm;
    PreparedStatement pstm;
    ResultSet rs;

    private void connect() {
        try {
            cnn = (new DBContext()).connection;
            if (cnn != null) {
                System.out.println("Connect success");
            }
        } catch (Exception e) {
            System.out.println("Fail: " + e.getMessage());
        }
    }
    
    public ArrayList<Bill> getBillById(String room_id) {
        ArrayList<Bill> list = new ArrayList<>();
        connect();
        try {
            String strSlect = "select * from Products ";
            cnn = (new DBContext()).connection;
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE); //tạo stm
            rs = stm.executeQuery(strSlect);
            while (rs.next()) {
                String billId = rs.getString(1);
                String roomId = room_id;
                float waterFee = rs.getFloat(3);
                float electricityFee = rs.getFloat(4);
            }
        } catch (Exception e) {
            System.out.println("checkProduct: " + e.getMessage());
        }
        return list;
    }
    
    public ArrayList<Bill> getListProduct() {
        ArrayList<Bill> list = new ArrayList<Bill>();
        connect();
        try {
            String strSlect = "select * from Products ";
            cnn = (new DBContext()).connection;
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE); //tạo stm
            rs = stm.executeQuery(strSlect);
            while (rs.next()) {
                String BillID = rs.getString(1);
                String RoomID = rs.getString(2);
                float WaterFee = rs.getFloat(3);
                float ElectricityFee = rs.getFloat(4);
                list.add(new Bill(BillID, RoomID, WaterFee, ElectricityFee));
            }
        } catch (Exception e) {
            System.out.println("checkProduct: " + e.getMessage());
        }
        return list;
    }

    
 
}
