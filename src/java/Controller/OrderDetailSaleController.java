/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.IDao.IOrderDao;
import Dao.OrderDao;
import Model.Account;
import Model.OrderSale;
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
@WebServlet(name = "OrderDetailSaleController", urlPatterns = {"/OrderDetailSale"})
public class OrderDetailSaleController extends HttpServlet {

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
                    int oid = Integer.parseInt(request.getParameter("oid"));

                    IOrderDao orderDao = new OrderDao();

                    OrderSale orderSale = orderDao.GetOrderDetailbyOrderId(oid);

                    request.setAttribute("orderSale", orderSale);
                    request.getRequestDispatcher("Sale/OrderDetailSale.jsp").forward(request, response);
                } else {
                    response.sendRedirect("Login");
                }
            } else {
                response.sendRedirect("Login");
            }
        } catch (Exception e) {
            Logger.getLogger(OrderDetailSaleController.class.getName()).log(Level.SEVERE, null, e);
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
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        try {
            int orderId = Integer.parseInt(request.getParameter("orderId"));
            int status = Integer.parseInt(request.getParameter("status"));
            String noteOrderSale = request.getParameter("noteOrder");
            
            IOrderDao orderDao = new OrderDao();
            OrderSale orderSale = new OrderSale(orderId, status, noteOrderSale);
            // Update status and notes of Order to database
            orderDao.UpdateOrderSale(orderSale);
            //change to the Order Detail Sale
            response.sendRedirect("OrderDetailSale?oid="+orderId);
            
        } catch (Exception e) {
            Logger.getLogger(OrderDetailSaleController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
