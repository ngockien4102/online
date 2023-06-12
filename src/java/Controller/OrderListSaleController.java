/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.IDao.IOrderDao;
import Dao.OrderDao;
import Model.Account;
import Model.OrderSale;
import Model.Person;
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
@WebServlet(name = "OrderListSaleController", urlPatterns = {"/OrderListSale"})
public class OrderListSaleController extends HttpServlet {

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
                    //sort
                    String sortOrder = request.getParameter("sortOrder");

                    String indexPage = request.getParameter("index");
                    String oid = request.getParameter("oid");
                    String name = request.getParameter("name");
                    String status = request.getParameter("status");
                    String startD = request.getParameter("startD");
                    String endD = request.getParameter("endD");

                    if (indexPage == null) {
                        indexPage = "1";
                    }
                    
                    Person sale = (Person) request.getSession().getAttribute("sale");
                    IOrderDao orderDao = new OrderDao();

                    // get end page
                    int endPageOrderList = orderDao.getNumberEndPageOrderList();

                    // Search products follow name, price, category && filter status, date from, date to
                    int index = Integer.parseInt(indexPage);
                    int orderid = ((oid == null) || (oid.equals(""))) ? 0 : Integer.parseInt(oid);
                    int statusO = (status == null) ? 0 : Integer.parseInt(status);
                    Date dateS = ((startD == null) || (startD.equals(""))) ? null : Date.valueOf(startD);
                    Date dateE = ((endD == null) || (endD.equals(""))) ? null : Date.valueOf(endD);

                    //Statistics Academic Ability of Students In Class
                    List<OrderSale> orderSales = orderDao.SearchOrderListPaging(sale.getPersonId(), orderid, name, sortOrder, index,
                            dateS, dateE, statusO);

                    request.setAttribute("orderSales", orderSales);
                    request.setAttribute("endPageOrderList", endPageOrderList);
                    request.setAttribute("numPage", index);
                    request.setAttribute("sort", sortOrder);
                    request.setAttribute("oidO", orderid);
                    request.setAttribute("nameO", name);
                    request.setAttribute("statusO", statusO);
                    request.setAttribute("startDO", dateS);
                    request.setAttribute("endDO", dateE);

                    request.getRequestDispatcher("Sale/OrderListSale.jsp").forward(request, response);
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

}
