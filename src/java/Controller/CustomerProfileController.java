/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.PersonDao;
import Model.Person;
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
@WebServlet(name = "CustomerProfileController", urlPatterns = {"/CustomerProfile"})
public class CustomerProfileController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        int accountId = Integer.parseInt(request.getParameter("accountId"));
        PersonDao personDao = new PersonDao();
        Person customer = personDao.ProfilePerson(accountId);
        request.setAttribute("cus", customer);
        request.getRequestDispatcher("Customer/ProfileCustomer.jsp").forward(request, response);
    }
}
