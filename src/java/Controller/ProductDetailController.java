/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.FeedBackDao;
import Dao.IDao.IFeedBackDao;
import Dao.IDao.IProductDao;
import Dao.ProductDao;
import Model.Feedback;
import Model.Person;
import Model.ProductDetail;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Product Detail
 *
 * @author MSII
 */
@WebServlet(name = "ProductDetail", urlPatterns = {"/ProductDetail"})
public class ProductDetailController extends HttpServlet {

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
        IFeedBackDao feedBackDao = new FeedBackDao();
        Person person = (Person) request.getSession().getAttribute("customer");
        int productID = Integer.parseInt(request.getParameter("pid"));

        IProductDao productDao = new ProductDao();
        //list product by product id
        ProductDetail products = productDao.GetProductbyId(productID);
        //list 6 new product at productDetail.jsp
        List<ProductDetail> list6newP = productDao.List6NewProduct();
        if (person == null) {
            int ps = 0;
            Feedback feedback = feedBackDao.CheckFeedBack(productID, ps);
            List<Feedback> list = feedBackDao.ListFeedBack(productID);
            request.setAttribute("ListF", list);
            request.setAttribute("f", feedback);
            request.setAttribute("products", products);
            request.setAttribute("list6newP", list6newP);
            request.getRequestDispatcher("productDetail.jsp").forward(request, response);
        }else{
            Feedback feedback = feedBackDao.CheckFeedBack(productID, person.getPersonId());
            List<Feedback> list = feedBackDao.ListFeedBack(productID);
            request.setAttribute("ListF", list);
            request.setAttribute("f", feedback);
            request.setAttribute("products", products);
            request.setAttribute("list6newP", list6newP);
            request.getRequestDispatcher("productDetail.jsp").forward(request, response);
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
}
