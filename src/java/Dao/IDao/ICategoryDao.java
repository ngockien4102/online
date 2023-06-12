/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.IDao;

import Model.Category;
import Model.Products;
import java.util.List;

/**
 *
 * @author MSII
 */
public interface ICategoryDao {
    // List  all category
    public List<Category> ListAllCategory();
}
