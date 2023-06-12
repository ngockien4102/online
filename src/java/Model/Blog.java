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
public class Blog {
    private int blogId;
    private String title;
    private String img;
    private int marketingId;
    private String describes;
    private int productId;
    private int discount;
    private int sliderId;
    private String dateSubmit;

    public Blog() {
    }

    public Blog(int blogId, String title, String img, int marketingId, String describes, int productId, int discount, int sliderId, String dateSubmit) {
        this.blogId = blogId;
        this.title = title;
        this.img = img;
        this.marketingId = marketingId;
        this.describes = describes;
        this.productId = productId;
        this.discount = discount;
        this.sliderId = sliderId;
        this.dateSubmit = dateSubmit;
    }

    public Blog(String title, String img, int marketingId, String describes, int productId, int discount, int sliderId) {
        this.title = title;
        this.img = img;
        this.marketingId = marketingId;
        this.describes = describes;
        this.productId = productId;
        this.discount = discount;
        this.sliderId = sliderId;
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

    @Override
    public String toString() {
        return "Blog{" + "blogId=" + blogId + ", title=" + title + ", img=" + img + ", marketingId=" + marketingId + ", describes=" + describes + ", productId=" + productId + ", discount=" + discount + ", sliderId=" + sliderId + ", dateSubmit=" + dateSubmit + '}';
    }
}
