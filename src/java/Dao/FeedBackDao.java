/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Context.ContextDB;
import Dao.IDao.IFeedBackDao;
import Model.Feedback;
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
public class FeedBackDao extends ContextDB implements IFeedBackDao {

    @Override
    public Feedback CheckFeedBack(int productId, int personId) {
        Connection con = null;
        String query = "SELECT f.*, o.status\n"
                + "FROM products p LEFT JOIN feedback f ON p.productId = f.productId \n"
                + "LEFT JOIN Person c ON p.PersonId = c.PersonId\n"
                + "LEFT JOIN orders o ON o.ProductId = p.ProductId\n"
                + "WHERE o.ProductId = ? AND o.PersonId = ? AND o.status = 4\n"
                + "ORDER BY o.orderId DESC limit 1;";
        try {
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, productId);
            ps.setInt(2, personId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Feedback feedback = new Feedback();
                feedback.setPersonId(rs.getInt("personId"));
                feedback.setProductId(rs.getInt("productId"));
                feedback.setDescribes(rs.getString("describes"));
                feedback.setRankStar(rs.getInt("rankStar"));
                feedback.setFimg(rs.getString("fimg"));
                feedback.setDateFeedBack(rs.getString("dateFeedBack"));
                feedback.setStatus(rs.getInt("status"));
                return feedback;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FeedBackDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        }
        return null;
    }

    @Override
    public void FeedBackProduct(Feedback feedback) {
        Connection con = null;
        String query = "insert into feedback (PersonId, ProductId, Describes, RankStar, fimg, dateFeedBack) values (?, ?, ?, ?, ?, sysdate())";
        try {
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, feedback.getPersonId());
            ps.setInt(2, feedback.getProductId());
            ps.setString(3, feedback.getDescribes());
            ps.setInt(4, feedback.getRankStar());
            ps.setString(5, feedback.getFimg());
            ps.executeUpdate();
        } catch (SQLException e) {
            // Handle any exceptions that occur
            Logger.getLogger(FeedBackDao.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            // Close the database connection, even if an exception occurred
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(FeedBackDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public List<Feedback> ListFeedBack(int productId) {
        List<Feedback> list = new ArrayList<>();
        Connection con = null;
        String query = "select f.*, p.firstName, p.lastName, p.img\n"
                + "from feedback f, person p\n"
                + "where f.PersonId = p.PersonId and f.ProductId = ?";
        try {
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, productId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Feedback feedback = new Feedback();
                feedback.setPersonId(rs.getInt("personId"));
                feedback.setProductId(rs.getInt("productId"));
                feedback.setDescribes(rs.getString("describes"));
                feedback.setRankStar(rs.getInt("rankStar"));
                feedback.setFimg(rs.getString("fimg"));
                feedback.setDateFeedBack(rs.getString("dateFeedBack"));
                feedback.setFirstName(rs.getString("firstName"));
                feedback.setLastName(rs.getString("lastName"));
                feedback.setImg(rs.getString("img"));
                list.add(feedback);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FeedBackDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        }
        return list;
    }
}
