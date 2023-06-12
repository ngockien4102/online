/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.IDao.IPersonDao;
import Dao.PersonDao;
import Model.Person;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Update Profile Customer
 *
 * @author MSII
 */
@WebServlet(name = "UpdateProfileCustomerController", urlPatterns = {"/UpdateProfileCustomer"})
public class UpdateProfileCustomerController extends HttpServlet {

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
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        Person person = (Person) request.getSession().getAttribute("customer");
        String img = request.getParameter("img");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String phone = request.getParameter("phone");
        String birthdate = request.getParameter("birthdate");
        IPersonDao personDao = new PersonDao();
        if (img.isEmpty()) {
            personDao.UpdateProfileCustomer(person.getPersonId(), person.getImg(), fname, lname, birthdate, phone);
            response.sendRedirect("HomePage");
        } else if (!img.isEmpty()) {
            personDao.UpdateProfileCustomer(person.getPersonId(), img, fname, lname, birthdate, phone);
            response.sendRedirect("HomePage");
        }
    }
}
