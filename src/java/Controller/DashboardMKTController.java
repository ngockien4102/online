/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.IDao.IOrderDao;
import Dao.OrderDao;
import Model.DashBoardMKT;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
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
@WebServlet(name = "DashboardMKTController", urlPatterns = {"/DashboardMKT"})
public class DashboardMKTController extends HttpServlet {

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
            out.println("<title>Servlet DashboardMKTController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DashboardMKTController at " + request.getContextPath() + "</h1>");
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
        IOrderDao orderDao = new OrderDao();
        java.time.LocalDate today = java.time.LocalDate.now();
        String date = String.valueOf(today);
        List<DashBoardMKT> dashBoardMKTs = orderDao.dashboardTrendMKT(date);
        DashBoardMKT custom = orderDao.dashboardCustomMKT(date);
        DashBoardMKT post = orderDao.dashboardCustomMKT(date);
        DashBoardMKT product = orderDao.dashboardProductMKT(date);
        DashBoardMKT fb = orderDao.dashboardFeedBackMKT(date);
        request.setAttribute("d", date);
        request.setAttribute("pd", product);
        request.setAttribute("fb", fb);
        request.setAttribute("p", post);
        request.setAttribute("c", custom);
        request.setAttribute("MKT", dashBoardMKTs);
        request.getRequestDispatcher("Marketing/DashboardMKT.jsp").forward(request, response);
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
        String date = request.getParameter("date");
        IOrderDao orderDao = new OrderDao();
        List<DashBoardMKT> dashBoardMKTs = orderDao.dashboardTrendMKT(date);
        DashBoardMKT custom = orderDao.dashboardCustomMKT(date);
        DashBoardMKT post = orderDao.dashboardCustomMKT(date);
        DashBoardMKT product = orderDao.dashboardProductMKT(date);
        DashBoardMKT fb = orderDao.dashboardFeedBackMKT(date);
        request.setAttribute("d", date);
        request.setAttribute("pd", product);
        request.setAttribute("fb", fb);
        request.setAttribute("p", post);
        request.setAttribute("c", custom);
        request.setAttribute("MKT", dashBoardMKTs);
        request.getRequestDispatcher("Marketing/DashboardMKT.jsp").forward(request, response);
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
