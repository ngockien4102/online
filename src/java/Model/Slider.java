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
public class Slider {
    private int sliderId;
    private String title;
    private String img;
    private int marketingId;
    private String describes;
    private String startDate;
    private String endDate;
    private String firstName; 
    private String lastName;
    private String mimg;
    private int statu;

    public Slider() {
    }

    public Slider(int sliderId, String title, String img, int marketingId, String describes, String startDate, String endDate) {
        this.sliderId = sliderId;
        this.title = title;
        this.img = img;
        this.marketingId = marketingId;
        this.describes = describes;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getStatu() {
        return statu;
    }

    public void setStatu(int statu) {
        this.statu = statu;
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

    public String getMimg() {
        return mimg;
    }

    public void setMimg(String mimg) {
        this.mimg = mimg;
    }

    public int getSliderId() {
        return sliderId;
    }

    public void setSliderId(int sliderId) {
        this.sliderId = sliderId;
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

    @Override
    public String toString() {
        return "Slider{" + "sliderId=" + sliderId + ", title=" + title + ", img=" + img + ", marketingId=" + marketingId + ", describes=" + describes + ", startDate=" + startDate + ", endDate=" + endDate + '}';
    }
    
}
