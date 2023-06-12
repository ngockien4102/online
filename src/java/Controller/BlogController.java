/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.BlogDao;
import Dao.IDao.IBlogDao;
import Model.Blog;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MSII
 */
@WebServlet(name = "BlogController", urlPatterns = {"/BlogController"})
public class BlogController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String numP = request.getParameter("indexPage");
        String indexPage = request.getParameter("index");
        String text = request.getParameter("textSearch");
        
        int index;
        
        IBlogDao blogDao = new BlogDao();

        if (indexPage == null) {
            indexPage = "1";
        }

        // get end page
        int endPageBlog = blogDao.getNumberEndPageBlog();

        try {
            // check number page null or not
            index = ((numP == null) || (numP.equals(""))) ? Integer.parseInt(indexPage) : Integer.parseInt(numP);

            List<Blog> topblogs = blogDao.List3NewBlog();
            // Search blog follow title, description and Paging
            List<Blog> searchBlog = blogDao.searchBlog(text, index);

            request.setAttribute("blogs", searchBlog);
            request.setAttribute("topblogs", topblogs);
            request.setAttribute("endPageBlog", endPageBlog);
            request.setAttribute("numPage", index);

            //change to the Blog.jsp
            request.getRequestDispatcher("Blog.jsp").forward(request, response);
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
