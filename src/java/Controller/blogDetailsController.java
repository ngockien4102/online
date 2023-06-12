/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;


import Dao.BlogDao;
import Dao.IDao.IBlogDao;
import Model.Blog;
import Model.BlogDetails;
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
 * Blog Detail
 * @author quang
 */
@WebServlet(name = "blogDetailsController", urlPatterns = {"/blogDetailsController"})
public class BlogDetailsController extends HttpServlet {

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
            String blogID = request.getParameter("bid");
            String sliderId = request.getParameter("sid");        
            
            IBlogDao blogDao = new BlogDao();
            
            // list blog detail by blog id
            if(blogID != null){
                BlogDetails blogdetails = blogDao.GetBlogbyId(Integer.parseInt(blogID));
                request.setAttribute("blog", blogdetails);
            }
            
            // list blog detail by slider id from Homepage.jsp
            if(sliderId != null){
                BlogDetails blogDetailsBySliderId = blogDao.ViewBlogbySliderId(Integer.parseInt(sliderId));
                request.setAttribute("blog", blogDetailsBySliderId);
            }
            // List 3 new Blog at blogDetail.jsp
            List<Blog> blog = blogDao.List3NewBlog();            
            request.setAttribute("topblog", blog);
            
            request.getRequestDispatcher("blogDetail.jsp").forward(request, response);
        } catch (Exception e) {
            Logger.getLogger(BlogDetailsController.class.getName()).log(Level.SEVERE, null, e);
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
