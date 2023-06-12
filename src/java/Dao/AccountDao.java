/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Context.ContextDB;
import Dao.IDao.IAccountDao;
import Model.Account;
import Model.Person;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MSII
 */
public class AccountDao extends ContextDB implements IAccountDao{
    @Override
    public Account checkLogin(String email, String password) {
        String query = "select a.* from Account a\n"
                + "where a.email = ?\n"
                + "and a.password = ?";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = connection;
            ps = con.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                Account account = new Account();
                account.setAccountId(rs.getInt("accountID"));
                account.setEmail(rs.getString("email"));
                account.setPassword(rs.getString("password"));
                account.setRole(rs.getInt("role"));
                return account;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(AccountDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    @Override
    public void Register(String email, String password, Person person) {
        Connection con = null;
        String query = "Insert into Account (email, password, role) values (?, ?, 3)";
        try {
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);
            ps.executeUpdate();
            String querys = "select a.accountId from Account a where a.email = ?";
            PreparedStatement ps1 = con.prepareStatement(querys);
            ps1.setString(1, email);
            ResultSet rs = ps1.executeQuery();
            if(rs.next()) {
                int accountId = rs.getInt(1);
                String query1 = "INSERT INTO Person (AccountId, Img, FirstName, LastName, BirthDate, Phone, Address, Gender, StartDate, EndDate, CCCD) VALUES (?, ?, ?, ?, ?, ?, NULL, ?, SYSDATE(), NULL, NULL)";
                PreparedStatement ps2 = con.prepareStatement(query1);
                ps2.setInt(1, accountId);
                ps2.setString(2, person.getImg());
                ps2.setString(3, person.getFirstName());
                ps2.setString(4, person.getLastName());
                ps2.setString(5, person.getBirthDate());
                ps2.setString(6, person.getPhone());
                ps2.setInt(7, person.getGender());
                ps2.executeUpdate();
            }
        } catch (SQLException e) {
            // Handle any exceptions that occur
            Logger.getLogger(AccountDao.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            // Close the database connection, even if an exception occurred
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(AccountDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public Account checkAccount(String email) {
        String query = "select a.* from Account a\n"
                + "where a.email = ?";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = connection;
            ps = con.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                Account account = new Account();
                account.setAccountId(rs.getInt("accountID"));
                account.setEmail(rs.getString("email"));
                account.setPassword(rs.getString("password"));
                account.setRole(rs.getInt("role"));
                return account;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        }
        return null;
    }
    @Override
    public void ChangePass(String pass, int accountID) {
        String query = "update Account set password = '"+pass+"' where accountID = "+accountID+"";
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = connection;
            ps = con.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(AccountDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    @Override
    public Account getCustomerByEmail(String email) {
        String query = "select a.* from Account a\n"
                + "where a.email = ?";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = connection;
            ps = con.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                Account account = new Account();
                account.setAccountId(rs.getInt("accountID"));
                account.setEmail(rs.getString("email"));
                account.setPassword(rs.getString("password"));
                account.setRole(rs.getInt("role"));
                return account;
            }
        } catch (Exception e) {
        }
        return null;
    }
    @Override
    public void NewPass(String passwork, String email) {
        Connection con = null;
        PreparedStatement ps = null;
        String query = "UPDATE Account set password = ? where email = ?";
        try {
            con = connection;
            ps = con.prepareStatement(query);
            ps.setString(1, passwork);
            ps.setString(2, email);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    public static void main(String[] args) {
        AccountDao a = new AccountDao();
        Person person = new Person("aeds", "qưeqw", "qưewq", "2002-03-02", "adasd", 0);
        a.Register("tes", "123", person);
    }
}

