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
public class Room {

    private String id;
    private int numOfSlots;
    private int numOfAvailableSlots;

    public Room(String id, int numOfSlots, int numOfAvailableSlots) {
        this.id = id;
        this.numOfSlots = numOfSlots;
        this.numOfAvailableSlots = numOfAvailableSlots;
        connect();
    }

    public Room() {
        connect();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumOfSlots() {
        return numOfSlots;
    }

    public void setNumOfSlots(int numOfSlots) {
        this.numOfSlots = numOfSlots;
    }

    public int getNumOfAvailableSlots() {
        return numOfAvailableSlots;
    }

    public void setNumOfAvailableSlots(int numOfAvailableSlots) {
        this.numOfAvailableSlots = numOfAvailableSlots;
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

    public ArrayList<Room> getListRoomByType(int type) {
        ArrayList<Room> list = new ArrayList<>();
        connect();
        try {
            String strSlect = "select room_id, num_of_slots, num_of_available_slots from Room "
                    + "where num_of_slots=? ";
            pstm = cnn.prepareCall(strSlect);
            pstm.setInt(1, type);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String roomId = rs.getString(1);
                int slotsNum = rs.getInt(2);
                int avaiSlotsNum = rs.getInt(3);
                list.add(new Room(roomId, slotsNum, avaiSlotsNum));
            }
        } catch (Exception e) {
            System.out.println("getListRoomByType: " + e.getMessage());
        }
        return list;
    }

    public void updateRoom(String id) {
        try {
            String strUpdate = "update Room "
                    + "set num_of_available_slots= num_of_available_slots-1 "
                    + "where room_id=? ";
            pstm = cnn.prepareStatement(strUpdate);
            pstm.setString(1, id);
            pstm.execute();

        } catch (Exception e) {
            System.out.println("update: " + e.getMessage());
        }

    }
}
