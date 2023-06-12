/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author MSII
 */
public class Products {

    private int productId;
    private int categoryId;
    private int personId;
    private String img1;
    private String img2;
    private String img3;
    private String nameProduct;
    private String describe;
    private int quantity;
    private float price;
    private String nameCategory;

    public Products() {
    }

    public Products(int productId, int categoryId, int personId, String img1, String img2, String img3, String nameProduct, String describe, int quantity, float price, String nameCategory) {
        this.productId = productId;
        this.categoryId = categoryId;
        this.personId = personId;
        this.img1 = img1;
        this.img2 = img2;
        this.img3 = img3;
        this.nameProduct = nameProduct;
        this.describe = describe;
        this.quantity = quantity;
        this.price = price;
        this.nameCategory = nameCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public String getImg3() {
        return img3;
    }

    public void setImg3(String img3) {
        this.img3 = img3;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Products{" + "productId=" + productId + ", categoryId=" + categoryId + ", saleId=" + personId + ", img1=" + img1 + ", img2=" + img2 + ", img3=" + img3 + ", nameProduct=" + nameProduct + ", describe=" + describe + ", quantity=" + quantity + ", price=" + price + '}';
    }

}
