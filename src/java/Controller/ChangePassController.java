/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.AccountDao;
import Dao.IDao.IAccountDao;
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
@WebServlet(name = "ChangePassController", urlPatterns = {"/ChangePass"})
public class ChangePassController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        String oldPass = request.getParameter("oldPass");
        String newPass = request.getParameter("newPass");
        String repass = request.getParameter("repass");
        IAccountDao accountDao = new AccountDao();
        Account account = (Account) request.getSession().getAttribute("account");
        if (oldPass.equals(account.getPassword())) {
            if (newPass.equals(repass)) {
                accountDao.ChangePass(newPass, account.getAccountId());
                response.sendRedirect("Customer/ProfileCustomer.jsp");
            } else if (!newPass.equals(repass)) {
                request.setAttribute("repass", "do not match the password");
                request.getRequestDispatcher("Customer/ProfileCustomer.jsp").forward(request, response);
            }
        } else if (!oldPass.equals(account.getPassword())) {
            request.setAttribute("oldPass", "old password is not correct");
            request.getRequestDispatcher("Customer/ProfileCustomer.jsp").forward(request, response);
        }
    }
}
