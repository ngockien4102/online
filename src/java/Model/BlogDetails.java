/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author quang
 */
public class BlogDetails {

    private int blogId;
    private String title;
    private String img;
    private int marketingId;
    private String describes;
    private int productId;
    private int discount;
    private int sliderId;
    private String dateSubmit;
    private String firstName;
    private String lastName;
    private String imgMarketing;

    public BlogDetails() {
    }

    public BlogDetails(int blogId, String title, String img, int marketingId, String describes, int productId, int discount, int sliderId, String dateSubmit, String firstName, String lastName, String imgMarketing) {
        this.blogId = blogId;
        this.title = title;
        this.img = img;
        this.marketingId = marketingId;
        this.describes = describes;
        this.productId = productId;
        this.discount = discount;
        this.sliderId = sliderId;
        this.dateSubmit = dateSubmit;
        this.firstName = firstName;
        this.lastName = lastName;
        this.imgMarketing = imgMarketing;
    }

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getMarketingId() {
        return marketingId;
    }

    public void setMarketingId(int marketingId) {
        this.marketingId = marketingId;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getSliderId() {
        return sliderId;
    }

    public void setSliderId(int sliderId) {
        this.sliderId = sliderId;
    }

    public String getDateSubmit() {
        return dateSubmit;
    }

    public void setDateSubmit(String dateSubmit) {
        this.dateSubmit = dateSubmit;
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

    public String getImgMarketing() {
        return imgMarketing;
    }

    public void setImgMarketing(String imgMarketing) {
        this.imgMarketing = imgMarketing;
    }

    @Override
    public String toString() {
        return "BlogDetails{" + "blogId=" + blogId + ", title=" + title + ", img=" + img + ", marketingId=" + marketingId + ", describes=" + describes + ", productId=" + productId + ", discount=" + discount + ", sliderId=" + sliderId + ", dateSubmit=" + dateSubmit + ", firstName=" + firstName + ", lastName=" + lastName + ", imgMarketing=" + imgMarketing + '}';
    }
}
