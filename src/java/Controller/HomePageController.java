/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.BlogDao;
import Dao.CategoryDao;
import Dao.IDao.IBlogDao;
import Dao.IDao.ICategoryDao;
import Dao.IDao.IProductDao;
import Dao.IDao.ISliderDao;
import Dao.ProductDao;
import Dao.SliderDao;
import Model.Blog;
import Model.Category;
import Model.ProductDetail;
import Model.Products;
import Model.Slider;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * HomePageController
 * @author MSII
 */
@WebServlet(name = "HomePage", urlPatterns = {"/HomePage"})
public class HomePageController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            String categoryID = request.getParameter("cid");

            if (categoryID == null) {
                categoryID = "1";
            }
            int id = Integer.parseInt(categoryID);
            
            ICategoryDao categoryDao = new CategoryDao();
            IProductDao productDao = new ProductDao();
            IBlogDao blogDao = new BlogDao();
            ISliderDao sliderDao = new SliderDao();

             // List all category
            List<Category> categorys = categoryDao.ListAllCategory();
            //List all product by category id
            List<ProductDetail> products = productDao.GetProductbyCategoryId(id);
            // list 6 new product
            List<ProductDetail> list6newP = productDao.List6NewProduct();
            // list 3 new blog
            List<Blog> blog = blogDao.List3NewBlog();
            //list new slider
            List<Slider> sliders = sliderDao.ListAllSlider();

            request.setAttribute("products", products);
            request.setAttribute("categorys", categorys);
            request.setAttribute("list6newP", list6newP);
            request.setAttribute("blog", blog);
            request.setAttribute("sliders", sliders);
             //change to the Home Page
            request.getRequestDispatcher("Index.jsp").forward(request, response);
        } catch (Exception e) {
            Logger.getLogger(HomePageController.class.getName()).log(Level.SEVERE, null, e);
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
