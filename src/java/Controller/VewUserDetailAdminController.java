/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.IDao.IPersonDao;
import Dao.PersonDao;
import Model.Account;
import Model.Person;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author quang
 */
@WebServlet(name = "VewUserDetailAdminController", urlPatterns = {"/VewUserDetailAdmin"})
public class VewUserDetailAdminController extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Account acc = (Account) request.getSession().getAttribute("account");
            if (acc != null) {
                if (acc.getRole() == 0) {
                    int userId = Integer.parseInt(request.getParameter("userId"));

                    IPersonDao personDao = new PersonDao();
                    Person person = personDao.viewUserbyID(userId);

                    request.setAttribute("person", person);
                    request.getRequestDispatcher("Admin/UserDetailAdmin.jsp").forward(request, response);
                } else {
                    response.sendRedirect("Login");
                }
            } else {
                response.sendRedirect("Login");
            }
        } catch (Exception e) {
            Logger.getLogger(AddNewUserAdminController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
