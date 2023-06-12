/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.AddressCustomerDao;
import Dao.IDao.IAddressCustomerDao;
import Dao.IDao.IOrderDao;
import Dao.IDao.IProductDao;
import Dao.OrderDao;
import Dao.ProductDao;
import Model.AddressCustomer;
import Model.CartContact;
import Model.Person;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Cart Contact
 *
 * @author MSII
 */
@WebServlet(name = "CartContactController", urlPatterns = {"/CartContact"})
public class CartContactController extends HttpServlet {

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
        Person person = (Person) request.getSession().getAttribute("customer");
        IOrderDao orderDao = new OrderDao();
        IAddressCustomerDao addressCustomerDao = new AddressCustomerDao();
        List<CartContact> cartContacts = orderDao.ListCart(person.getPersonId(), 0);
        AddressCustomer LAddress = addressCustomerDao.CartAddress(person.getPersonId());
        request.setAttribute("a", LAddress);
        request.setAttribute("Lcart", cartContacts);
        request.getRequestDispatcher("Customer/cart.jsp").forward(request, response);
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
        String address = request.getParameter("address");
        String note = request.getParameter("note");
        String[] orderId = request.getParameterValues("orderId");
        String[] quantity = request.getParameterValues("quantity");
        IOrderDao orderDao = new OrderDao();
        IAddressCustomerDao addressCustomerDao = new AddressCustomerDao();
        IProductDao productDao = new ProductDao();
        if (orderId != null) {
            for (int i = 0; i < orderId.length; i++) {
                if (quantity[i] == null) {
                    orderDao.deleteOrder(orderId[i]);
                    response.sendRedirect("ShopController");
                } else {
                    orderDao.UpdateCart(orderId[i], quantity[i]);
                    orderDao.payCart(orderId[i], 1);
                    addressCustomerDao.insertAddress(person.getPersonId(), orderId[i], address, note);
                    productDao.updateQuantity(orderId[i]);
                }
            }
            response.sendRedirect("ShopController");
        } else if (orderId == null) {
            response.sendRedirect("ShopController");
        }

    }

}
