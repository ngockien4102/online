/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Context.ContextDB;
import Dao.IDao.IProductDao;
import Model.ProductDetail;
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
public class ProductDao extends ContextDB implements IProductDao {

    @Override
    public ProductDetail GetProductbyId(int productID) {
        Connection con = null;
        String query = "SELECT p.*, c.NameCategory, b.Discount, s.StartDate, s.EndDate,\n"
                + "  CASE\n"
                + "    WHEN (s.StartDate <= NOW()) AND (s.EndDate >= NOW()) THEN '1'\n"
                + "    ELSE '0'\n"
                + "  END AS IsOnDiscount, IFNULL(SUM(f.RankStar), 0) AS TotalRankStar,\n"
                + "  (SELECT COUNT(*) FROM feedback WHERE ProductId = p.ProductId) AS TotalFeedback,\n"
                + "  IF(ROUND((SELECT AVG(RankStar) FROM feedback WHERE ProductId = p.ProductId), 1) IS NULL, 5,\n"
                + "     ROUND((SELECT AVG(RankStar) FROM feedback WHERE ProductId = p.ProductId), 1)) AS AverageRankStar\n"
                + "FROM products AS p \n"
                + "LEFT JOIN blog AS b ON p.ProductId = b.ProductId\n"
                + "LEFT JOIN slider AS s ON b.SliderId = s.SliderId\n"
                + "JOIN category AS c ON p.CategoryId = c.CategoryId\n"
                + "LEFT JOIN feedback f ON p.ProductId = f.ProductId\n"
                + "WHERE p.Quantity > 0 AND p.Status = 1 and p.ProductId = ?\n"
                + "GROUP BY p.ProductId, c.NameCategory, b.Discount, s.StartDate, s.EndDate";
        try {
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, productID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ProductDetail products = new ProductDetail();
                products.setProductId(rs.getInt("productId"));
                products.setCategoryId(rs.getInt("categoryId"));
                products.setPersonId(rs.getInt("personId"));
                products.setImg1(rs.getString("img1"));
                products.setImg2(rs.getString("img2"));
                products.setImg3(rs.getString("img3"));
                products.setNameProduct(rs.getString("nameProduct"));
                products.setDescribe(rs.getString("describes"));
                products.setQuantity(rs.getInt("quantity"));
                products.setPrice(rs.getFloat("price"));
                products.setCreateDate(rs.getString("createDate"));
                products.setNameCategory(rs.getString("nameCategory"));
                products.setDiscount(rs.getInt("discount"));
                products.setStartDate(rs.getString("startDate"));
                products.setEndDate(rs.getString("endDate"));
                products.setIsOnDiscount(rs.getInt("isOnDiscount"));
                products.setTotalRankStar(rs.getInt("totalRankStar"));
                products.setTotalFeedback(rs.getInt("totalFeedback"));
                products.setAverageRankStar(rs.getInt("averageRankStar"));
                return products;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<ProductDetail> List6NewProduct() {
        Connection con = null;
        List<ProductDetail> list = new ArrayList<ProductDetail>();
        String query = "SELECT p.*, c.NameCategory, b.Discount, s.StartDate, s.EndDate,\n"
                + "  CASE\n"
                + "    WHEN (s.StartDate <= NOW()) AND (s.EndDate >= NOW()) THEN '1'\n"
                + "    ELSE '0'\n"
                + "  END AS IsOnDiscount, IFNULL(SUM(f.RankStar), 0) AS TotalRankStar,\n"
                + "  (SELECT COUNT(*) FROM feedback WHERE ProductId = p.ProductId) AS TotalFeedback,\n"
                + "  IF(ROUND((SELECT AVG(RankStar) FROM feedback WHERE ProductId = p.ProductId), 1) IS NULL, 5,\n"
                + "     ROUND((SELECT AVG(RankStar) FROM feedback WHERE ProductId = p.ProductId), 1)) AS AverageRankStar\n"
                + "FROM products AS p \n"
                + "LEFT JOIN blog AS b ON p.ProductId = b.ProductId\n"
                + "LEFT JOIN slider AS s ON b.SliderId = s.SliderId\n"
                + "JOIN category AS c ON p.CategoryId = c.CategoryId\n"
                + "LEFT JOIN feedback f ON p.ProductId = f.ProductId\n"
                + "WHERE p.Quantity > 0 AND p.Status = 1\n"
                + "GROUP BY p.ProductId, c.NameCategory, b.Discount, s.StartDate, s.EndDate\n"
                + "ORDER BY p.createDate DESC\n"
                + "limit 6;";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ProductDetail products = new ProductDetail();
                products.setProductId(rs.getInt("productId"));
                products.setCategoryId(rs.getInt("categoryId"));
                products.setPersonId(rs.getInt("personId"));
                products.setImg1(rs.getString("img1"));
                products.setImg2(rs.getString("img2"));
                products.setImg3(rs.getString("img3"));
                products.setNameProduct(rs.getString("nameProduct"));
                products.setDescribe(rs.getString("describes"));
                products.setQuantity(rs.getInt("quantity"));
                products.setPrice(rs.getFloat("price"));
                products.setCreateDate(rs.getString("createDate"));
                products.setNameCategory(rs.getString("nameCategory"));
                products.setDiscount(rs.getInt("discount"));
                products.setStartDate(rs.getString("startDate"));
                products.setEndDate(rs.getString("endDate"));
                products.setIsOnDiscount(rs.getInt("isOnDiscount"));
                products.setTotalRankStar(rs.getInt("totalRankStar"));
                products.setTotalFeedback(rs.getInt("totalFeedback"));
                products.setAverageRankStar(rs.getInt("averageRankStar"));

                list.add(products);
            }
        } catch (SQLException e) {
            // Handle any exceptions that occur
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    @Override
    public void updateQuantity(String OrderId) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "UPDATE Products\n"
                + "JOIN Orders ON Products.ProductId = Orders.ProductId\n"
                + "SET Products.Quantity = Products.Quantity - Orders.Quantity\n"
                + "WHERE Orders.OrderId = ?";
        try {
            con = connection;
            ps = con.prepareStatement(query);
            ps.setString(1, OrderId);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    @Override
    public void updateQuantityProduct(String OrderId) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "UPDATE Products\n"
                + "JOIN Orders ON Products.ProductId = Orders.ProductId\n"
                + "SET Products.Quantity = Products.Quantity + Orders.Quantity\n"
                + "WHERE Orders.OrderId = ?";
        try {
            con = connection;
            ps = con.prepareStatement(query);
            ps.setString(1, OrderId);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    @Override
    public int getNumberEndPageProducts() {
        Connection con = null;
        String query = "SELECT COUNT(*) FROM products\n"
                + "where Quantity > 0";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int totalItem = rs.getInt(1);
                int endPage = 0;
                endPage = totalItem / 6;
                if (totalItem % 6 != 0) {
                    endPage++;
                }
                return endPage;
            }
        } catch (SQLException e) {
            // Handle any exceptions that occur
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }

    @Override
    public List<ProductDetail> SearchProducts(String name, Float fromPrice, Float toPrice, int cid, int index) {
        Connection con = null;
        List<ProductDetail> list = new ArrayList<ProductDetail>();
        String query = "with x as (SELECT p.*, c.NameCategory, b.Discount, s.StartDate, s.EndDate,\n"
                + "  CASE\n"
                + "  WHEN (s.StartDate <= NOW()) AND (s.EndDate >= NOW()) THEN '1'\n"
                + "  ELSE '0'\n"
                + "  END AS IsOnDiscount, IFNULL(SUM(f.RankStar), 0) AS TotalRankStar,\n"
                + "  (SELECT COUNT(*) FROM feedback WHERE ProductId = p.ProductId) AS TotalFeedback,\n"
                + "  IF(ROUND((SELECT AVG(RankStar) FROM feedback WHERE ProductId = p.ProductId), 1) IS NULL, 5,\n"
                + "  ROUND((SELECT AVG(RankStar) FROM feedback WHERE ProductId = p.ProductId), 1)) AS AverageRankStar\n"
                + "  FROM products AS p \n"
                + "  LEFT JOIN blog AS b ON p.ProductId = b.ProductId\n"
                + "LEFT JOIN slider AS s ON b.SliderId = s.SliderId\n"
                + "JOIN category AS c ON p.CategoryId = c.CategoryId\n"
                + "LEFT JOIN feedback f ON p.ProductId = f.ProductId\n"
                + "WHERE p.Quantity > 0 AND p.Status = 1\n"
                + "GROUP BY p.ProductId, c.NameCategory, b.Discount, s.StartDate, s.EndDate\n"
                + "ORDER BY p.createDate DESC\n"
                + "LIMIT 6 OFFSET ?)\n"
                + "select * from x where 1=1";
        if (name != null && !name.equals("")) {
            query += " and NameProduct like '%" + name + "%'";
        }
        if (fromPrice != null) {
            query += " and Price >= " + fromPrice;
        }
        if (toPrice != null) {
            query += " and Price <= " + toPrice;
        }
        if (cid != 0) {
            query += " and CategoryId = " + cid;
        }
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, (index - 1) * 6);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ProductDetail products = new ProductDetail();

                products.setProductId(rs.getInt("productId"));
                products.setCategoryId(rs.getInt("categoryId"));
                products.setPersonId(rs.getInt("personId"));
                products.setImg1(rs.getString("img1"));
                products.setImg2(rs.getString("img2"));
                products.setImg3(rs.getString("img3"));
                products.setNameProduct(rs.getString("nameProduct"));
                products.setDescribe(rs.getString("describes"));
                products.setQuantity(rs.getInt("quantity"));
                products.setPrice(rs.getFloat("price"));
                products.setCreateDate(rs.getString("createDate"));
                products.setNameCategory(rs.getString("nameCategory"));
                products.setDiscount(rs.getInt("discount"));
                products.setStartDate(rs.getString("startDate"));
                products.setEndDate(rs.getString("endDate"));
                products.setIsOnDiscount(rs.getInt("isOnDiscount"));
                products.setTotalRankStar(rs.getInt("totalRankStar"));
                products.setTotalFeedback(rs.getInt("totalFeedback"));
                products.setAverageRankStar(rs.getInt("averageRankStar"));
                list.add(products);
            }
        } catch (SQLException e) {
            // Handle any exceptions that occur
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    @Override
    public List<ProductDetail> GetProductbyCategoryId(int cid) {
        Connection con = null;
        List<ProductDetail> list = new ArrayList<ProductDetail>();
        String query = "SELECT p.*, c.NameCategory, b.Discount, s.StartDate, s.EndDate,\n"
                + "  CASE\n"
                + "    WHEN (s.StartDate <= NOW()) AND (s.EndDate >= NOW()) THEN '1'\n"
                + "    ELSE '0'\n"
                + "  END AS IsOnDiscount, IFNULL(SUM(f.RankStar), 0) AS TotalRankStar,\n"
                + "  (SELECT COUNT(*) FROM feedback WHERE ProductId = p.ProductId) AS TotalFeedback,\n"
                + "  IF(ROUND((SELECT AVG(RankStar) FROM feedback WHERE ProductId = p.ProductId), 1) IS NULL, 5,\n"
                + "     ROUND((SELECT AVG(RankStar) FROM feedback WHERE ProductId = p.ProductId), 1)) AS AverageRankStar\n"
                + "FROM products AS p \n"
                + "LEFT JOIN blog AS b ON p.ProductId = b.ProductId\n"
                + "LEFT JOIN slider AS s ON b.SliderId = s.SliderId\n"
                + "JOIN category AS c ON p.CategoryId = c.CategoryId\n"
                + "LEFT JOIN feedback f ON p.ProductId = f.ProductId\n"
                + "WHERE p.Quantity > 0 AND p.Status = 1 and c.CategoryId = ?\n"
                + "GROUP BY p.ProductId, c.NameCategory, b.Discount, s.StartDate, s.EndDate\n"
                + "ORDER BY createDate DESC;";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, cid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ProductDetail products = new ProductDetail();
                products.setProductId(rs.getInt("productId"));
                products.setCategoryId(rs.getInt("categoryId"));
                products.setPersonId(rs.getInt("personId"));
                products.setImg1(rs.getString("img1"));
                products.setImg2(rs.getString("img2"));
                products.setImg3(rs.getString("img3"));
                products.setNameProduct(rs.getString("nameProduct"));
                products.setDescribe(rs.getString("describes"));
                products.setQuantity(rs.getInt("quantity"));
                products.setPrice(rs.getFloat("price"));
                products.setCreateDate(rs.getString("createDate"));
                products.setNameCategory(rs.getString("nameCategory"));
                products.setDiscount(rs.getInt("discount"));
                products.setStartDate(rs.getString("startDate"));
                products.setEndDate(rs.getString("endDate"));
                products.setIsOnDiscount(rs.getInt("isOnDiscount"));
                products.setTotalRankStar(rs.getInt("totalRankStar"));
                products.setTotalFeedback(rs.getInt("totalFeedback"));
                products.setAverageRankStar(rs.getInt("averageRankStar"));
                list.add(products);
            }
        } catch (SQLException e) {
            // Handle any exceptions that occur
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }
}
