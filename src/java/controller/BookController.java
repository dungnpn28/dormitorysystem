/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import model.Contract;
import model.Room;

/**
 *
 * @author Acer
 */
public class BookController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Contract c = new Contract();
        Room r = new Room();
        String type = req.getParameter("type");
        String id = req.getParameter("room");
        if (req.getParameter("choosetype") != null) {
            ArrayList<Room> roomData = r.getListRoomByType(Integer.parseInt(type));
            req.setAttribute("roomData", roomData);
            req.setAttribute("type", type);
            HttpSession s = req.getSession();
            if (s.getAttribute("status") != null) {
                if (s.getAttribute("status").equals("booked")) {
                    req.getRequestDispatcher("ChooseRoomBooked.jsp").forward(req, resp);
                } else {
                    req.getRequestDispatcher("ChooseRoom.jsp").forward(req, resp);
                }
            } else {
                req.getRequestDispatcher("ChooseRoom.jsp").forward(req, resp);
            }
        }
        if (req.getParameter("chooseroom") != null) {
            String roomId = req.getParameter("room");
            r.updateRoom(roomId);
            HttpSession s = req.getSession();
            s.setAttribute("status", "booked");
            req.getRequestDispatcher("ChooseType.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("ChooseType.jsp");
    }

}
