/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.BlogDao;
import Dao.IDao.IBlogDao;
import Dao.IDao.IMarketingDao;
import Dao.MarketingDao;
import Model.Account;
import Model.Marketing;
import Model.Post;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MSII
 */
@WebServlet(name = "EditPostController", urlPatterns = {"/EditPost"})
public class EditPostController extends HttpServlet {

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
            out.println("<title>Servlet EditPostController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditPostController at " + request.getContextPath() + "</h1>");
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
        int blogId = Integer.parseInt(request.getParameter("blogId"));
        IBlogDao blogDao = new BlogDao();
        IMarketingDao marketingDao = new MarketingDao();
        Marketing marketing = marketingDao.ProfileMarketing(account.getAccountId());
        Post post = blogDao.PostDetail(blogId);
        request.setAttribute("p", post);
        request.setAttribute("m", marketing);
        request.getRequestDispatcher("Marketing/EditPost.jsp").forward(request, response);
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
        String img = request.getParameter("img");
        int blogId = Integer.parseInt(request.getParameter("blogId"));
        IBlogDao blogDao = new BlogDao();
        Post post = blogDao.PostDetail(blogId);
        if (img.isEmpty()) {
            String title = request.getParameter("title");
            String describe = request.getParameter("describe");
            int codeproduct = Integer.parseInt(request.getParameter("codeproduct"));
            int discount = Integer.parseInt(request.getParameter("discount"));
            int codeslider = Integer.parseInt(request.getParameter("codeslider"));
            blogDao.UpdatePost(title, post.getImg(), describe, codeproduct, discount, codeslider, blogId);
            response.sendRedirect("ProfileMKT");
        }else if(!img.isEmpty()){
            String title = request.getParameter("title");
            String describe = request.getParameter("describe");
            int codeproduct = Integer.parseInt(request.getParameter("codeproduct"));
            int discount = Integer.parseInt(request.getParameter("discount"));
            int codeslider = Integer.parseInt(request.getParameter("codeslider"));
            blogDao.UpdatePost(title, img, describe, codeproduct, discount, codeslider, blogId);
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
