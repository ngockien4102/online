/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.AccountDao;
import Dao.IDao.IAccountDao;
import Model.Account;
import Model.Person;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Register
 *
 * @author MSII
 */
@WebServlet(name = "RegisterController", urlPatterns = {"/register"})
public class RegisterController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

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
        processRequest(request, response);
        request.getRequestDispatcher("Register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        String repass = request.getParameter("repass");
        String img = "avt.jpg";
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String phone = request.getParameter("phone");
        String birthdate = request.getParameter("birthdate");
        int gender = Integer.parseInt(request.getParameter("gender"));
        Person person = new Person(img, fname, lname, birthdate, phone, gender);
        IAccountDao accountDao = new AccountDao();
        Account account = accountDao.checkAccount(email);
        if (account != null) {
            request.setAttribute("messRegist", "Username already exists");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        } else {
            if (repass.equals(pass)) {
                accountDao.Register(email, pass, person);
                response.sendRedirect("Login.jsp");
            } else if (!repass.equals(pass)) {
                request.setAttribute("repass", "do not match the password");
                request.getRequestDispatcher("Register.jsp").forward(request, response);
            }
        }
    }
}
