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
import model.Contract;
import model.Student;
import utils.Validate;

/**
 *
 * @author Acer
 */
public class StudentLoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        try {
            if (Validate.checkEmptyString(password) && Validate.checkEmptyString(account)) {
                Student s = new Student(account, password);
                Contract c = new Contract();
                Student stu = s.getStudent();
                if (stu != null) {
                    Contract con = c.getContract(stu.getId());
                    HttpSession session = req.getSession();
                    session.setAttribute("account", account);
                    session.setAttribute("studentId", stu.getId());
                    session.setAttribute("sname", stu.getFullName());
                    if (con != null) {
                        session.setAttribute("roomid", con.getRoomId());
                    } else {
                        session.setAttribute("roomid", "N/A");
                    }
                    req.getRequestDispatcher("StudentHomePage.jsp").forward(req, resp);
                } else {
                    req.setAttribute("account", account);
                    req.setAttribute("password", password);
                    req.getRequestDispatcher("StudentLogin.jsp").forward(req, resp);
                }
            } else {
                req.setAttribute("account", account);
                req.setAttribute("password", password);
                req.getRequestDispatcher("StudentLogin.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            req.setAttribute("account", account);
            req.setAttribute("password", password);
            req.getRequestDispatcher("StudentLogin.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("StudentLogin.jsp");
    }

}
