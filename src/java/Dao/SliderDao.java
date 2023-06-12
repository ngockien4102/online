/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Context.ContextDB;
import Dao.IDao.ISliderDao;
import Model.Slider;
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
public class SliderDao extends ContextDB implements ISliderDao {

    @Override
    public List<Slider> ListAllSlider() {
        Connection con = null;
        List<Slider> list = new ArrayList<Slider>();
        String query = "SELECT * FROM slider\n"
                + "Where sysdate() between StartDate and EndDate\n"
                + "Order by StartDate\n"
                + "DESC";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Slider slider = new Slider();
                slider.setSliderId(rs.getInt("sliderId"));
                slider.setTitle(rs.getString("title"));
                slider.setImg(rs.getString("img"));
                slider.setMarketingId(rs.getInt("marketingId"));
                slider.setDescribes(rs.getString("describes"));
                slider.setStartDate(rs.getString("startDate"));
                slider.setEndDate(rs.getString("endDate"));

                list.add(slider);
            }
        } catch (SQLException e) {
            // Handle any exceptions that occur
            Logger.getLogger(SliderDao.class.getName()).log(Level.SEVERE, null, e);
        } finally {
        }
        return list;
    }

    @Override
    public List<Slider> ListAllSliderMKT() {
        Connection con = null;
        List<Slider> list = new ArrayList<Slider>();
        String query = "SELECT s.*, m.firstName, m.lastName, m.img AS mimg,\n"
                + "    CASE WHEN s.endDate <= sysdate() THEN '0' ELSE '1' END AS statu\n"
                + "FROM Slider s\n"
                + "JOIN Marketing m ON s.marketingId = m.marketingId\n"
                + "ORDER BY s.endDate DESC;";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Slider slider = new Slider();
                slider.setSliderId(rs.getInt("sliderId"));
                slider.setTitle(rs.getString("title"));
                slider.setImg(rs.getString("img"));
                slider.setMarketingId(rs.getInt("marketingId"));
                slider.setDescribes(rs.getString("describes"));
                slider.setStartDate(rs.getString("startDate"));
                slider.setEndDate(rs.getString("endDate"));
                slider.setFirstName(rs.getString("firstName"));
                slider.setLastName(rs.getString("lastName"));
                slider.setMimg(rs.getString("mimg"));
                slider.setStatu(rs.getInt("statu"));
                list.add(slider);
            }
        } catch (SQLException e) {
            // Handle any exceptions that occur
            Logger.getLogger(SliderDao.class.getName()).log(Level.SEVERE, null, e);
        } finally {
        }
        return list;
    }

    @Override
    public List<Slider> SliderSatus(int status) {
        Connection con = null;
        List<Slider> list = new ArrayList<Slider>();
        String query = "SELECT s.*, m.firstName, m.lastName, m.img AS mimg,\n"
                + "    CASE WHEN s.endDate <= sysdate() THEN '0' ELSE '1' END AS statu\n"
                + "FROM Slider s\n"
                + "JOIN Marketing m ON s.marketingId = m.marketingId\n"
                + "where CASE WHEN s.enddate <= sysdate() THEN '0' ELSE '1' END IN (?)\n"
                + "ORDER BY s.endDate DESC;";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, status);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Slider slider = new Slider();
                slider.setSliderId(rs.getInt("sliderId"));
                slider.setTitle(rs.getString("title"));
                slider.setImg(rs.getString("img"));
                slider.setMarketingId(rs.getInt("marketingId"));
                slider.setDescribes(rs.getString("describes"));
                slider.setStartDate(rs.getString("startDate"));
                slider.setEndDate(rs.getString("endDate"));
                slider.setFirstName(rs.getString("firstName"));
                slider.setLastName(rs.getString("lastName"));
                slider.setMimg(rs.getString("mimg"));
                slider.setStatu(rs.getInt("statu"));
                list.add(slider);
            }
        } catch (SQLException e) {
            // Handle any exceptions that occur
            Logger.getLogger(SliderDao.class.getName()).log(Level.SEVERE, null, e);
        } finally {
        }
        return list;
    }

    @Override
    public List<Slider> ListPersonCreate(int personId) {
        Connection con = null;
        List<Slider> list = new ArrayList<Slider>();
        String query = "SELECT s.*, m.firstName, m.lastName, m.img AS mimg,\n"
                + "CASE WHEN s.endDate <= sysdate() THEN '0' ELSE '1' END AS statu\n"
                + "FROM Slider s\n"
                + "JOIN Marketing m ON s.marketingId = m.marketingId\n"
                + "WHERE s.marketingId = ?\n"
                + "ORDER BY s.endDate DESC;";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, personId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Slider slider = new Slider();
                slider.setSliderId(rs.getInt("sliderId"));
                slider.setTitle(rs.getString("title"));
                slider.setImg(rs.getString("img"));
                slider.setMarketingId(rs.getInt("marketingId"));
                slider.setDescribes(rs.getString("describes"));
                slider.setStartDate(rs.getString("startDate"));
                slider.setEndDate(rs.getString("endDate"));
                slider.setFirstName(rs.getString("firstName"));
                slider.setLastName(rs.getString("lastName"));
                slider.setMimg(rs.getString("mimg"));
                slider.setStatu(rs.getInt("statu"));
                list.add(slider);
            }
        } catch (SQLException e) {
            // Handle any exceptions that occur
            Logger.getLogger(SliderDao.class.getName()).log(Level.SEVERE, null, e);
        } finally {
        }
        return list;
    }

    @Override
    public List<Slider> SeachTitleSilder(String title) {
        Connection con = null;
        List<Slider> list = new ArrayList<Slider>();
        String query = "SELECT s.*, m.firstName, m.lastName, m.img AS mimg,\n"
                + "CASE WHEN s.endDate <= sysdate() THEN '0' ELSE '1' END AS statu\n"
                + "FROM Slider s\n"
                + "JOIN Marketing m ON s.marketingId = m.marketingId\n"
                + "WHERE s.title like ?\n"
                + "ORDER BY s.endDate DESC;";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, "%" + title + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Slider slider = new Slider();
                slider.setSliderId(rs.getInt("sliderId"));
                slider.setTitle(rs.getString("title"));
                slider.setImg(rs.getString("img"));
                slider.setMarketingId(rs.getInt("marketingId"));
                slider.setDescribes(rs.getString("describes"));
                slider.setStartDate(rs.getString("startDate"));
                slider.setEndDate(rs.getString("endDate"));
                slider.setFirstName(rs.getString("firstName"));
                slider.setLastName(rs.getString("lastName"));
                slider.setMimg(rs.getString("mimg"));
                slider.setStatu(rs.getInt("statu"));
                list.add(slider);
            }
        } catch (SQLException e) {
            // Handle any exceptions that occur
            Logger.getLogger(SliderDao.class.getName()).log(Level.SEVERE, null, e);
        } finally {
        }
        return list;
    }

    @Override
    public Slider SliderDetail(int sliderId) {
        Connection con = null;
        String query = "SELECT s.*, m.firstName, m.lastName, m.img AS mimg,\n"
                + "CASE WHEN s.endDate <= sysdate() THEN '0' ELSE '1' END AS statu\n"
                + "FROM Slider s\n"
                + "JOIN Marketing m ON s.marketingId = m.marketingId\n"
                + "WHERE s.sliderId = ?\n"
                + "ORDER BY s.endDate DESC;";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, sliderId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Slider slider = new Slider();
                slider.setSliderId(rs.getInt("sliderId"));
                slider.setTitle(rs.getString("title"));
                slider.setImg(rs.getString("img"));
                slider.setMarketingId(rs.getInt("marketingId"));
                slider.setDescribes(rs.getString("describes"));
                slider.setStartDate(rs.getString("startDate"));
                slider.setEndDate(rs.getString("endDate"));
                slider.setFirstName(rs.getString("firstName"));
                slider.setLastName(rs.getString("lastName"));
                slider.setMimg(rs.getString("mimg"));
                slider.setStatu(rs.getInt("statu"));
                return slider;
            }
        } catch (SQLException e) {
            // Handle any exceptions that occur
            Logger.getLogger(SliderDao.class.getName()).log(Level.SEVERE, null, e);
        } finally {
        }
        return null;
    }
    @Override
    public void UpdateSlider(String Title, String Img, String Describes, String startdate, String enddate, int sliderId) {
        Connection con = null;
        String query = "update slider set title = ?, Img = ?, Describes = ?, startdate = ?, enddate = ? where sliderId = ?";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, Title);
            ps.setString(2, Img);
            ps.setString(3, Describes);
            ps.setString(4, startdate);
            ps.setString(5, enddate);
            ps.setInt(6, sliderId);
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

    public static void main(String[] args) {
        SliderDao a = new SliderDao();
        List<Slider> s = a.SeachTitleSilder("s");
        for (Slider slider : s) {
            System.out.println(slider.toString());
        }

    }
}
