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
@WebServlet(name = "EditUserAdminController", urlPatterns = {"/EditUserAdmin"})
public class EditUserAdminController extends HttpServlet {

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
                    request.getRequestDispatcher("Admin/EditUserAdmin.jsp").forward(request, response);
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
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        try {
            // take accountid from form Update User
            int accountid = Integer.parseInt(request.getParameter("accountid"));
            // take personid from form Update User
            int personid = Integer.parseInt(request.getParameter("personid"));
            // take role from form Update User
            int role = Integer.parseInt(request.getParameter("role"));
            // take status from form Update User
            int status = Integer.parseInt(request.getParameter("status"));

            IPersonDao personDao = new PersonDao();
            
            Account account = new Account(accountid, role);
            Person person = new Person(personid, status);
            // Update userList
            personDao.UpdateUser(person, account);
            //change to the UserList Admin
            response.sendRedirect("UserListAdmin");
        } catch (Exception e) {
            Logger.getLogger(EditUserAdminController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
