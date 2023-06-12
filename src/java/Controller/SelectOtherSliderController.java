/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.IDao.IMarketingDao;
import Dao.IDao.ISliderDao;
import Dao.MarketingDao;
import Dao.SliderDao;
import Model.Marketing;
import Model.Slider;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * List Slider follow Name Author, Status Search Slider
 *
 * @author MSII
 */
@WebServlet(name = "SelectOtherSliderController", urlPatterns = {"/SelectOtherSlider"})
public class SelectOtherSliderController extends HttpServlet {

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
        String Aname = request.getParameter("Aname");
        String status = request.getParameter("status");
        if (Aname != null) {
            int mid = Integer.parseInt(Aname);
            ISliderDao sliderDao = new SliderDao();
            IMarketingDao marketingDao = new MarketingDao();
            List<Slider> sliders = sliderDao.ListPersonCreate(mid);
            System.out.println(sliders);
            List<Marketing> ms = marketingDao.ListAuthor();
            request.setAttribute("Author", ms);
            request.setAttribute("LSlider", sliders);
            request.getRequestDispatcher("Marketing/ListSlider.jsp").forward(request, response);
        } else if (status != null) {
            int mid = Integer.parseInt(status);
            ISliderDao sliderDao = new SliderDao();
            IMarketingDao marketingDao = new MarketingDao();
            List<Slider> sliders = sliderDao.SliderSatus(mid);
            List<Marketing> ms = marketingDao.ListAuthor();
            request.setAttribute("Author", ms);
            request.setAttribute("LSlider", sliders);
            request.getRequestDispatcher("Marketing/ListSlider.jsp").forward(request, response);
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

        String title = request.getParameter("title");
        ISliderDao sliderDao = new SliderDao();
        IMarketingDao marketingDao = new MarketingDao();
        List<Slider> sliders = sliderDao.SeachTitleSilder(title);
        List<Marketing> ms = marketingDao.ListAuthor();
        request.setAttribute("Author", ms);
        request.setAttribute("LSlider", sliders);
        request.getRequestDispatcher("Marketing/ListSlider.jsp").forward(request, response);
    }
}
