/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.IDao.IOrderDao;
import Dao.IDao.IProductDao;
import Dao.OrderDao;
import Dao.ProductDao;
import Model.Orders;
import Model.Person;
import Model.ProductDetail;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Add to cart
 *
 * @author MSII
 */
@WebServlet(name = "AddToCartController", urlPatterns = {"/AddToCart"})
public class AddToCartController extends HttpServlet {

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
        Person person = (Person) request.getSession().getAttribute("customer");
        if (person != null) {
            int productId = Integer.parseInt(request.getParameter("productId"));
            IOrderDao orderDao = new OrderDao();
            IProductDao productDao = new ProductDao();
            ProductDetail products = productDao.GetProductbyId(productId);
            Orders orders = orderDao.checkOrder(productId, person.getPersonId());
            if (orders == null) {
                orderDao.insertCart(person.getPersonId(), productId, 1);
                response.sendRedirect("ShopController");
            } else if (orders != null) {
                int quantity = 1;
                int number = quantity + orders.getQuantity();
                String numbers = String.valueOf(number);
                String orderid = String.valueOf(orders.getOrderId());
                if (products.getQuantity() > number) {
                    orderDao.UpdateCart(orderid, numbers);
                    response.sendRedirect("ShopController");
                } else if (products.getQuantity() < number) {
                    request.setAttribute("pro", "quantity is not enough");
                    response.sendRedirect("ShopController");
                }
            }
        } else {
            response.sendRedirect("Login");
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
        Person person = (Person) request.getSession().getAttribute("customer");
        if (person != null) {
            int productId = Integer.parseInt(request.getParameter("productId"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            IOrderDao orderDao = new OrderDao();
            IProductDao productDao = new ProductDao();
            ProductDetail products = productDao.GetProductbyId(productId);
            Orders orders = orderDao.checkOrder(productId, person.getPersonId());
            if (orders == null) {
                orderDao.insertCart(person.getPersonId(), productId, quantity);
                response.sendRedirect("ShopController");
            } else if (orders != null) {
                int number = quantity + orders.getQuantity();
                String numbers = String.valueOf(number);
                String orderid = String.valueOf(orders.getOrderId());
                if (products.getQuantity() > number) {
                    orderDao.UpdateCart(orderid, numbers);
                    response.sendRedirect("ShopController");
                } else if (products.getQuantity() < number) {
                    request.setAttribute("pro", "quantity is not enough");
                    response.sendRedirect("ShopController");
                }
            }
        } else {
            response.sendRedirect("Login");
        }
    }

}
