/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author MSII
 */
public class CartContact {
    private int orderId;    
    private int personId;   
    private int productId;   
    private String orderDate;
    private int quantity;
    private int status;
    private String img1;
    private String nameProduct;  
    private float total;
    private float price;
    private float discount;
    private int pquantity;
    private int isOnDiscount;

    public CartContact() {
    }

    public CartContact(int orderId, int personId, int productId, String orderDate, int quantity, int status, String img1, String nameProduct, float total, float price) {
        this.orderId = orderId;
        this.personId = personId;
        this.productId = productId;
        this.orderDate = orderDate;
        this.quantity = quantity;
        this.status = status;
        this.img1 = img1;
        this.nameProduct = nameProduct;
        this.total = total;
        this.price = price;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public int getIsOnDiscount() {
        return isOnDiscount;
    }

    public void setIsOnDiscount(int isOnDiscount) {
        this.isOnDiscount = isOnDiscount;
    }

    public int getPquantity() {
        return pquantity;
    }

    public void setPquantity(int pquantity) {
        this.pquantity = pquantity;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

   
}
