/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author quang
 */
public class OrderSale {

    private int orderId;
    private String img1;
    private String nameProduct;
    private String orderDate;
    private int saleId;
    private int status;
    private int quantity;
    private int customerId;
    private String firstName;
    private String lastName;
    private float total_cost;
    private String nameCategory;
    private float price;
    private int gender;
    private String address;
    private String phone;
    private String email;
    private String notes;
    private String status_Order;
    private int count;
    private float AverageRankStar;

    public OrderSale() {
    }

    public OrderSale(int orderId, int status, String notes) {
        this.orderId = orderId;
        this.status = status;
        this.notes = notes;
    }

    public float getAverageRankStar() {
        return AverageRankStar;
    }

    public void setAverageRankStar(float AverageRankStar) {
        this.AverageRankStar = AverageRankStar;
    }

    public String getStatus_Order() {
        return status_Order;
    }

    public void setStatus_Order(String status_Order) {
        this.status_Order = status_Order;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
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

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public float getTotal_cost() {
        return total_cost;
    }

    public void setTotal_cost(float total_cost) {
        this.total_cost = total_cost;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "OrderSale{" + "orderId=" + orderId + ", img1=" + img1 + ", nameProduct=" + nameProduct + ", orderDate=" + orderDate + ", saleId=" + saleId + ", status=" + status + ", quantity=" + quantity + ", customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + ", total_cost=" + total_cost + ", nameCategory=" + nameCategory + ", price=" + price + ", gender=" + gender + ", address=" + address + ", phone=" + phone + ", email=" + email + ", notes=" + notes + ", status_Order=" + status_Order + ", count=" + count + ", AverageRankStar=" + AverageRankStar + '}';
    }

}
