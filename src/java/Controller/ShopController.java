/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.CategoryDao;
import Dao.IDao.ICategoryDao;
import Dao.IDao.IProductDao;
import Dao.ProductDao;
import Model.Category;
import Model.ProductDetail;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * List Product
 * @author MSII
 */
@WebServlet(name = "ShopController", urlPatterns = {"/ShopController"})
public class ShopController extends HttpServlet {

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

        String numP = request.getParameter("indexPage");
        String indexPage = request.getParameter("index");
        String categoryId = request.getParameter("category");
        String name = request.getParameter("name");
        String fromPrice = request.getParameter("fromPrice");
        String toPrice = request.getParameter("toPrice");
        int cid, index;
        Float priceF, priceT;

        IProductDao productDao = new ProductDao();
        ICategoryDao categoryDao = new CategoryDao();

        if (indexPage == null) {
            indexPage = "1";
        }

        // get end page
        int endPageProduct = productDao.getNumberEndPageProducts();

        try {         
            List<Category> categorys = categoryDao.ListAllCategory();

            // Search products follow name, price, category
            index = ((numP == null) || (numP.equals(""))) ? Integer.parseInt(indexPage) : Integer.parseInt(numP);
            cid = (categoryId == null) ? 0 : Integer.parseInt(categoryId);
            priceF = ((fromPrice == null) || (fromPrice.equals(""))) ? null : Float.parseFloat(fromPrice);
            priceT = ((toPrice == null) || (toPrice.equals(""))) ? null : Float.parseFloat(toPrice);

            List<ProductDetail> search = productDao.SearchProducts(name, priceF, priceT, cid, index);
            System.out.println(search);
            request.setAttribute("listproduct", search);
            request.setAttribute("categorys", categorys);
            request.setAttribute("endPageProduct", endPageProduct);
            request.setAttribute("numPage", index);

            //change to the Shop.jsp
            request.getRequestDispatcher("Shop.jsp").forward(request, response);
        } catch (NumberFormatException e) {
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
