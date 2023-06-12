/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.IDao.*;
import Dao.*;
import Model.Account;
import Model.Marketing;
import Model.Person;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Login
 * @author MSII
 */
@WebServlet(name = "ControllerLogin", urlPatterns = {"/Login"})
public class LoginController extends HttpServlet {

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
        request.getRequestDispatcher("Login.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String email = request.getParameter("email");
            String pass = request.getParameter("pass");
            IAccountDao accountDao = new AccountDao();
            IMarketingDao marketingDao = new MarketingDao();
            IPersonDao saleDao = new PersonDao();
            Account account = accountDao.checkLogin(email, pass);
            HttpSession session = request.getSession();
            if (account == null) {
                request.setAttribute("mess", "Wrong user or pass");
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            } else if (account.getRole() == 0) {
                session.setAttribute("account", account);
                response.sendRedirect("dashboard");
            } else if (account.getRole() == 1) {
                session.setAttribute("account", account);
                Marketing marketing = marketingDao.ProfileMarketing(account.getAccountId());
                session.setAttribute("market", marketing);
                response.sendRedirect("DashboardMKT");
            } else if (account.getRole() == 2) {
                session.setAttribute("account", account);
                Person sale = saleDao.ProfilePerson(account.getAccountId());
                session.setAttribute("sale", sale);
                response.sendRedirect("SaleDashboard");
            } else {
                session.setAttribute("account", account);
                Person cus = saleDao.ProfilePerson(account.getAccountId());
                session.setAttribute("customer", cus);
                response.sendRedirect("HomePage");

            }
        } catch (Exception e) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
