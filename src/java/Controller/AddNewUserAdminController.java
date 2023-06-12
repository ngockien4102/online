/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.AccountDao;
import Dao.IDao.IAccountDao;
import Dao.IDao.IPersonDao;
import Dao.PersonDao;
import Model.Account;
import Model.Person;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author quang
 */
@WebServlet(name = "AddNewUserAdminController", urlPatterns = {"/AddNewUserAdmin"})
public class AddNewUserAdminController extends HttpServlet {

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
        try {
            Account acc = (Account) request.getSession().getAttribute("account");
            if (acc != null) {
                if (acc.getRole() == 0) {
                    request.getRequestDispatcher("Admin/AddNewUserAdmin.jsp").forward(request, response);
                } else {
                    response.sendRedirect("Login");
                }
            } else {
                response.sendRedirect("Login");
            }
        } catch (Exception e) {
            Logger.getLogger(AddNewUserAdminController.class.getName()).log(Level.SEVERE, null, e);
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
        try {
            //---------------ACCOUNT-----------------
            String email = request.getParameter("email");
            int role = Integer.parseInt(request.getParameter("role"));

            //---------------USER-----------------
            String img = request.getParameter("img");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String birthDay = request.getParameter("birthDay");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            int gender = Integer.parseInt(request.getParameter("gender"));
            String startD = request.getParameter("startD");
            String endD = request.getParameter("endD");
            String cccd = request.getParameter("cccd");

            IPersonDao personDao = new PersonDao();
            Account account = new Account(email, role);
            Person person = new Person(img, firstName, lastName, birthDay, phone, address, gender, startD, endD, cccd);

            // add a account and a user
            personDao.AddNewUser(account, person);

            //send new password by email
            int otpvalue = 0;
            HttpSession mySession = request.getSession();
            IAccountDao accountDao = new AccountDao();
            // sending otp
            Random rand = new Random();
            otpvalue = rand.nextInt(1255650);

            String to = email;// change accordingly
            String pass = String.valueOf(otpvalue);

            accountDao.NewPass(pass, to);
            // Get the session object
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");
            Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("huy.tran.mcs@gmail.com", "vsniaxvlebbemeqn");
                }
            });
            // compose message
            try {
                MimeMessage message = new MimeMessage(session);
                message.setFrom(new InternetAddress(email));// change accordingly
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
                message.setSubject("Password for new account from ONLINE SHOP");
                message.setText("Your new password is: " + otpvalue);
                // send message
                Transport.send(message);
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
            request.setAttribute("message", "You have successfully added a new user");

            response.sendRedirect("UserListAdmin");

        } catch (Exception e) {
            Logger.getLogger(AddNewUserAdminController.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
