/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author quang
 */
public class ProductDetail {

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
    private String createDate;
    private String nameCategory;
    private int discount;
    private String startDate;
    private String endDate;
    private int isOnDiscount;
    private int totalRankStar;
    private int totalFeedback;
    private int averageRankStar;
    

    public ProductDetail() {
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

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getIsOnDiscount() {
        return isOnDiscount;
    }

    public void setIsOnDiscount(int isOnDiscount) {
        this.isOnDiscount = isOnDiscount;
    }

    public int getTotalRankStar() {
        return totalRankStar;
    }

    public void setTotalRankStar(int totalRankStar) {
        this.totalRankStar = totalRankStar;
    }

    public int getTotalFeedback() {
        return totalFeedback;
    }

    public void setTotalFeedback(int totalFeedback) {
        this.totalFeedback = totalFeedback;
    }

    public int getAverageRankStar() {
        return averageRankStar;
    }

    public void setAverageRankStar(int averageRankStar) {
        this.averageRankStar = averageRankStar;
    }

    @Override
    public String toString() {
        return "ProductDetail{" + "productId=" + productId + ", categoryId=" + categoryId + ", personId=" + personId + ", img1=" + img1 + ", img2=" + img2 + ", img3=" + img3 + ", nameProduct=" + nameProduct + ", describe=" + describe + ", quantity=" + quantity + ", price=" + price + ", createDate=" + createDate + ", nameCategory=" + nameCategory + ", discount=" + discount + ", startDate=" + startDate + ", endDate=" + endDate + ", isOnDiscount=" + isOnDiscount + ", totalRankStar=" + totalRankStar + ", totalFeedback=" + totalFeedback + ", averageRankStar=" + averageRankStar + '}';
    }

   
    
}
