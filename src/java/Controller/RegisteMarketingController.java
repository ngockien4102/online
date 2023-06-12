/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.IDao.IMarketingDao;
import Dao.MarketingDao;
import Model.Account;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MSII
 */
@WebServlet(name = "RegisteMarketing", urlPatterns = {"/RegisteMarketing"})
public class RegisteMarketingController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        String img = request.getParameter("img");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String birthdate = request.getParameter("birthdate");
        String cccd = request.getParameter("cccd");
        int gender = Integer.parseInt(request.getParameter("gender"));
        Account account = (Account) request.getSession().getAttribute("account");
        IMarketingDao marketingDao = new MarketingDao();
        marketingDao.RegisterMarketing(account.getAccountId(), fname, lname, phone, address, gender, birthdate, cccd, img);
        response.sendRedirect("Index.jsp");
    }
}
