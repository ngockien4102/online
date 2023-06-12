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
import Model.Account;
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
 *
 * @author MSII
 */
@WebServlet(name = "ProfileMKTController", urlPatterns = {"/ProfileMKT"})
public class ProfileMKTController extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProfileMKTController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProfileMKTController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        Account account = (Account) request.getSession().getAttribute("account");
        Marketing marketings = (Marketing) request.getSession().getAttribute("market");
        String post = request.getParameter("post");
        String slider = request.getParameter("slider");
        IMarketingDao marketingDao = new MarketingDao();
        Marketing marketing = marketingDao.ProfileMarketing(account.getAccountId());
        if (post == null) {
            if (slider == null) {
                post = String.valueOf(marketings.getMarketingId());
                int id = Integer.parseInt(post);
                IBlogDao blogDao = new BlogDao();
                List<Post> posts = blogDao.ListaAuthorPost(id);
                request.setAttribute("LPost", posts);
                request.setAttribute("m", marketing);
                request.getRequestDispatcher("Marketing/ProfileMarket.jsp").forward(request, response);
            } else {
                slider = String.valueOf(marketings.getMarketingId());
                int id = Integer.parseInt(slider);
                ISliderDao sliderDao = new SliderDao();
                List<Slider> sliders = sliderDao.ListPersonCreate(id);
                request.setAttribute("LSlider", sliders);
                request.setAttribute("m", marketing);
                request.getRequestDispatcher("Marketing/ProfileMarket.jsp").forward(request, response);
            }
        } else {
            int id = Integer.parseInt(post);
            IBlogDao blogDao = new BlogDao();
            List<Post> posts = blogDao.ListaAuthorPost(id);
            request.setAttribute("LPost", posts);
            request.setAttribute("m", marketing);
            request.getRequestDispatcher("Marketing/ProfileMarket.jsp").forward(request, response);
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

        Marketing marketing = (Marketing) request.getSession().getAttribute("market");
        String img = request.getParameter("img");
        if (img.isEmpty()) {
            String firstname = request.getParameter("firstname");
            String lastname = request.getParameter("lastname");
            String phone = request.getParameter("phone");
            String date = request.getParameter("date");
            String size = request.getParameter("size");
            int gender = Integer.parseInt(size);
            String address = request.getParameter("address");
            IMarketingDao marketingDao = new MarketingDao();
            marketingDao.UpdateMKT(marketing.getMarketingId(), firstname, lastname, phone, address, gender, date, marketing.getImg());
            response.sendRedirect("ProfileMKT");
        } else if (!img.isEmpty()) {
            String firstname = request.getParameter("firstname");
            String lastname = request.getParameter("lastname");
            String phone = request.getParameter("phone");
            String date = request.getParameter("date");
            String size = request.getParameter("size");
            int gender = Integer.parseInt(size);
            String address = request.getParameter("address");
            IMarketingDao marketingDao = new MarketingDao();
            marketingDao.UpdateMKT(marketing.getMarketingId(), firstname, lastname, phone, address, gender, date, img);
            response.sendRedirect("ProfileMKT");
        }
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
