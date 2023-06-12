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
public class Feedback {
    private int personId;   
    private int productId;   
    private String describes;
    private int rankStar;
    private String fimg;
    private String dateFeedBack;
    private String firstName;
    private String lastName;
    private String img;
    private int status;

    public Feedback() {
    }

    public Feedback(int personId, int productId, String describes, int rankStar, String fimg) {
        this.personId = personId;
        this.productId = productId;
        this.describes = describes;
        this.rankStar = rankStar;
        this.fimg = fimg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

    public int getRankStar() {
        return rankStar;
    }

    public void setRankStar(int rankStar) {
        this.rankStar = rankStar;
    }

    public String getFimg() {
        return fimg;
    }

    public void setFimg(String fimg) {
        this.fimg = fimg;
    }

    public String getDateFeedBack() {
        return dateFeedBack;
    }

    public void setDateFeedBack(String dateFeedBack) {
        this.dateFeedBack = dateFeedBack;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Feedback{" + "personId=" + personId + ", productId=" + productId + ", describes=" + describes + ", rankStar=" + rankStar + ", fimg=" + fimg + ", dateFeedBack=" + dateFeedBack + ", firstName=" + firstName + ", lastName=" + lastName + ", img=" + img + ", status=" + status + '}';
    }

    
}
