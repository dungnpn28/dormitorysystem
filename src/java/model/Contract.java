/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Acer
 */
public class Contract {

    private int id;
    private String studentId;
    private String roomId;
    private String date;
    private String checkoutDate;
    private String checkinDate;

    public Contract() {
        connect();
    }

    public Contract(int id, String studentId, String roomId, String date, String checkoutDate, String checkinDate) {
        this.id = id;
        this.studentId = studentId;
        this.roomId = roomId;
        this.date = date;
        this.checkoutDate = checkoutDate;
        this.checkinDate = checkinDate;
        connect();
    }

    public Contract(int id, String studentId, String roomId) {
        this.id = id;
        this.studentId = studentId;
        this.roomId = roomId;
        connect();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(String checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public String getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(String checkinDate) {
        this.checkinDate = checkinDate;
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

    public void addContract() {
        try {
            String strAdd = "insert into [BookingContract]"
                    + "(student_id, room_id) "
                    + "values(?,"
                    + " ?,";
            pstm = cnn.prepareStatement(strAdd);
            pstm.setString(1, studentId);
            pstm.setString(2, roomId);
            pstm.execute();

        } catch (Exception e) {
            System.out.println("addContract: " + e.getMessage());
        }
    }

    public Contract getContract(String stuid) {
        Contract c = null;
        try {
            String strSelect = "select * from [BookingContract] "
                    + "where student_id=? ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, stuid);
            rs = pstm.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
                studentId = rs.getString(2);
                roomId = rs.getString(3);
                c = new Contract(id, studentId, roomId);
            }
        } catch (Exception e) {
            System.out.println("getContract:" + e.getMessage());
        }
        return c;
    }
}
