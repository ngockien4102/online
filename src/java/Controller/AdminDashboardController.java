/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.IDao.IOrderDao;
import Dao.OrderDao;
import Model.Account;
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
 * @author MSII
 */
@WebServlet(name = "DashboardController", urlPatterns = {"/dashboard"})
public class AdminDashboardController extends HttpServlet {

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
                if (acc.getRole() == 0) {
                    String startD = request.getParameter("startD");
                    String endD = request.getParameter("endD");
                    
                    IOrderDao orderDao = new OrderDao();
                    Date dateS = ((startD == null) || (startD.equals(""))) ? null : Date.valueOf(startD);
                    Date dateE = ((endD == null) || (endD.equals(""))) ? null : Date.valueOf(endD);
                    
                    //Statistics amount order from date to date
                    List<OrderSale> orderSales = orderDao.StatisticsAmountOrder(dateS, dateE);
                    //Statistics Revenues by product categories
                    List<OrderSale> RproductCategories = orderDao.StatisticsRevenuesCategory(dateS, dateE);
                    // Customers newly registered
                    int newRegistered = orderDao.StatisticsUserRegistered(dateS, dateE);
                    // Customers newly bought
                    int newBought = orderDao.StatisticsNewBought(dateS, dateE);
                    //feedbacks (average star: total, by product categories
                    List<OrderSale> aveStar = orderDao.StatisticsAveStar(dateS, dateE);
                    //Top most ordered products
                    List<OrderSale> topOrder = orderDao.StatisticsTopOrder(dateS, dateE);
                    
                    request.setAttribute("orderAmount", orderSales);
                    request.setAttribute("RproductCategories", RproductCategories);
                    request.setAttribute("newRegistered", newRegistered);
                    request.setAttribute("newBought", newBought);
                    request.setAttribute("aveStar", aveStar);
                    request.setAttribute("topOrder", topOrder);
                    request.getRequestDispatcher("Admin/AdminDashboard.jsp").forward(request, response);
                } else {
                    response.sendRedirect("Login");
                }
            } else {
                response.sendRedirect("Login");
            }
        } catch (Exception e) {
            Logger.getLogger(UserListAdminController.class.getName()).log(Level.SEVERE, null, e);
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

}
