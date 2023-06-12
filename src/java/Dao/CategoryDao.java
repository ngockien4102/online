/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Context.ContextDB;
import Dao.IDao.ICategoryDao;
import Model.Category;
import Model.Products;
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
public class CategoryDao extends ContextDB implements ICategoryDao {

    @Override
    public List<Category> ListAllCategory() {
        Connection con = null;
        List<Category> list = new ArrayList<Category>();
        String query = "SELECT * FROM category";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setCategoryId(rs.getInt("categoryId"));
                category.setNameCategory(rs.getString("nameCategory"));
                category.setImg(rs.getString("img"));

                list.add(category);
            }
        } catch (SQLException e) {
            // Handle any exceptions that occur
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, e);
        } finally {
           
        }
        return list;
    }
}
