/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.IDao;

import Model.ProductDetail;
import Model.Products;
import java.util.List;

/**
 *
 * @author MSII
 */
public interface IProductDao {

    //Get end page
    public int getNumberEndPageProducts();

    // get Product by category id
    public List<ProductDetail> GetProductbyCategoryId(int cid);

    // get Product by id
    public ProductDetail GetProductbyId(int id);

    // List  6 new products
    public List<ProductDetail> List6NewProduct();

    // update quantity when customer payorder
    public void updateQuantity(String OrderId);

    // Search products follow name, price, category
    public List<ProductDetail> SearchProducts(String name, Float fromPrice, Float toPrice, int cid, int index);
    // add again quantity product when custom cancel order
    public void updateQuantityProduct(String OrderId);

}
