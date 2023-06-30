/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

/**
 *
 * @author Acer
 */
public class Validate {
    public static boolean checkEmptyString(String str) {
        return !(str.equals("")) || !(str.isEmpty());
    }
    
    public static boolean checkPresentDate(String value) {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        df.setLenient(false);
        Date date = null;
        Date now = new Date();
        while (true) {
            try {
                if (value.isEmpty()) {
                    System.out.println("Empty!!");
                }

                date = df.parse(value);
                // xu li nhap khong qua so voi ngay hien tai

                if (date.after(now)) {
                    return false;
                }


            } catch (ParseException e) {
                System.out.println("Follow Date format dd-MM-yyyy");
                System.out.println("Please again!!");
            }
            return true;

        }
        
    }

}
