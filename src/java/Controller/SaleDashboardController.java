/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.IDao.IOrderDao;
import Dao.OrderDao;
import Model.Account;
import Model.Person;
import Model.OrderSale;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
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
@WebServlet(name = "SaleDashboardController", urlPatterns = {"/SaleDashboard"})
public class SaleDashboardController extends HttpServlet {

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

        try {
            Account acc = (Account) request.getSession().getAttribute("account");
            if (acc != null) {
                if (acc.getRole() == 2) {
                    String status = request.getParameter("status");
                    String startD = request.getParameter("startD");
                    String endD = request.getParameter("endD");
                    
                    Person sale = (Person) request.getSession().getAttribute("sale");
                    IOrderDao orderDao = new OrderDao();

                    int statusO = (status == null) ? 0 : Integer.parseInt(status);
                    Date dateS = ((startD == null) || (startD.equals(""))) ? null : Date.valueOf(startD);
                    Date dateE = ((endD == null) || (endD.equals(""))) ? null : Date.valueOf(endD);
                    
                    //Statistics Academic Ability of Students In Class
                    List<OrderSale> revenuesTrendses = orderDao.StatisticsRevenuesTrends(sale.getPersonId(), dateS, dateE, statusO);

                    request.setAttribute("revenuesTrendses", revenuesTrendses);
                    request.getRequestDispatcher("Sale/SaleDashboard.jsp").forward(request, response);
                } else {
                    response.sendRedirect("Login");
                }
            } else {
                response.sendRedirect("Login");
            }
        } catch (Exception e) {
            Logger.getLogger(SaleDashboardController.class.getName()).log(Level.SEVERE, null, e);
        }
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
