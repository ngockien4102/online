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
public class Orders {
    private int orderId;    
    private int personId;   
    private int productId;   
    private String orderDate;
    private int quantity;
    private int status;

    public Orders() {
    }

    public Orders(int orderId, int personId, int productId, String orderDate, int quantity, int status) {
        this.orderId = orderId;
        this.personId = personId;
        this.productId = productId;
        this.orderDate = orderDate;
        this.quantity = quantity;
        this.status = status;
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

    @Override
    public String toString() {
        return "Orders{" + "orderId=" + orderId + ", personId=" + personId + ", productId=" + productId + ", orderDate=" + orderDate + ", quantity=" + quantity + ", status=" + status + '}';
    }

}

