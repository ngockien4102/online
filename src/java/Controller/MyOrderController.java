/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.IDao.IOrderDao;
import Dao.IDao.IProductDao;
import Dao.OrderDao;
import Dao.ProductDao;
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
 * List My Order follow status 
 * 1 = ON HOLD
 * 2 = CANCEL
 * 3 = PROGRESS
 * 4 = DONE
 * @author MSII
 */
@WebServlet(name = "MyOrderController", urlPatterns = {"/MyOrder"})
public class MyOrderController extends HttpServlet {

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
        String cancel = request.getParameter("cancel");
        String status = request.getParameter("status");
        String done = request.getParameter("done");
        IProductDao productDao = new ProductDao();
        if (cancel != null) {
            orderDao.payCart(cancel, 2);
            productDao.updateQuantity(cancel);
            response.sendRedirect("MyOrder");
        }else if(done != null){
            orderDao.payCart(done, 4);
            response.sendRedirect("MyOrder");
        }
        else if (cancel == null) {
            if (status == null) {
                status = "1";
            }
            int st = Integer.parseInt(status);
            List<CartContact> cartContacts = orderDao.ListCart(person.getPersonId(), st);
            request.setAttribute("Lcart", cartContacts);
            request.getRequestDispatcher("Customer/MyOrder.jsp").forward(request, response);
        } 
    }


}
