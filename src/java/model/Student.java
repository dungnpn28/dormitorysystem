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
public class Student {

    private String id;
    private String account;
    private String password;
    private String fullName;
    private String gender;
    private String dob;
    private String phoneNumber;

    public Student(String id, String account, String password, String fullName) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.fullName = fullName;
        connect();
    }

    public Student(String id, String account, String password) {
        this.id = id;
        this.account = account;
        this.password = password;
        connect();
    }

    public Student() {
        connect();
    }

    public Student(String account, String password) {
        this.account = account;
        this.password = password;
        connect();
    }

    public Student(String id, String account, String password, String fullName, String gender, String dob, String phoneNumber) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.fullName = fullName;
        this.gender = gender;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
        connect();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public boolean checkAccountExist() {
        try {
            String strSelect = "select * from Student "
                    + "where account=? "
                    + "and password=?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, account);
            pstm.setString(2, password);
            rs = pstm.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("checkStudentAccountExist:" + e.getMessage());
        }

        return false;
    }

    public String getStudentIdByAccount(String acc) {
        try {
            String strSelect = "select student_id from Student "
                    + "where account=? ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, acc);
            rs = pstm.executeQuery();
            while (rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception e) {
            System.out.println("checkStudentAccountExist:" + e.getMessage());
        }
        return null;
    }

    public Student getStudent() {
        Student s = null;
        try {
            String strSelect = "select * from [Student] "
                    + "where account=? "
                    + "and password=? ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, account);
            pstm.setString(2, password);
            rs = pstm.executeQuery();
            while (rs.next()) {
                account = rs.getString(2);
                password = rs.getString(3);
                id = rs.getString(1);
                fullName = rs.getString(6);
                s = new Student(id, account, password, fullName);
            }
        } catch (Exception e) {
            System.out.println("getStudent:" + e.getMessage());
        }
        return s;
    }

}
