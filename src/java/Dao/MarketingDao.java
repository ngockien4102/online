/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Context.ContextDB;
import Dao.IDao.IMarketingDao;
import Model.Marketing;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MSII
 */
public class MarketingDao extends ContextDB implements IMarketingDao{
    @Override
    public Marketing ProfileMarketing (int accountId){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "select p.* from Marketing p where p.accountID = ? and Status = 1";
        try{
            con = connection;
            ps = con.prepareStatement(query);
            ps.setInt(1, accountId);
            rs = ps.executeQuery();
            while(rs.next()) {
                Marketing market = new Marketing();
                market.setMarketingId(rs.getInt("marketingId"));
                market.setAccountId(rs.getInt("accountId"));
                market.setFirstName(rs.getString("firstName"));
                market.setLastName(rs.getString("lastName"));
                market.setPhone(rs.getString("phone"));
                market.setAddress(rs.getString("address"));
                market.setGender(rs.getInt("gender"));
                market.setBirthdate(rs.getString("birthdate"));
                market.setSalary(rs.getFloat("salary"));
                market.setYearOfExp(rs.getInt("yearOfExp"));
                market.setStartDate(rs.getString("startDate"));
                market.setEndDate(rs.getString("endDate"));
                market.setCccd(rs.getString("cccd"));
                market.setImg(rs.getString("Img"));
                market.setStatus(rs.getInt("status"));
                return market;
            }
        }catch(SQLException ex) {
            Logger.getLogger(MarketingDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
        }
        return null;
    }

    @Override
    public void RegisterMarketing(int accountId, String firstName, String lastName, String phone, String address, int gender, String birthdate, String cccd, String Img) {
        Connection con = null;
        String query = "INSERT INTO marketing (Img, AccountId, FirstName, LastName, Phone, Address, Gender, Birthdate, Salary, YearOfExp, StartDate, EndDate, CCCD) VALUES ('"+Img+"', "+accountId+", '"+firstName+"', '"+lastName+"', '"+phone+"', '"+address+"', "+gender+", '"+birthdate+"', 0, 0, CURRENT_DATE(), DATE_ADD(CURRENT_DATE(), INTERVAL 1 YEAR), '"+cccd+"')";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException e) {
            // Handle any exceptions that occur
            Logger.getLogger(MarketingDao.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            // Close the database connection, even if an exception occurred
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(MarketingDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    @Override
    public void UpdateMKT(int mktId, String firstName, String lastName, String phone, String address, int gender, String birthdate, String Img) {
        Connection con = null;
        String query = "update marketing set img = ?, FirstName = ?, lastName = ?, phone = ?, address = ?, gender = ?, birthdate = ? where marketingId = ?";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, Img);
            ps.setString(2, firstName);
            ps.setString(3, lastName);
            ps.setString(4, phone);
            ps.setString(5, address);
            ps.setInt(6, gender);
            ps.setString(7, birthdate);
            ps.setInt(8, mktId);
            ps.executeUpdate();
        } catch (SQLException e) {
            // Handle any exceptions that occur
            Logger.getLogger(MarketingDao.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            // Close the database connection, even if an exception occurred
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(MarketingDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    @Override
    public List<Marketing> ListAuthor (){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Marketing> list = new ArrayList<Marketing>();
        String query = "select p.* from Marketing p";
        try{
            con = connection;
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()) {
                Marketing market = new Marketing();
                market.setMarketingId(rs.getInt("marketingId"));
                market.setAccountId(rs.getInt("accountId"));
                market.setFirstName(rs.getString("firstName"));
                market.setLastName(rs.getString("lastName"));
                market.setPhone(rs.getString("phone"));
                market.setAddress(rs.getString("address"));
                market.setGender(rs.getInt("gender"));
                market.setBirthdate(rs.getString("birthdate"));
                market.setSalary(rs.getFloat("salary"));
                market.setYearOfExp(rs.getInt("yearOfExp"));
                market.setStartDate(rs.getString("startDate"));
                market.setEndDate(rs.getString("endDate"));
                market.setCccd(rs.getString("cccd"));
                market.setImg(rs.getString("Img"));
                market.setStatus(rs.getInt("status"));
                list.add(market);
            }
        }catch(SQLException ex) {
            Logger.getLogger(MarketingDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(MarketingDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }
    public static void main(String[] args) {
        MarketingDao m = new MarketingDao();
        m.UpdateMKT(1, "hello", "test", "0987654321", "30 nguyen cong tru", 1, "1998-09-03", "avt.jpg");
    }
}
