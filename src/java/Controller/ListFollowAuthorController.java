/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.BlogDao;
import Dao.IDao.IBlogDao;
import Dao.IDao.IMarketingDao;
import Dao.IDao.ISliderDao;
import Dao.MarketingDao;
import Dao.SliderDao;
import Model.Marketing;
import Model.Post;
import Model.Slider;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * List Post follow Name Author, Slider, Status
 * Search Post
 * @author MSII
 */
@WebServlet(name = "ListFollowAuthorController", urlPatterns = {"/ListFollowAuthor"})
public class ListFollowAuthorController extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        String Aname = request.getParameter("Aname");
        String sliderId = request.getParameter("sliderId");
        String status = request.getParameter("status");
        if (Aname != null) {
            int mid = Integer.parseInt(Aname);
            IBlogDao blogDao = new BlogDao();
            List<Post> posts = blogDao.ListaAuthorPost(mid);
            IMarketingDao marketingDao = new MarketingDao();
            List<Marketing> ms = marketingDao.ListAuthor();
            ISliderDao sliderDao = new SliderDao();
            List<Slider> sliders = sliderDao.ListAllSliderMKT();
            request.setAttribute("sliders", sliders);
            request.setAttribute("Author", ms);
            request.setAttribute("LPost", posts);
            request.getRequestDispatcher("Marketing/ListPost.jsp").forward(request, response);
        } else if (sliderId != null) {
            int sid = Integer.parseInt(sliderId);
            IBlogDao blogDao = new BlogDao();
            List<Post> posts = blogDao.ListSliderPost(sid);
            IMarketingDao marketingDao = new MarketingDao();
            List<Marketing> ms = marketingDao.ListAuthor();
            ISliderDao sliderDao = new SliderDao();
            List<Slider> sliders = sliderDao.ListAllSliderMKT();
            request.setAttribute("sliders", sliders);
            request.setAttribute("Author", ms);
            request.setAttribute("LPost", posts);
            request.getRequestDispatcher("Marketing/ListPost.jsp").forward(request, response);
        } else if (status != null) {
            IBlogDao blogDao = new BlogDao();
            List<Post> posts = blogDao.ListSstatus(status);
            IMarketingDao marketingDao = new MarketingDao();
            List<Marketing> ms = marketingDao.ListAuthor();
            ISliderDao sliderDao = new SliderDao();
            List<Slider> sliders = sliderDao.ListAllSliderMKT();
            request.setAttribute("sliders", sliders);
            request.setAttribute("Author", ms);
            request.setAttribute("LPost", posts);
            request.getRequestDispatcher("Marketing/ListPost.jsp").forward(request, response);
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
        IBlogDao blogDao = new BlogDao();
        String title = request.getParameter("title");
        List<Post> posts = blogDao.SearchPostTitle(title);
        IMarketingDao marketingDao = new MarketingDao();
        List<Marketing> ms = marketingDao.ListAuthor();
        ISliderDao sliderDao = new SliderDao();
        List<Slider> sliders = sliderDao.ListAllSlider();
        request.setAttribute("sliders", sliders);
        request.setAttribute("Author", ms);
        request.setAttribute("LPost", posts);
        request.getRequestDispatcher("Marketing/ListPost.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
