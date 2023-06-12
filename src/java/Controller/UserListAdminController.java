/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.IDao.IPersonDao;
import Dao.PersonDao;
import Model.Account;
import Model.Person;
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
 *
 * @author quang
 */
@WebServlet(name = "UserListAdminController", urlPatterns = {"/UserListAdmin"})
public class UserListAdminController extends HttpServlet {

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
            Account acc = (Account) request.getSession().getAttribute("account");
            if (acc != null) {
                if (acc.getRole() == 0) {
                    //sort
                    String sortOrder = request.getParameter("sortOrder");
                    //search & filter
                    String indexPage = request.getParameter("index");
                    String name = request.getParameter("name");
                    String email = request.getParameter("email");
                    String phone = request.getParameter("phone");
                    String gender = request.getParameter("gender");
                    String role = request.getParameter("role");
                    String statusP = request.getParameter("statusP");

                    if (indexPage == null) {
                        indexPage = "1";
                    }

                    IPersonDao personDao = new PersonDao();

                    // get end page
                    int endPageUserList = personDao.getNumberEndPageUserList();

                    // Search user follow name, email, phone && filter gender, status, role
                    int index = Integer.parseInt(indexPage);
                    int genderU = (gender == null) ? 2 : Integer.parseInt(gender);
                    int roleU = (role == null) ? 0 : Integer.parseInt(role);
                    int statusU = (statusP == null) ? 2 : Integer.parseInt(statusP);

                    List<Person> persons = personDao.SearchUserListPaging(name, email, phone, genderU,
                            roleU, statusU, sortOrder, index);

                    request.setAttribute("persons", persons);
                    request.setAttribute("endPageUserList", endPageUserList);
                    request.setAttribute("numPage", index);
                    request.setAttribute("sort", sortOrder);
                    request.setAttribute("genderU", genderU);
                    request.setAttribute("roleU", roleU);
                    request.setAttribute("statusU", statusU);
                    request.setAttribute("name", name);
                    request.setAttribute("email", email);
                    request.setAttribute("phone", phone);

                    request.getRequestDispatcher("Admin/UserListAdmin.jsp").forward(request, response);
                } else {
                    response.sendRedirect("Login");
                }
            } else {
                response.sendRedirect("Login");
            }
        } catch (Exception e) {
            Logger.getLogger(UserListAdminController.class.getName()).log(Level.SEVERE, null, e);
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
        processRequest(request, response);
    }

}
