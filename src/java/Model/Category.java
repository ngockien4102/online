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
public class Category {
    private int categoryId;
    private String nameCategory;  
    private String img;

    public Category() {
    }

    public Category(int categoryId, String nameCategory, String img) {
        this.categoryId = categoryId;
        this.nameCategory = nameCategory;
        this.img = img;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Category{" + "categoryId=" + categoryId + ", nameCategory=" + nameCategory + ", img=" + img + '}';
    }
    
}
